package com.guildedrose.shop;

import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.inventory.ItemsRepository;
import com.guildedrose.items.*;

import java.util.ArrayList;

public class ShopInteractor implements ShopBuy, ShopSell, ItemsRepository, BalanceRepository {

    private ItemsRepository inventoryRepository;
    private BalanceRepository balanceRepository;

    public ShopInteractor(ItemsRepository inventoryRepository, BalanceRepository balanceRepository) {
        super();
        this.inventoryRepository = inventoryRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void buyItem(String typeItem, String name, int sellIn, int quality, int value) {
        ArrayList<Item> items = inventoryRepository.GetInventory();
        Item item = createItem(items, typeItem, name,sellIn,quality,value);
        items.add(item);
        inventoryRepository.SaveInventory(items);
        double balance = balanceRepository.GetBalance();
        balance = balance - item.getValue();
        balanceRepository.SaveBalance(balance);
    }

    @Override
    public void sellItem(int index) {
        ArrayList<Item> items = inventoryRepository.GetInventory();
        double balance = balanceRepository.GetBalance();
        for(Item item : items){
            if (item.getIndex() == index)
                balance = balance + item.getValue();
        }
        items.removeIf(item -> item.getIndex() == index);
        balanceRepository.SaveBalance(balance);
        inventoryRepository.SaveInventory(items);
    }

    public int getMaxIndex(ArrayList<Item> items) {
        int result = 0;
        for (Item item : items) {
            if (item.getIndex() > result) {
                result = item.getIndex();
            }
        }
        return result;
    }

    @Override
    public double GetBalance() {
        return balanceRepository.GetBalance();
    }

    @Override
    public void SaveBalance(double balance) {
        balanceRepository.SaveBalance(balance);
    }

    @Override
    public ArrayList<Item> GetInventory() {
        return inventoryRepository.GetInventory();
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        inventoryRepository.SaveInventory(items);
    }

    private Item createItem(ArrayList<Item> items, String typeItem, String name, int sellIn, int quality, int value){
        Item item = null;
        switch (typeItem) {
            case "AgedItem":
                item = new AgedItem(getMaxIndex(items)+1, name, sellIn, quality, value);
                break;
            case "LegendaryItem":
                item = new LegendaryItem(getMaxIndex(items)+1, name, sellIn, quality, value);
                break;
            case "EventItem":
                item = new EventItem(getMaxIndex(items)+1, name, sellIn, quality, value);
                break;
            case "GenericItem":
                item = new GenericItem(getMaxIndex(items)+1, name, sellIn, quality, value);
                break;
            case "ConjuredItem":
                item = new ConjuredItem(getMaxIndex(items)+1, name, sellIn, quality, value);
                break;
            case "RelicItem":
                item = new RelicItem(getMaxIndex(items)+1, name, quality, value);
                break;
        }
        return item;
    }
}
