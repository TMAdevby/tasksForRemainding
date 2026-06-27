package com.example.multithresding.part09_Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main2 {
    public static void main(String[] args) {
        ATM atm = new ATM();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new Person("Иван", atm));
        executorService.execute(new Person("Сергей", atm));
        executorService.execute(new Person("Маша", atm));
        executorService.execute(new Person("Даша", atm));
        executorService.execute(new Person("Витя", atm));

        executorService.shutdown();
    }
}

class ATM {
    private final Semaphore semaphore = new Semaphore(2);

    public void use(String name){
        try {
            semaphore.acquire();
            System.out.println(name + " Подошел к банкомату.");
            Thread.sleep(2000);
            System.out.println(name + " Завершил операцию.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

class Person implements Runnable{
    private final String name;
    private final ATM atm;

    public Person(String name, ATM atm) {
        this.name = name;
        this.atm = atm;
    }

    @Override
    public void run() {
        atm.use(name);
    }
}