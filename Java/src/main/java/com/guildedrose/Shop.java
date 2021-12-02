package com.guildedrose;

import com.guildedrose.entities.Item;

import java.util.ArrayList;

public class Shop {
    private IInventoryRepository repository;

    public Shop(IInventoryRepository repository){
        this.repository = repository;
    }

    public void updateQuality() {
        ArrayList<Item> items = this.repository.GetInventory();

        for (Item item : items) {
            item.update();
        }

        this.repository.SaveInventory(items);
    }
}
