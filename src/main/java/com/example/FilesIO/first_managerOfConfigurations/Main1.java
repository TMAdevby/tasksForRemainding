package com.example.FilesIO.first_managerOfConfigurations;

import java.io.*;
import java.time.LocalDateTime;

public class Main1 {

    private static StringBuilder logs = new StringBuilder();

    public static void main(String[] args) {








    }

    public static void createDirectory(String path){
        File directory = new File(path);
        directory.mkdir();
        LocalDateTime createTime = LocalDateTime.now();

        if(directory.isDirectory() && directory.exists()){
            logs.append("Directory " + path + " has been created in time " + createTime + ".\n");
        }
        else {
            logs.append("Directory " + path + " was not created, try agen .\n");
        }
    }

    public static void createFile(String path) {
        File file = new File(path);

        try {
            file.createNewFile()
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime createTime = LocalDateTime.now();

        if(file.isFile() && file.exists()){
            logs.append("File " + path + " has been created in time " + createTime + ".\n");)
        }
        else {
            logs.append("File " + path + " was not created, try agen .\n");
        }
    }

    public static void writeLogs(){
        try(BufferedWriter br = new BufferedWriter(
                new FileWriter("D:\\Games\\FilesExperements\\temp\\temp.txt"))){
            for (int i = 0; i < logs.length(); i++) {
                br.write(logs.charAt(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Logs have been written");
    }




}
