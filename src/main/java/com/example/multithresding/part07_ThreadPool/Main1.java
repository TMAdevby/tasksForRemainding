package com.example.multithresding.part07_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 1; i < 6; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println("Задача " + finalI + " выполнена");
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Main finished");
    }
}

