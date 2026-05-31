package com.example.FilesIO.first_managerOfConfigurations;

import java.io.File;
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
            logs.append(" Directory " + path + " was not created, try agen .\n");
        }
    }




}
