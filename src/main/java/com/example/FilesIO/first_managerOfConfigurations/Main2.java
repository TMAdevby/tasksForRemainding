package com.example.FilesIO.first_managerOfConfigurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите относительный путь к папке:");
        String yourPath = sc.nextLine();

        checkPath(yourPath);

        File file1 = createFileInDirectory(yourPath, "readme.txt");
        File file2 = createFileInDirectory(yourPath, "data.bin");
        File file3 = createFileInDirectory(yourPath, "config.properties");

        getInformation(file1);
        getInformation(file2);
        getInformation(file3);

        deleteFile(file2);

        printListFiles(yourPath);

        sc.close();
    }

    public static void checkPath(String path) {
        File yourPath = new File(path);
        if (yourPath.exists()) {
            log.info("Папка уже существует: {}", yourPath.getAbsolutePath());
        } else {
            if (yourPath.mkdirs()) {
                log.info("Папка создана: {}", yourPath.getAbsolutePath());
            } else {
                log.error("Не удалось создать папку: {}", yourPath.getAbsolutePath());
            }
        }
    }

    public static File createFileInDirectory(String createdDirectory, String fileName) {
        // ✅ Используем конструктор File(parent, child) — кроссплатформенно
        File file = new File(createdDirectory, fileName);

        if (file.exists()) {
            log.info("Файл уже существует: {}", file.getAbsolutePath());
        } else {
            try {
                if (file.createNewFile()) {
                    log.info("Файл создан: {}", file.getAbsolutePath());
                }
            } catch (IOException e) {
                // ✅ Правильный порядок: сообщение, параметры, исключение в конце
                log.error("Ошибка при создании файла {}: {}",
                        file.getAbsolutePath(), e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    public static void getInformation(File file) {
        if (!file.exists()) {
            System.out.println("Файл не существует: " + file.getName());
            return;
        }

        // ✅ Конвертируем миллисекунды в читаемую дату
        String lastModified = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(file.lastModified()),
                ZoneId.systemDefault()
        ).format(DATE_FORMAT);

        // ✅ Используем %s и %n для printf
        System.out.printf("Файл: %s%n", file.getName());
        System.out.printf("  Абсолютный путь: %s%n", file.getAbsolutePath());
        System.out.printf("  Размер (байт): %d%n", file.length());
        System.out.printf("  Изменён: %s%n", lastModified);
        System.out.printf("  Чтение: %b | Запись: %b%n", file.canRead(), file.canWrite());
        System.out.println("__________________________");
    }

    public static void deleteFile(File file) {
        if (file.isFile() && file.exists()) {
            // ✅ Проверяем результат удаления
            if (file.delete()) {
                log.info("Файл успешно удалён: {}", file.getName());
            } else {
                log.warn("Не удалось удалить файл: {}", file.getName());
            }
        } else {
            log.warn("Файл для удаления не найден: {}", file.getName());
        }
    }

    public static void printListFiles(String dir) {
        File directory = new File(dir);
        if (directory.isDirectory() && directory.exists()) {
            File[] files = directory.listFiles();
            // ✅ Проверка на null
            if (files != null && files.length > 0) {
                System.out.println("Содержимое папки " + dir + ":");
                Arrays.stream(files)
                        .forEach(f -> System.out.println("  " + f.getName()));
            } else {
                System.out.println("Папка пуста.");
            }
        } else {
            System.out.println("Папка не найдена: " + dir);
        }
    }
}