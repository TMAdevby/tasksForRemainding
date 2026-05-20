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

    }
}
