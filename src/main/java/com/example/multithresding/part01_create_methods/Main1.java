package com.example.multithresding.part01_create_methods;

public class Main1 {
    public static void main(String[] args)  {
        MyThread myThread1 = new MyThread();
        myThread1.setName("Мой первый поток");
        myThread1.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Главный поток завершил работу.");
    }
}

class MyThread extends Thread {
    public void run(){
        for (int i = 1; i < 6; i++) {
            System.out.printf("Поток [%s] выполняет шаг [%d].\n", this.getName(), i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}