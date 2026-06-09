package com.example.multithresding.part02_volotile;

public class Main2 {
    public static void main(String[] args) {
        DataLoader loader = new DataLoader();
        Thread thread = new Thread(loader, "Поток-загрузчик");

        Thread thread1 = new Thread(new User(loader), "Поток-пользователь");

        thread.start();
        thread1.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Конец");
    }
}

class DataLoader implements Runnable {
    public volatile boolean isReady = false;

    public String data = "";

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начинаю загрузку данных...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        this.data = "Важная конфигурация";
        this.isReady = true;
        System.out.println(Thread.currentThread().getName() + " данные загружены!");
    }
}

class User implements Runnable{

    private final DataLoader loader;

    User(DataLoader loader) {
        this.loader = loader;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ожидаю данные...");

        while (!loader.isReady){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
        }
        System.out.println(Thread.currentThread().getName() + ": Получены данные -> " + loader.data);
    }
}
