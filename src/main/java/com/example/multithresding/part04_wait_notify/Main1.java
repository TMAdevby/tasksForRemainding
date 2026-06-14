package com.example.multithresding.part04_wait_notify;

public class Main1 {
    public static void main(String[] args) {
        Game game = new Game();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                game.printPing();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                game.printPong();
            }
        });

        thread1.start();
        thread2.start();


    }
}

class Game{
    private boolean isPingTurn = true;

    public synchronized void printPing(){
        if(!isPingTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Ping");
            isPingTurn = false;
            notify();
        }
    }

    public synchronized void printPong(){
        if(isPingTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Pong");
            isPingTurn = true;
            notify();
        }
    }

}
