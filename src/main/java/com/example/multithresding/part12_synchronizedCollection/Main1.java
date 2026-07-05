package com.example.multithresding.part12_synchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {



    public static void main(String[] args) throws InterruptedException {

        List<String> log = Collections.synchronizedList(new ArrayList<>());

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            final int id = i;
            threads[i] = new Thread(() ->{
                for (int j = 0; j < 100; j++) {
                    String str = "Поток " + id + " пишет лог № " + j;
                    log.add(str);
                }
            });
            threads[i].start();
            threads[i].join();
        }

        for(String str : log){
            System.out.println(str);
        }
        System.out.println(log.size());
    }
}
