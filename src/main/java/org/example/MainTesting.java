package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTesting {
    public static void main(String[] args) {
        BankAccount bankaccount = new BankAccount(1000);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Random rand = new Random();

        // Step 1: Create a list of 100 user transactions
        List<Runnable> userTasks = new ArrayList<>();

        for(int i=0;i<100;i++){
            userTasks.add(()->{
                int action = rand.nextInt(3);
                double amount = rand.nextInt(500)+1;
                switch(action){
                    case 0 ->bankaccount.deposit(amount);
                    case 1 ->bankaccount.withdraw(amount);
                    case 2-> bankaccount.getBalance();
                }
            });
        }

        for(Runnable task:userTasks){
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
