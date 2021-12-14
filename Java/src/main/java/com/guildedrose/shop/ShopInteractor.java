package com.guildedrose.shop;

import com.guildedrose.inventory.ItemsRepository;
import com.guildedrose.items.Item;

import java.util.ArrayList;

public class ShopInteractor implements ShopBuy, ShopSell {

    private ItemsRepository inventaryRepository;
    private BalanceRepository balanceRepository;

    public ShopInteractor(ItemsRepository inventaryRepository, BalanceRepository balanceRepository) {
        this.inventaryRepository = inventaryRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void buyItem(Item item) {
        ArrayList<Item> items = inventaryRepository.GetInventory();
        items.add(item);
        inventaryRepository.SaveInventory(items);
        int balance = balanceRepository.GetBalance();
        balance = balance - item.getValue();
        balanceRepository.SaveBalance(balance);
    }

    @Override
    public void sellItem(Item item) {
        
    }


}
