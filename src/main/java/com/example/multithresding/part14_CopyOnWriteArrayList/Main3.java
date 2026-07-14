package com.example.multithresding.part14_CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < 31; i++) {
            String id = "ID " + i;
            list.add(id);
        }

        for (int i = 1; i < 31; i++) {
            String id = "ID " + i;
            if(i % 2 == 0) {
                list.add(id);
            }
        }

        for (int i = 1; i < 31; i++) {
            String id = "ID " + i;
            if(i % 3 == 0) {
                list.add(id);
            }
        }

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < list.size() / 3; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                copyOnWriteArrayList.addIfAbsent(list.get(i));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = list.size() / 3 ; i < list.size() * 2 / 3 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                copyOnWriteArrayList.addIfAbsent(list.get(i));
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = list.size() * 2 / 3 ; i < list.size() ; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                copyOnWriteArrayList.addIfAbsent(list.get(i));
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        for(String id : copyOnWriteArrayList){
            System.out.println(id);
        }
    }
}
