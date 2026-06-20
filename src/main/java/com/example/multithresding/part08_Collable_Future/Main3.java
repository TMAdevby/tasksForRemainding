package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future1 = executorService.submit(new RaceWorker("Заяц", 1));
        Future<String> future2 = executorService.submit(new RaceWorker("Лис", 2));
        Future<String> future3 = executorService.submit(new RaceWorker("Черепаха", 3));

        executorService.shutdown();

        String result1 = future1.get();
        String result2 = future2.get();
        String result3 = future3.get();

        System.out.println("Победители в порядке финиша : " + result1 + "," + result2 + "," + result3);
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
