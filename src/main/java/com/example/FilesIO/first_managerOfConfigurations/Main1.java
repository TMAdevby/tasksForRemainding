package com.example.FilesIO.first_managerOfConfigurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    // Создаем логгер для этого класса
    private static final Logger log = LoggerFactory.getLogger(Main1.class);

    public static void main(String[] args) {
        log.info("=== Запуск менеджера конфигураций ===");

        try {
            createDirectory("D:\\Games\\FilesExperements\\configs\\active");
            createDirectory("D:\\Games\\FilesExperements\\configs\\backup");
            createDirectory("D:\\Games\\FilesExperements\\configs\\logs");
            createDirectory("D:\\Games\\FilesExperements\\configs\\temp");

            createFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg");
            createFile("D:\\Games\\FilesExperements\\configs\\logs\\install.log");
            createFile("D:\\Games\\FilesExperements\\configs\\temp\\temp.txt");

            writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=10");
            writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=20");
            writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=30");
            writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=40");
            writeToFile("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume=50");

            copyFileWithTimestamp("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg",
                    "D:\\Games\\FilesExperements\\configs\\backup");

            writeChanges("D:\\Games\\FilesExperements\\configs\\active\\settings.cfg", "volume", "100");

            listAllCfgFiles("D:\\Games\\FilesExperements\\configs");

            log.info("=== Все операции завершены успешно ===");

        } catch (Exception e) {
            log.error("Критическая ошибка при выполнении программы", e);
        }
    }

    public static void createDirectory(String path) {
        log.debug("Пытаемся создать директорию: {}", path);

        File directory = new File(path);
        boolean created = directory.mkdirs();

        if (directory.isDirectory() && directory.exists()) {
            if (created) {
                log.info("Директория создана: {}", path);
            } else {
                log.debug("Директория уже существует: {}", path);
            }
        } else {
            log.error("Не удалось создать директорию: {}", path);
        }
    }

    public static void createFile(String path) {
        log.debug("Пытаемся создать файл: {}", path);

        File file = new File(path);

        try {
            boolean created = file.createNewFile();

            if (file.isFile() && file.exists()) {
                if (created) {
                    log.info("Файл создан: {}", path);
                } else {
                    log.debug("Файл уже существует: {}", path);
                }
            } else {
                log.error("Не удалось создать файл: {}", path);
            }
        } catch (IOException e) {
            log.error("Ошибка при создании файла {}: {}", path, e.getMessage(), e);
        }
    }

    public static void writeToFile(String path, String line) {
        log.debug("Запись в файл {}: {}", path, line);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(line);
            bw.newLine();
            log.debug("Данные успешно записаны в {}", path);
        } catch (IOException e) {
            log.error("Ошибка записи в файл {}: {}", path, e.getMessage(), e);
        }
    }

    public static void copyFileWithTimestamp(String sourcePath, String backupDir) {
        log.info("Создание бэкапа: {} -> {}", sourcePath, backupDir);

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
            log.info("Файл успешно скопирован: {}", target.getAbsolutePath());
        } catch (IOException e) {
            log.error("Ошибка копирования файла: {}", e.getMessage(), e);
        }
    }

    public static void writeChanges(String filePath, String key, String newValue) {
        log.info("Изменение конфигурации: {}={} в файле {}", key, newValue, filePath);

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            log.error("Ошибка чтения файла {}: {}", filePath, e.getMessage(), e);
            return;
        }

        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String current = lines.get(i);
            if (current.startsWith(key + "=")) {
                lines.set(i, key + "=" + newValue);
                found = true;
                log.debug("Найден ключ {} в строке {}", key, i);
                break;
            }
        }

        if (!found) {
            log.warn("Ключ '{}' не найден в файле {}", key, filePath);
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            log.info("Конфигурация успешно обновлена: {}={}", key, newValue);
        } catch (IOException e) {
            log.error("Ошибка записи в файл {}: {}", filePath, e.getMessage(), e);
        }
    }

    public static void listAllCfgFiles(String dirPath) {
        log.debug("Поиск .cfg файлов в {}", dirPath);

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            log.warn("Папка не найдена: {}", dirPath);
            return;
        }

        File[] items = dir.listFiles();

        if (items == null) {
            log.warn("Не удалось прочитать содержимое папки: {}", dirPath);
            return;
        }

        int count = 0;
        for (File item : items) {
            if (item.isFile() && item.getName().endsWith(".cfg")) {
                log.info("Найден .cfg файл: {}", item.getAbsolutePath());
                count++;
            } else if (item.isDirectory()) {
                listAllCfgFiles(item.getAbsolutePath());
            }
        }

        log.info("Всего найдено .cfg файлов: {}", count);
    }
}
