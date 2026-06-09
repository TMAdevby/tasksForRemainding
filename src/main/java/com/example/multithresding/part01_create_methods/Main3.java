package com.example.multithresding.part01_create_methods;

public class Main3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.printf("Поток :[%s] , приоритет :[%d] , шаг :[%d]\n", Thread.currentThread().getName(),
                        Thread.currentThread().getPriority(), i);
                //Thread.yield();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.printf("Поток :[%s] , приоритет :[%d] , шаг :[%d]\n", Thread.currentThread().getName(),
                        Thread.currentThread().getPriority(), i);
                //Thread.yield();
            }
        });

        thread1.setName("Высокий");
        thread2.setName("Низкий");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();

    }
}
