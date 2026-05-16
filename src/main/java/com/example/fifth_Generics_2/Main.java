package com.example.fifth_Generics_2;

public class Main {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Привет!");
        System.out.println(box1);
        Box<Integer> box2 = new Box<>(42);
        System.out.println(box2);
        box1.setValue("Java Generics");
        System.out.println(box1);
    }
}
