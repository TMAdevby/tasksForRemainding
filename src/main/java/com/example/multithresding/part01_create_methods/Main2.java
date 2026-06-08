package com.example.multithresding.part01_create_methods;

public class Main2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 4; i++) {
                    System.out.println(Thread.currentThread().getName() + " Анонимный класс работает");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " Лямбда работает");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
    }


}
