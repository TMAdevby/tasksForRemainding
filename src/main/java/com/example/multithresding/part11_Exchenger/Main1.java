package com.example.multithresding.part11_Exchenger;

import java.util.concurrent.Exchanger;

public class Main1 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // Поток 1 (Пинг)
        Thread player1 = new Thread(() -> {
            String message = "Пинг";
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Игрок 1 отправляет: " + message);

                    // БЛОКИРУЕТСЯ здесь, пока Игрок 2 не вызовет exchange()
                    String received = exchanger.exchange(message);

                    System.out.println("Игрок 1 получил: " + received);
                    // После обмена message становится тем, что прислал Игрок 2 ("Понг")
                    // Но для следующего круга нам снова нужен "Пинг",
                    // поэтому можно либо игнорировать received, либо менять логику.
                    // В классическом пинг-понге мы просто шлем свое слово.
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Поток 2 (Понг)
        Thread player2 = new Thread(() -> {
            String message = "Понг";
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Игрок 2 отправляет: " + message);

                    // БЛОКИРУЕТСЯ здесь, пока Игрок 1 не вызовет exchange()
                    String received = exchanger.exchange(message);

                    System.out.println("Игрок 2 получил: " + received);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        player1.start();
        player2.start();
    }
}