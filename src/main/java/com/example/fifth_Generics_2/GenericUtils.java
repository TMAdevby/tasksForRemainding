package com.example.fifth_Generics_2;

public class GenericUtils {

    public static <T> T printAndReturn(T item){
        System.out.println("Returned: " + item);
        return item;
    }

    public static <T extends Comparable<T>> T findMax(T a, T b){
        T max = a.compareTo(b) >= 1 ? a : b ;
        return max;
    }
}
