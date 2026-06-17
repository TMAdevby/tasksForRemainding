package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            SumCalculator sc = new SumCalculator(5,7);

            Future<Integer> future = executorService.submit(sc);

            int result = future.get();

            System.out.println(result);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }
    }
}

class SumCalculator implements Callable<Integer> {
    private int a;
    private int b;

    public SumCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        return a + b;
    }
}