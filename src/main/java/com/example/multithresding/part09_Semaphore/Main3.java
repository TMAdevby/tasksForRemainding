package com.example.multithresding.part09_Semaphore;

import java.util.concurrent.Semaphore;

public class Main3 {
    public static void main(String[] args) {

    }
}

class FittingRoom {
    private final Semaphore semaphore = new Semaphore(3);

    private void tryOn(String clientName, int seconds){
        try {
            semaphore.acquire();
            System.out.println(clientName + " вошел в кабинку, примеряет " + seconds + " секунд.");
            Thread.sleep(seconds * 1000);
            System.out.println(clientName + " вышел из кабинки.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            semaphore.release();
        }
    }
}

class Buyer {

}


