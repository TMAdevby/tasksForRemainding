package com.example.multithresding.part10_CountDownLanch;

import java.util.concurrent.CountDownLatch;

public class Main1 {
    public static void main(String[] args) {
        int workersCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(workersCount);

        for (int i = 1; i <= workersCount; i++) {
            final int id = i;
            new Thread(() ->{
            try {
                int msek = Math.random() < 0.5 ? 1000 : 2000;
                    Thread.sleep (msek);
                System.out.println("Воркер " + id + " завершил работу.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
            }).start();
        }

        System.out.println("Главный поток ждет завершения всех потоков...");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Главный поток завершил работу");
    }
}
