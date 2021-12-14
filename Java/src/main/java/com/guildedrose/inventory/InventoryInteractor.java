package com.guildedrose.inventory;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer{
    private ItemsRepository repository;

    public InventoryInteractor(ItemsRepository repository){
        this.repository = repository;
    }

    public void updateQuality(){
        ArrayList<Item> items = this.repository.GetInventory();

        for(Item item : items){
            item.update();
        }

        this.repository.SaveInventory(items);
    }

    @Override
    public ArrayList<Item> getInventory() {
        return repository.GetInventory();
    }

    @Override
    public ArrayList<Item> getInventoryByQuantity() {
        return null;
    }

}
