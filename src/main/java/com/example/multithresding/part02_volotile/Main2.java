package com.example.multithresding.part02_volotile;

public class Main2 {
    public static void main(String[] args) {

    }
}

class DataLoader implements Runnable {
    public volatile boolean isReady = false;

    public String data = "";

    @Override
    public void run() {
        System.out.println("Начинаю загрузку данных...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        this.data = "Важная конфигурация";
        this.isReady = true;
        System.out.println("Данные загружены!");
    }
}

class User implements Runnable{

    @Override
    public void run() {

    }
}
