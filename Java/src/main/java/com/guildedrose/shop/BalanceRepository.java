package com.guildedrose.shop;


public interface BalanceRepository {
    double GetBalance();

    void SaveBalance(double balance);
}
