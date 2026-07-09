package com.example.multithresding.part13_ConcurentHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap <String, Integer> concurrentHashMap = new ConcurrentHashMap();

        AtomicInteger counter = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {



            for (int i = 1; i < 11; i++) {
                System.out.println("Click");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                concurrentHashMap.put("Click " + i,counter.incrementAndGet());
            }

        });

        Thread thread2 = new Thread(() -> {

            AtomicInteger exceptionCounter = new AtomicInteger(0);

            for (int i = 1; i < 7; i++) {
                System.out.println("Exception");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                concurrentHashMap.put("Eхception " + i ,counter.incrementAndGet());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(concurrentHashMap.entrySet());

        entries.sort(Comparator.comparingInt(Map.Entry::getValue));

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> item : linkedHashMap.entrySet()) {
            System.out.println("Событие " + item.getKey() + " Порядковый номер " + item.getValue());
        }

        System.out.println("Конец");
    }
}

