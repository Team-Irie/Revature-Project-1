package com.revature.models;

public class Account {
    private int customerId;
    private int balance;
    private int accountNumber;

    public Account() {
    }

    public Account(int customerId, int balance, int accountNumber) {
        this.customerId = customerId;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerId=" + customerId +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}