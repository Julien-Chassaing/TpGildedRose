package com.guildedrose.shop;


public interface BalanceRepository {
    int GetBalance();

    void SaveBalance(int balance);
}
