package com.example.Junit_Testing;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;
    private double discountPercent;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.discountPercent = 0.0;
    }

    // Добавляет товар. Если товар с таким именем и ценой уже есть, увеличивает количество.
    public void addProduct(String name, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название товара не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }

        Product newProduct = new Product(name, price, quantity);
        for (Product item : items) {
            if (item.equals(newProduct)) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(newProduct);
    }

    // Удаляет товар по названию (регистронезависимо)
    public boolean removeProductByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return items.removeIf(item -> item.getName().equalsIgnoreCase(name.trim()));
    }

    // Применяет скидку в процентах
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100");
        }
        this.discountPercent = percent;
    }

    // Считает итоговую сумму с учетом скидки
    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total * (1 - discountPercent / 100);
    }

    // Возвращает общее количество единиц товара в корзине
    public int getTotalItemsCount() {
        return items.stream().mapToInt(Product::getQuantity).sum();
    }

    public List<Product> getItems() {
        return new ArrayList<>(items); // Возвращаем копию для безопасности
    }

    public void clear() {
        items.clear();
        discountPercent = 0.0;
    }
}
