package com.example.multithresding.part14_CopyOnWriteArrayList;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {

        EventBus eventBus = new EventBus();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 31; i++) {
                String name = "Name" + i;
                int number = i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                Listener listener = new Listener(number,name);
                eventBus.addListener(listener);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            for (Listener listener : eventBus.getListeners()){
                eventBus.onEvent(listener);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        for (Listener listener : eventBus.getListeners()) {
            System.out.println(listener.getNumber() + " " + listener.getName());
        }

    }
}
    class Listener {
        private int number;
        private String name;

        public Listener(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Listener)) return false;
            Listener listener = (Listener) o;
            return number == listener.number && Objects.equals(name, listener.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, name);
        }
    }

    class EventBus{
        private CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();

        public EventBus() {
        }

        public EventBus(CopyOnWriteArrayList<Listener> listeners) {
            this.listeners = listeners;
        }

        public CopyOnWriteArrayList<Listener> getListeners() {
            return listeners;
        }

        public void addListener(Listener listener){
            listeners.add(listener);
        }

        public void removeListener(Listener listener){
            listeners.remove(listener);
        }

        public void onEvent(Listener listener){
            if (listener.getNumber() % 3 == 0) {
                this.removeListener(listener);
            }
        }

    }

