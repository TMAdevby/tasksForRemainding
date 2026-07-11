package com.example.multithresding.part13_ConcurentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main3 {
    static ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 1; i < 101; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                String stat = Math.random() < 0.6 ? "BANNED" : "ACTIVE";
                chm.put(i,stat);
            }
        });

        Thread thread2 = new Thread(() -> {
            while(thread.isAlive()) {
                for (Map.Entry<Integer, String> item : chm.entrySet()) {
                    if (item.getValue().equals("BANNED")) {
                        chm.remove(item.getKey());
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        thread.start();
        thread2.start();

        thread.join();
        chm.entrySet().removeIf(entry -> entry.getValue().equals("BANNED"));
        thread2.join();

        for (Map.Entry<Integer,String> item : chm.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }


}
