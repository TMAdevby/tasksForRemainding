package com.example.multithresding.part03_synchronised;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Th1 thread1 = new Th1(counter);
        Th1 thread2 = new Th1(counter);
        Thread thread3 = new Thread(new Th2(counter));
        Thread thread4 = new Thread(new Th2(counter));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(counter.getCount());
    }
}

class Counter {
    private int count = 0;

    public synchronized void incrementMethod() {
        count++;
    }

    public void incrementBlock() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class Th1 extends Thread{
    Counter counter;

    public Th1(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.incrementMethod();
        }
    }
}

class Th2 implements Runnable{
    Counter counter;

    public Th2(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementBlock();
        }
    }
}
