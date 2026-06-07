package com.example.FilesIO.first_managerOfConfigurations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main7 {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Илья", 500 , 80,"меч");
        Hero hero2 = new Hero("Человек паук", 300, 65, "паутина");
        Hero hero3 = new Hero("Бетмен", 400, 75, "пистолет");

        List<Hero> list = new ArrayList<>();

        list.add(hero1);
        list.add(hero2);
        list.add(hero3);

        serialize(list);

    }

    public static void serialize (List<Hero> list){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("heroes.dat"))) {
            oos.writeObject(list);
            System.out.println("Лист сериализован");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
}
