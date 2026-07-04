package com.example.multithresding.part10_CountDownLanch;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);

        startService("BD", 500, cdl);

        startService("Cache", 300, cdl);

        startService("API", 5000, cdl);

        System.out.println("Ожидание инициализации сервисов (максимум 2 сек)...");


            boolean allInit = cdl.await(2, TimeUnit.SECONDS);

            if(allInit){
                System.out.println("Все инициализировано, запускаемся");
            }else {
                System.out.println("Не все сервисы инициализированы");
                System.out.println("Осталось не инициализированных " + cdl.getCount());
            }
    }

    public static void startService(String name, int delay, CountDownLatch cdl){
        new Thread(() -> {
            System.out.println("Запускаем сервис " + name);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                cdl.countDown();
            }
        }).start();
    }
}
