package com.example.multithresding.part03_synchronised;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccaunt bankAccaunt = new BankAccaunt(1000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                bankAccaunt.withdrow(100);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                bankAccaunt.withdrow(100);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Итоговый баланс: " + bankAccaunt.getBalance());
    }
}

class BankAccaunt {

    private int balance;

    public BankAccaunt(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void  withdrow (int amount){

        if(balance >= amount){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " снял " + amount + ". Остаток " + balance);
        }
    }
}
