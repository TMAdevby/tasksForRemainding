package com.example.multithresding.part07_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            for (int i = 1; i < 4; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " шаг " + i);
                    if(i == 3){
                        throw new RuntimeException("Ошибка на 3-м шаге!");
                    }
                }catch (Exception e){
                    System.err.println("Ошибка " + e.getMessage());
                }
            }
        },1,1, TimeUnit.SECONDS);

        Thread.sleep(6000);
        scheduledExecutorService.shutdown();

        System.out.println("Программа завершена");


    }
}


