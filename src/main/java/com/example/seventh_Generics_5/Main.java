package com.example.seventh_Generics_5;

public class Main {
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("Максим", 41);
        System.out.println(pair1);

        Pair<Integer, String> pair2 = pair1.swap();
        System.out.println(pair2);

        Pair<Double,Boolean> pair3 = Pair.pairCreate(41.00,true);
        System.out.println(pair3);

        Pair<String,String> pair4 = Pair.pairCreate("Типун", "Максим");
        System.out.println(pair4);
    }
}
