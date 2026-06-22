package com.example.multithresding.part09_Semaphore;

import java.util.concurrent.Semaphore;

public class Main1 {
    public static void main(String[] args) {
        ConnectionPool cp1 = new ConnectionPool(5);
        Client cl1 = new Client("Сеня" , cp1);


    }
}

class ConnectionPool {
    private int maxConnections;
    private Semaphore semaphore;

    public ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.semaphore = new Semaphore(maxConnections);
    }

    public void getConnection(String clientName){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(clientName + " подключился.");
    }

    public void releaseConnection(String clientName){
        semaphore.release();
        System.out.println(clientName + " отключился.");
    }
}

class Client implements Runnable{

    private String name;
    private ConnectionPool cp;

    public Client(String name, ConnectionPool cp) {
        this.name = name;
        this.cp = cp;
    }

    @Override
    public void run() {
        cp.getConnection(this.getName());
        int sec = (int)(1 + (Math.random() * 4));
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        cp.releaseConnection(this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
