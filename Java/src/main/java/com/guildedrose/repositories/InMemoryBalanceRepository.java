package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;

public class InMemoryBalanceRepository implements BalanceRepository {

    double balance;

    public InMemoryBalanceRepository() {
        this.balance = 500000;
    }

    @Override
    public double GetBalance() {
        return balance;
    }

    @Override
    public void SaveBalance(double balance) {
        this.balance = balance;
    }
}
