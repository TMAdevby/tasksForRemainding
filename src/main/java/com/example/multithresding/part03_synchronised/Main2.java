package com.example.multithresding.part03_synchronised;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter2.incrementMethod();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter2.incrementMethod();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter2.incrementBlock();
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter2.incrementBlock();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(Counter2.getCount());
    }
}

class Counter2 {
    private static int count = 0;

    public static synchronized void incrementMethod() {
        count++;
    }

    public static void incrementBlock() {
        synchronized (Counter2.class) {
            count++;
        }
    }

    public static int getCount() {
        return count;
    }
}


