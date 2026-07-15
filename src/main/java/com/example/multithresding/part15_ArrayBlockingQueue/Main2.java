package com.example.multithresding.part15_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Main2 {
    public static void main(String[] args) {
        ArrayBlockingQueue <String> arrayBlockingQueue = new ArrayBlockingQueue<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 31; i++) {
                String name = "Order-" + i;
                System.out.println("Заказ принят " + name);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                try {
                    arrayBlockingQueue.put(name);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }


}
