package com.example.multithresding.part14_CopyOnWriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList <String> copyOnWriteArrayList = new CopyOnWriteArrayList();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 31 ; i++) {
                String name = "User " + i;
                copyOnWriteArrayList.add(name);
            }
        });

        Thread thread1a = new Thread(() -> {
            System.out.println("--- Поток 1А начал итерацию ---");
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (String user : copyOnWriteArrayList) {
                System.out.println("Поток 1А видит: " + user);
                try {
                    Thread.sleep(500); // Спим, чтобы Поток Б успел изменить список
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("--- Поток 1А закончил итерацию ---");
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(250);
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

        thread1.start();
        thread1a.start();
        thread2.start();

        thread1.join();
        thread1a.join();
        thread2.join();

        for(Object name : copyOnWriteArrayList){
            System.out.println(name);
        }

        System.out.println("The end");

    }


}
