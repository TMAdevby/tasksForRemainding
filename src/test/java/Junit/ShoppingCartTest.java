package Junit;

import com.example.Junit_Testing.Product;
import com.example.Junit_Testing.ShoppingCart;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp(){
        shoppingCart = new ShoppingCart();
    }

    //Hamcrest
    @Test
    @DisplayName("Добавление продукта: корректные данные -> товар добавлен")
    public void addProduct_correctData_productAdded(){

        String name = "Хлеб";
        double price = 3.2;
        int quantity = 100;
        Product expectedProduct = new Product("Хлеб",3.2,100);

        shoppingCart.addProduct(name,price,quantity);

        assertThat(shoppingCart.getItems(), hasSize(1));
        assertThat(shoppingCart.getItems().get(0), equalTo(expectedProduct));
    }

    //Hamcrest
    @Test
    @DisplayName("Добавление того же товара: количество увеличивается -> нет дубликата в списке")
    public void addProduct_sameProduct_increasedQuantity_noDouble(){

        String name = "Хлеб";
        double price = 3.2;
        int firstQuantity = 100;
        int secondQuantity = 50;

        shoppingCart.addProduct(name,price, firstQuantity);
        shoppingCart.addProduct(name,price, secondQuantity);

        assertThat(shoppingCart.getItems(), hasSize(1));

        Product productInCart = new Product("Хлеб",3.2,150);

        assertThat(shoppingCart.getItems().get(0).getQuantity(),equalTo(150));
        assertThat(shoppingCart.getItems().get(0), equalTo(productInCart));
    }

    @Test
    @DisplayName("Название с пробелами -> выбрасывает IllegalArgumentException")
    public void addProduct_nameWithBlanc_throwIllegalArgumentException(){

        String name = "  ";
        double price = 5.2;
        int quantity = 100;

        assertThatThrownBy(() -> shoppingCart.addProduct(name, price, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Название товара не может быть пустым");
    }

    @Test
    @DisplayName("Цена 0 или отрицательна -> выбрасывает IllegalArgumentException")
    public void addProduct_priceZeroOrMinus_throwIllegalArgumentException(){

        String name = "Хлеб";
        double price = 0.0;
        double price2 = -5.2;
        int quantity = 100;

        assertThatThrownBy(() -> shoppingCart.addProduct(name, price, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Цена должна быть больше нуля");
        assertThatThrownBy(() -> shoppingCart.addProduct(name, price2, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Цена должна быть больше нуля");
    }

    @Test
    @DisplayName("Цена 0 или отрицательна -> выбрасывает IllegalArgumentException")
    public void addProduct_quantityZeroOrMinus_throwIllegalArgumentException(){

        String name = "Хлеб";
        double price = 3.0;
        int quantity = 0;
        int quantity2 = -5;

        assertThatThrownBy(() -> shoppingCart.addProduct(name, price, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Количество должно быть больше нуля");
        assertThatThrownBy(() -> shoppingCart.addProduct(name, price, quantity2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Количество должно быть больше нуля");
    }

    @Test
    @DisplayName("Удаление товара в нижнем регистре")
    public void removeProductByName_lowercase() {
        shoppingCart.addProduct("Хлеб", 3.0, 100);

        boolean result = shoppingCart.removeProductByName("хлеб");

        assertThat(result).isTrue();
        assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    @DisplayName("Удаление товара в смешанном регистре")
    public void removeProductByName_mixedCase() {
        shoppingCart.addProduct("Хлеб", 3.0, 100);

        boolean result = shoppingCart.removeProductByName("хЛеб");

        assertThat(result).isTrue();
        assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    @DisplayName("Удаление товара которого нет в списке")
    public void removeProductByName_productIsNotInList() {
        shoppingCart.addProduct("Хлеб", 3.0, 100);

        boolean result = shoppingCart.removeProductByName("Молоко");

        assertThat(result).isFalse();
        assertThat(shoppingCart.getItems()).hasSize(1);
    }

    @Test
    @DisplayName("Удаление товара которого нет в списке")
    public void removeProductByName_productIsNullOrBlanc() {
        shoppingCart.addProduct("Хлеб", 3.0, 100);

        boolean result = shoppingCart.removeProductByName(null);

        boolean result2 = shoppingCart.removeProductByName("   ");

        assertThat(result).isFalse();
        assertThat(result2).isFalse();
        assertThat(shoppingCart.getItems()).hasSize(1);
    }
}
