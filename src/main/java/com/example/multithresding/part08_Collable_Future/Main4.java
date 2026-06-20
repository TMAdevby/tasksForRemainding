package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.*;

public class Main4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(new LongTask());

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            if(i == 3){
                future.cancel(true);
            }
            if(!future.isDone()){
                System.out.println("Еще рботаю...");
            }
        }

        try {
            String result = future.get();
            System.out.println("Результат: " + result);
        } catch (CancellationException e) {
            System.out.println("Задача была отменена!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }




    }
}

class LongTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i = 1; i < 11; i++) {
            System.out.println("Работаю ... итерация " + i);
            Thread.sleep(500);
        }
        return "Завершено успешно";
    }
}
