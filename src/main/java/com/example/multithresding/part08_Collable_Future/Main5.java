package com.example.multithresding.part08_Collable_Future;

import java.util.concurrent.*;

public class Main5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(new BuggyWorker());

        try {
            int result = future.get();
            System.out.println("Результат: " + result);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // восстанавливаем статус прерывания
            throw new RuntimeException("Ожидание результата было прервано", e);

        } catch (ExecutionException e) {
            // ✅ Снимаем обертку ExecutionException, показываем реальную причину
            // ✅ Сообщение понятное, а не "Поймано: [имя класса]"
            throw new RuntimeException("Задача завершилась с ошибкой", e.getCause());

        } finally {
            executorService.shutdown();
        }
    }
}

class BuggyWorker implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int result = 100 / 0;
        return result;
    }
}
