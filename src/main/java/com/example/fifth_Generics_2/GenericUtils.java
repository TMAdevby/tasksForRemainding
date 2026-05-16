package com.example.fifth_Generics_2;

public class GenericUtils {

    public static <T> T printAndReturn(T item){
        System.out.println("Returned: " + item);
        return item;
    }
}
