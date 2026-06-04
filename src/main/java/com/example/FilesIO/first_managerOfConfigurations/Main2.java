package com.example.FilesIO.first_managerOfConfigurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите относительный путь к папке");
        String path = "files2";
        String yourPath = sc.nextLine();

        checkPath(yourPath);
        File file1 = createFileInDirectory(yourPath,"readme.txt");
        File file2 = createFileInDirectory(yourPath,"data.bin");
        File file3 = createFileInDirectory(yourPath,"config.properties");

        getInformation(file1);

    }

    public static void checkPath(String path){

        File yourPath = new File(path);
        if(yourPath.exists()){
            log.info("Папка {} существует", yourPath);
        }
        else {
            yourPath.mkdirs();
            log.debug("Папка {} создана", yourPath);
        }

    }

    public static File createFileInDirectory(String createdDirectory ,String fileName){

        File file = new File(createdDirectory + "\\" + fileName);

        if(file.exists()){
            log.info("Файл уже существует {}", file);
        }else{
            try {
                file.createNewFile();
                log.info("Файл создан {}", file);
            } catch (IOException e) {
                log.warn("Ошибка {} при создании файла {}",e, file);
                throw new RuntimeException(e);
            }
        }

        return file;
    }

    public static void getInformation(File file){
        System.out.printf("Абсолютный путь к файлу : {}" , file.getAbsolutePath());
        System.out.printf("Размер в байтах : {}" , file.length());
        System.out.printf("Дата последнего изменения : {}" , file.lastModified());
        System.out.printf("Права на чтение : {} , pзапись : {}" , file.canRead(), file.canWrite());
        System.out.println("__________________________");
    }
}
