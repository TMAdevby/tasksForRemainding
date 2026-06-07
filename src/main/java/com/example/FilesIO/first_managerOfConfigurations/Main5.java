package com.example.FilesIO.first_managerOfConfigurations;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.File;
import java.io.IOException;

public class Main5 {
    public static void main(String[] args) {
        createFile("data.bin");

    }

    public static void createFile(String name){
        File file = new File(name);
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("Файл " + name + " создан");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    pu
}
