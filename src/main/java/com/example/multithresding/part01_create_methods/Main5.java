package com.example.multithresding.part01_create_methods;

public class Main5 {
    public static void main(String[] args)  {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Поток работает...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток прерван");
                    break;
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();

        System.out.println(thread.isAlive());

    }
}
