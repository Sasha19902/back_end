package com.aleksander.generics;

import java.util.UUID;

public class Account implements Comparable<Account>{
    private String id;
    private long balance;

    public Account(long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }


    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    @Override
    public int compareTo(Account o) {
        if(balance > o.balance) {
            return 1;
        } else {
            if(balance == o.balance) {
                return 0;
            }
        }
        return -1;
    }
}
