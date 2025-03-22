package org.example;

import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Slf4j
public class Main {
    public static void main(String[] args) {
        //ThreadPoolExecutor  threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService exs = Executors.newCachedThreadPool();
        BankAccount bankAccount = new BankAccount(0);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter deposit amount :");
            if (scanner.hasNextDouble()) {
                double depositAmount = scanner.nextDouble();
                Runnable task = () -> {
                    bankAccount.deposit(depositAmount);
                };
                exs.execute(task);
            } else throw new Exception("invalid deposit amount");
            //System.out.println(depositAmount);
            System.out.println("Enter withdrawal amount :");
            if (scanner.hasNextDouble()) {
                double withDrawAmount = scanner.nextDouble();
                Runnable task2 = () -> {
                    bankAccount.withdraw(withDrawAmount);
                };
                exs.execute(task2);
            } else  throw new Exception("invalid withdrawal amount");
        }catch(Exception e){
            log.error("Exception",e);
            //throw new RuntimeException(e);
        }
    }
}