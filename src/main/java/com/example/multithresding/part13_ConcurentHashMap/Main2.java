package com.example.multithresding.part13_ConcurentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {

    private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                getResult("Один");
            }
        });

        Thread thread2 = new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                getResult("Два");
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        for(Map.Entry <String, Integer> item : concurrentHashMap.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

    }

    public static Integer getResult(String key){
        return concurrentHashMap.computeIfAbsent(key, k -> {
            try {
                Thread.sleep(1000);
                System.out.println("K = " + k);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return k.length();
        });
    }
}
