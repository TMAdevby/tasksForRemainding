package com.example.multithresding.part05_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        SharedPrinter sharedPrinter = new SharedPrinter();

        Thread thread1 = new Thread(() -> {
            sharedPrinter.print(Thread.currentThread().getName());
        } , "Принтер А");

        Thread thread2 = new Thread(() -> {
            sharedPrinter.print(Thread.currentThread().getName());
        } , "Принтер Б");

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}

class SharedPrinter{
    ReentrantLock lock = new ReentrantLock();

    public void print(String ThreadName){
        if(lock.tryLock()){
            try{
                System.out.println(ThreadName + " начал печатать документ");
                Thread.sleep(1000);
                System.out.println(ThreadName + " напечатал документ");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println(ThreadName + " видит что печатается документ и не ждет");
        }
    }
}
