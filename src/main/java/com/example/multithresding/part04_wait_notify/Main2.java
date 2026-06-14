package com.example.multithresding.part04_wait_notify;

public class Main2 {
    public static void main(String[] args) {

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
                break;
            }
        }
        cups++;
        System.out.println("Приготовили одну чашку кофе, теперь готово " + cups + " чашек");
    }

    public synchronized void drinkCoffee(){
        while (cups > 0){
            cups--;

        }
    }
}
