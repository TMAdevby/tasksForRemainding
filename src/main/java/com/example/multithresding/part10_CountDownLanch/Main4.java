package com.example.multithresding.part10_CountDownLanch;

import java.util.concurrent.CountDownLatch;

public class Main4 {
    public static void main(String[] args) {
        CountDownLatch step1 = new CountDownLatch(1);
        CountDownLatch step2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " начал работу");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                step1.countDown();
                System.out.println(Thread.currentThread().getName() + " закончил работу");
            }
        }, "Поток А").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " начал работу");
            try {
                step1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                step2.countDown();
                System.out.println(Thread.currentThread().getName() + " закончил работу");
            }
        }, "Поток Б").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " начал работу");
            try {
                step2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println(Thread.currentThread().getName() + " закончил работу");
            }
        }, "Поток В").start();
    }
}
