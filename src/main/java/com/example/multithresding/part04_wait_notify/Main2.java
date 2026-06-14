package com.example.multithresding.part04_wait_notify;

public class Main2 {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Thread bar = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                coffeeMachine.makeCoffee();
            }
        });

        Thread client = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                coffeeMachine.drinkCoffee();
            }
        });

        bar.start();
        client.start();
    }
}

class CoffeeMachine{
    private int cups = 0;
    private final int MAX_CUPS = 3;

    public synchronized void makeCoffee(){
        while (cups >= 3){
            try {
                wait();
                System.out.println("Готово " + cups + " чашек кофе, ждем");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        cups++;
        System.out.println("Приготовили одну чашку кофе, теперь готово " + cups + " чашек");
        notify();
    }

    public synchronized void drinkCoffee(){
        while (cups == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        cups--;
        System.out.println("Выпили одну чашку кофе, теперь готово " + cups + " чашек");
        notify();
    }
}
