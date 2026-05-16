package com.example.fifth_Generics_2;

import java.util.List;

public class GenericUtils {

    public static <T> T printAndReturn(T item){
        System.out.println("Returned: " + item);
        return item;
    }

    public static <T extends Comparable<T>> T findMax(T a, T b){
        T max = a.compareTo(b) > 0 ? a : b ;
        return max;
    }

    public static void printAll(List<? extends Animal> animals){
        for(Animal animal : animals){
            System.out.println(animal);
        }
    }

    public static void addAnimals(List<? super Dog> animals, List<Dog> dogsToAdd){
        int num = 0;
        for(Dog animal: dogsToAdd) {
            animals.add(animal);
            num++;
        }
        for(Object animal2 : animals){
            System.out.println(animal2);
        }
        System.out.println("Added " + num + " dogs to list");
    }
}
