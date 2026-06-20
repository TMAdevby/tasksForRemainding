package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new RaceWorker("Заяц", 1));
        executorService.submit(new RaceWorker("Лис", 2));
        executorService.submit(new RaceWorker("Черепаха", 3));

        executorService.shutdown();


    }
}

class RaceWorker implements Callable<String> {

    private String name;
    private int sleepTime;

    public RaceWorker(String name, int sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + " начал бежать");
        Thread.sleep(sleepTime * 1000);
        System.out.println(name + " финишировал за " + sleepTime + " секунд.");
        return name + " " + sleepTime + " секунд.";
    }
}
