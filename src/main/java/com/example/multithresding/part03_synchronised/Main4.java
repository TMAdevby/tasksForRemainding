package com.example.multithresding.part03_synchronised;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Warehouse.addApple();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Warehouse.addOrange();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(Warehouse.apples);
        System.out.println(Warehouse.oranges);
    }
}

class Warehouse{
    static int apples = 0;
    static int oranges = 0;

    private static final Object appleLock = new Object();
    private static final Object orangeLock = new Object();

    public static void addApple(){
        synchronized (appleLock){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                apples++;
        }
    }

    public static void addOrange(){
        synchronized (orangeLock){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                oranges++;
        }
    }
}
