package com.guildedrose.balance;

import com.guildedrose.shop.BalanceRepository;

public class BalanceInteractor implements BalanceViewer{
    private BalanceRepository balanceRepository;

    public BalanceInteractor(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public double getBalance() {
        return balanceRepository.GetBalance();
    }
}
