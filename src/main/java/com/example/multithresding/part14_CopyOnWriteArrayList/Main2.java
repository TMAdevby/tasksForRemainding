package com.example.multithresding.part14_CopyOnWriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 31 ; i++) {
                String name = "User " + i;
                try {
                    Thread.sleep(100);
                    copyOnWriteArrayList.add(name);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            for (int i = 1; i < 16 ; i++) {
                String name1 = "User " + i;
                String name2 = "User " + (i + 30);
                try {
                    Thread.sleep(50);
                    copyOnWriteArrayList.remove(name1);
                    copyOnWriteArrayList.add(name2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });



    }


}
