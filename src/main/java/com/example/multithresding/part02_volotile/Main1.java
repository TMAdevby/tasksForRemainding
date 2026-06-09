package com.example.multithresding.part02_volotile;

public class Main1 {
    public static void main(String[] args) {
        BackgroundWorker bw = new BackgroundWorker();

        Thread thread = new Thread(bw);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bw.stop();
        System.out.println("Команда на остановку отправлена");
    }
}

class BackgroundWorker implements Runnable{

    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning){
            System.out.println("Работаю...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stop(){
        this.isRunning = false;
    }
}
