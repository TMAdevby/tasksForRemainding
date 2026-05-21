package com.example.lambdas2;

@FunctionalInterface
interface NumberDescriber {
    String describe(int num);
}

public class Main {
    public static void printDescription(int n, NumberDescriber describer) {
        System.out.println(describer.describe(n));
    }

    public static void main(String[] args) {

        NumberDescriber nd = num -> {
            if(num % 2 == 0) {
                return "Четное: " + num ;
            }
        else{
            return "Нечетное: " + num ;
        }
        };

        printDescription(4,nd);
        printDescription(7,nd);


    }
}
