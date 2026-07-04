package com.example.multithresding.part10_CountDownLanch;

import java.util.concurrent.CountDownLatch;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 1; i < 4; i++) {
            final int runner = i;
            new Thread(() -> {
                System.out.println("Бегун " + runner + " на старте ждет сигнала...");
                try {
                    startSignal.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Бегун " + runner + " стартовал");

            }).start();
        }

        Thread.sleep(1000);
        System.out.println("Судья дает сигнал!");
        startSignal.countDown();
    }
}
