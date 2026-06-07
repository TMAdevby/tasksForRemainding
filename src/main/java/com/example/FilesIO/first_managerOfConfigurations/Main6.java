package com.example.FilesIO.first_managerOfConfigurations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Main6 {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        createFile("nio");
        writeToFile("nio", "Привет");
        writeToFile("nio", "Как дела?");
        writeToFile("nio", "Как успехи?");
        list = readFile("nio");
        copyFile("nio","copy");
        renameFile("nio", "nio2");
    }

    public static void createFile(String name){
        Path file = Paths.get(name);
        if(!Files.exists(file)){
            try {
                Files.createFile(Path.of(name));
                System.out.println("Файл " + name + " создан");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writeToFile(String file, String line) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFile(String name){
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Path.of(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(String str: list){
            System.out.println(str);
        }
        return list;
    }

    public static void copyFile(String name, String newName){
        Path file = Paths.get(name);
        Path destFile = Paths.get(newName);
        if(Files.exists(file) && !Files.exists(destFile)){
            try {
                Files.copy(Path.of(name), Path.of(newName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Файл не существует");
        }
    }

    public static void renameFile (String name, String newName){
        Path file = Paths.get(name);
        if(Files.exists(file)){
            try {
                Files.move(Path.of(name), Path.of(newName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
