package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        try {
            Future<String> future = executorService.submit(new SlowWorker());
            String res = null;
            try {
                res = future.get(5, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println(res);

            Future<String> future2 = executorService.submit(new SlowWorker());
            try {
                res = future2.get(1, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                throw new RuntimeException("Задача не успела выполниться за отведенное время", e);
            } catch (ExecutionException e) {
                throw new RuntimeException("Внутренняя ошибка задачи",e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ожидание было прервано",e);
            }
        System.out.println(res);
        }finally {
            executorService.shutdown();
        }

    }
}

class SlowWorker implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "Готово!";
    }
}
