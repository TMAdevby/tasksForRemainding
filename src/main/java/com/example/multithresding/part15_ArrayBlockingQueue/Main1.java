package com.example.multithresding.part15_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue <Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() ->{
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(10);
                    Integer num =(int) (Math.random() * 10);
                    arrayBlockingQueue.put(num);
                    System.out.println("Датчик отправил " + num + " " + arrayBlockingQueue);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } 
        });

        Thread concumer = new Thread(() ->{
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                    Integer num = arrayBlockingQueue.take();
                    System.out.println("База данных сохранила " + num  + " " + arrayBlockingQueue);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        concumer.start();
        producer.start();

        concumer.join();
        producer.join();
    }


}
