package com.guildedrose;

import com.guildedrose.entities.Item;

import java.io.IOException;
import java.util.ArrayList;

public class Shop {
    private IInventoryRepository repository;

    public Shop(IInventoryRepository repository){
        this.repository = repository;
    }

    public void updateQuality(int day){
        ArrayList<Item> items = this.repository.GetInventory();

        for(int i = 0; i < day; i++){
            for(Item item : items){
                item.update();
            }
        }

        this.repository.SaveInventory(items);
    }
}
