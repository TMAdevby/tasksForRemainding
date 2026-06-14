package com.example.multithresding.part06_deamon;

public class Main1 {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            System.out.println("Пользователь открыл редактор");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("Пользователь закрыл редактор");
        });

        Thread autosaveThread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " Автосохранение" + " isDeamon "
                        + Thread.currentThread().isDaemon());
            }
        });

        autosaveThread.setDaemon(true);

        userThread.start();
        autosaveThread.start();


    }
}
