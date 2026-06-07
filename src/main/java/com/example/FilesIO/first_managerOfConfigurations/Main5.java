package com.example.FilesIO.first_managerOfConfigurations;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.*;

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

    public static void writeToFile(){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"))){
            dos.writeInt(100);
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeUTF("Привет");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
