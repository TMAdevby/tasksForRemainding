package com.example.multithresding.part03_synchronised;

public class Main5 {
    public static void main(String[] args) {
        SafeLogger safeLogger = new SafeLogger();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                safeLogger.log(Thread.currentThread().getName(),"Сообщение 1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                safeLogger.log(Thread.currentThread().getName(),"Сообщение 2");
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                safeLogger.log(Thread.currentThread().getName(),"Сообщение 3");
            }
        });
    }
}

class SafeLogger {
    private final Object logLock = new Object();

    public void log(String threadName, String message) {
        synchronized (logLock) {
            System.out.printf("[%s] начал запись: %s -> Thread.sleep(50) -> [%s] закончил запись: %s"
                    , threadName, message, threadName, message);
        }
    }
}



