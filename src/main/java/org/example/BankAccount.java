package org.example;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public synchronized void deposit(double depositAmount){
        if(depositAmount>0) {
            this.balance += depositAmount;
            log.info("successfully deposited amount :{}",depositAmount);
        }
        else System.out.println("Invalid deposit amount");
    }

    public synchronized void withdraw(double withdrawAmount){
        if(withdrawAmount >0) {
            if (withdrawAmount < this.balance) {
                balance = balance - withdrawAmount;
                log.info("you withdrawn $ {} and the new balance is $ {}", withdrawAmount, balance);
            } else log.info("insufficient balance");
        }
        else
            log.info("Invalid amount");
    }
}
