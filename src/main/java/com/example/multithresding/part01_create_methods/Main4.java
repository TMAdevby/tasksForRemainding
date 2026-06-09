package com.example.multithresding.part01_create_methods;

public class Main4 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.printf("Загрузка ... [%d]\n", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        System.out.println("Начало загрузки");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Загрузка завершена, главный поток продолжает работу");
    }
}
