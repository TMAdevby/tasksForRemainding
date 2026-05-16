package com.example.fifth_Generics_2;

public class Main {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Привет!");
        System.out.println(box1);
        Box<Integer> box2 = new Box<>(42);
        System.out.println(box2);
        box1.setValue("Java Generics");
        System.out.println(box1);

        Box<String> strBox = new Box<>("Hello");
        Box<Double> numBox = strBox.transform(3.14);

        Integer res = GenericUtils.printAndReturn(100);
        System.out.println(numBox);
        System.out.println(res);

        var max1 = GenericUtils.findMax("Apple", "Banana");
        System.out.println(max1);
        var max2 = GenericUtils.findMax(10, 25);
        System.out.println(max2);
    }
}
