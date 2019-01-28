package com.aleksander.threads;

import java.util.UUID;

public class Account {
    private String id;
    private long balance;

    public Account(long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public void addToBalance(long value) throws Exception {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }
}