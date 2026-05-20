package com.example.lambdas1;

@FunctionalInterface
interface StringTransformer {
    String transform(String input);
}

public class Main {
    public static void process(String text, StringTransformer transformer) {
        System.out.println("Результат: " + transformer.transform(text));
    }

    public static void main(String[] args) {

        StringTransformer st = s -> s.toUpperCase();

        Main.process("hello lambda", st);
        // 👇 ТВОЯ ЗАДАЧА:
        // 1. Создай лямбда-выражение, которое переводит строку в ВЕРХНИЙ РЕГИСТР.
        // 2. Вызови метод process, передав строку "hello lambda" и свою лямбду.
    }
}
