package com.example.multithresding.part09_Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main3 {
    public static void main(String[] args) {
        FittingRoom fr = new FittingRoom();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        executorService.execute(new Buyer("Иван", 3 , fr));
        executorService.execute(new Buyer("Мирон", 5 , fr));
        executorService.execute(new Buyer("Матвей", 6 , fr));
        executorService.execute(new Buyer("Елена", 5 , fr));
        executorService.execute(new Buyer("Ирина", 8 , fr));
        executorService.execute(new Buyer("Татьяна", 4 , fr));
        executorService.execute(new Buyer("Екатерина", 6 , fr));

        executorService.shutdown();
    }
}

class FittingRoom {
    private final Semaphore semaphore = new Semaphore(3);

    public void tryOn(String clientName, int seconds){
        try {
            semaphore.acquire();
            System.out.println(clientName + " вошел в кабинку, примеряет " + seconds + " секунд.");
            Thread.sleep(seconds * 1000);
            System.out.println(clientName + " вышел из кабинки.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

class Buyer implements Runnable{

    private String name;
    private int sec;
    private FittingRoom fr;

    public Buyer(String name, int sec, FittingRoom fr) {
        this.name = name;
        this.sec = sec;
        this.fr = fr;
    }

    @Override
    public void run() {
        fr.tryOn(name,sec);
    }
}


