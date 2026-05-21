package com.example.lambdas8;

import java.util.function.BiFunction;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {

        BiFunction<Double,Double,Double> bifunc = (prise, discount) -> prise* (1 - discount / 100);

        BiConsumer<String, Double> biConsumer = (name, price) -> System.out.println(name + " : " + price + "руб.");

        double price = bifunc.apply(5000.00, 15.00);

        biConsumer.accept("Ноутбук" , price);

    }
}
