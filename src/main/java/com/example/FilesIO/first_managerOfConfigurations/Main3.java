package com.example.FilesIO.first_managerOfConfigurations;

import java.io.File;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        File diaryFile = createDiaryFile("diary.txt");

    }

    public static File createDiaryFile(String fileName){
        File file = new File(fileName);
        if (file.exists()){
            System.out.println("File " + fileName + "already exists");
        }else{
            try {
                file.createNewFile();
                System.out.println("File " + fileName + " has been created");
            } catch (IOException e) {
                System.out.println("File " + fileName + " was not created with exception " + e);
                throw new RuntimeException(e);
            }
        }
        return file;
    }
}
