package com.example.fifth_Generics_2;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Dog> doglist = new ArrayList<>();
        doglist.add(new Dog("Шарик"));
        doglist.add(new Dog("Тузик"));
        List<Cat> catlist = new ArrayList<>();
        catlist.add(new Cat("Бася"));
        catlist.add(new Cat("Бяша"));

        GenericUtils.printAll(doglist);
        GenericUtils.printAll(catlist);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Camel"));

        GenericUtils.addAnimals(animalList,doglist);

    }
}
