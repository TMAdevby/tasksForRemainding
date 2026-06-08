package com.example.FilesIO.first_managerOfConfigurations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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

        zip("heroes.dat");

        unzip("heroes_backup.zip");

        deserialize("heroes.dat");
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

    public static void zip(String fileName) {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("heroes_backup.zip"));
            FileInputStream fis = new FileInputStream(fileName)){

            ZipEntry entry1 = new ZipEntry(fileName);
            zout.putNextEntry(entry1);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zout.write(buffer);

            zout.closeEntry();

            Path file = Paths.get(fileName);
            Files.delete(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unzip(String zipName) {
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zipName))){

            ZipEntry entry;
            String name;
            while((entry=zis.getNextEntry())!=null) {
                name = entry.getName();

                FileOutputStream fis = new FileOutputStream(name);

                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fis.write(c);
                }
                fis.flush();
                zis.closeEntry();
                fis.close();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deserialize (String fileName){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            List<Hero> list = (ArrayList)ois.readObject();
            for(Hero hero : list){
                System.out.println("Имя : " + hero.getName() + " уровень : " + hero.getLevel());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }






}
