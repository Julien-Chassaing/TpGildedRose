package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;

public class InMemoryBalanceRepository implements BalanceRepository {

    int balance;

    public InMemoryBalanceRepository() {
        this.balance = 1000000;
    }

    @Override
    public int GetBalance() {
        return balance;
    }

    @Override
    public void SaveBalance(int balance) {
        this.balance = balance;
    }
}
