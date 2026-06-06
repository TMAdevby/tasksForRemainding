package com.example.FilesIO.first_managerOfConfigurations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        File diaryFile = createDiaryFile("diary.txt");
        createText();
        createText();
        readDiary();
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

    public static void createText(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Сделайте запись в дневнике");
        String line = sc.nextLine();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("diary.txt",true))){
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write("[" + timestamp + "] " + line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readDiary() {
        try(BufferedReader br = new BufferedReader(new FileReader("diary.txt"))) {
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            String line;
            int i = 0;
            int maxLengthI = 0;
            int maxLength = 0;
            while((line = br.readLine()) != null){
                i++;
                if(line.length() > maxLength){
                    maxLength = line.length();
                    maxLengthI = i;
                }
                String [] str = line.split(" ");
                map.put(i,str.length);
                System.out.println(i + ". " + line);

            }
            System.out.println("Количество записей = " + i);
            System.out.println("Самая длинная запись № " + maxLengthI);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " запись " + entry.getValue() + " слов");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
