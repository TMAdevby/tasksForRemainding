package com.example.multithresding.part15_ArrayBlockingQueue;

import ch.qos.logback.core.model.INamedModel;

import javax.xml.namespace.QName;
import java.util.concurrent.ArrayBlockingQueue;

public class Main2 {

    private static final String POISON_PILL = "STOP";

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue <String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

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
            try {
                arrayBlockingQueue.put(POISON_PILL);
                arrayBlockingQueue.put(POISON_PILL);
                arrayBlockingQueue.put(POISON_PILL);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    String name = arrayBlockingQueue.take();
                    if (POISON_PILL.equals(name)) {
                        break;  // Выходим из цикла
                    }
                    System.out.println("Менеджер " + Thread.currentThread().getName() + " обработал " + name);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            while (true) {
                try {
                    String name = arrayBlockingQueue.take();
                    if (POISON_PILL.equals(name)) {
                        break;  // Выходим из цикла
                    }
                    System.out.println("Менеджер " + Thread.currentThread().getName() + " обработал " + name);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread4 = new Thread(() -> {
            while (true) {
                try {
                    String name = arrayBlockingQueue.take();
                    if (POISON_PILL.equals(name)) {
                        break;  // Выходим из цикла
                    }
                    System.out.println("Менеджер " + Thread.currentThread().getName() + " обработал " + name);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }


}
