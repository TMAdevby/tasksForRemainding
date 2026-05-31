package com.example.FilesIO.first_managerOfConfigurations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    private static StringBuilder logs = new StringBuilder();

    public static void main(String[] args) {

        createDirectory("D:\\Games\\FilesExperements\\configs\\active");
        createDirectory("D:\\Games\\FilesExperements\\configs\\backup");
        createDirectory("D:\\Games\\FilesExperements\\configs\\logs");

        createFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg");
        createFile("D:\\Games\\FilesExperements\\configs\\logs\\install.log");

        writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=10");
        writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=20");
        writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=30");
        writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=40");
        writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=50");

        copyFileWithTimestamp("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg",
                "D:\\Games\\FilesExperements\\configs\\backup");

        writeChanges("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg","volume","100");

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
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime createTime = LocalDateTime.now();

        if(file.isFile() && file.exists()){
            logs.append("File " + path + " has been created in time " + createTime + ".\n");
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

    public static void writeToFile(String path, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFileWithTimestamp(String sourcePath, String backupDir) {
        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String originalName = new File(sourcePath).getName();
        int dot = originalName.lastIndexOf('.');
        String name = dot > 0 ? originalName.substring(0, dot) : originalName;
        String ext = dot > 0 ? originalName.substring(dot) : "";
        String newFileName = name + "_backup_" + timestamp + ext;

        File target = new File(backupDir, newFileName);

        try {
            Files.copy(
                    new File(sourcePath).toPath(),
                    target.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println(" Файл скопирован (Files.copy): " + target.getAbsolutePath());
            logs.append("File copied via Files.copy: ").append(target.getAbsolutePath()).append("\n");
        } catch (IOException e) {
            System.out.println(" Ошибка: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void writeChanges(String filePath, String key, String newValue) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath, e);
        }

        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String current = lines.get(i);
            if (current.startsWith(key + "=")) {
                lines.set(i, key + "=" + newValue);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(" Ключ '" + key + "' не найден в файле");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println(" Значение " + key + " изменено на " + newValue);
            logs.append("Config updated: ").append(key).append("=").append(newValue)
                    .append(" in ").append(filePath).append("\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл: " + filePath, e);
        }
    }

}
