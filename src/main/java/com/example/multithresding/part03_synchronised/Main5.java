package com.example.multithresding.part03_synchronised;

public class Main5 {
    public static void main(String[] args) {
        SafeLogger safeLogger = new SafeLogger();

        Thread
    }
}

class SafeLogger{
    private final Object logLock = new Object();

    public void log(String threadName, String message){
        synchronized (logLock){
            System.out.printf("[%s] начал запись: %s -> Thread.sleep(50) -> [%s] закончил запись: %s"
                , Thread.currentThread().getName(), message ,Thread.currentThread().getName(), message);
        }
    }



