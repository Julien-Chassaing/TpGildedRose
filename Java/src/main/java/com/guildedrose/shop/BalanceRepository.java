package com.guildedrose.shop;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface BalanceRepository {
    int GetBalance();

    void SaveBalance(int balance);
}
