package com.guildedrose.repositories;

import com.guildedrose.inventory.ItemsRepository;
import com.guildedrose.items.Item;
import com.guildedrose.items.AgedItem;
import com.guildedrose.items.EventItem;
import com.guildedrose.items.GenericItem;
import com.guildedrose.items.LegendaryItem;

import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemsRepository {

    ArrayList<Item> items = new ArrayList<Item>();

    public InMemoryItemsRepository() {
        items.add(new AgedItem("Aged Brie", 5, 5, 50));
        items.add(new LegendaryItem("Sulfuras", 10, 1, 500));
        items.add(new EventItem("Backstage passes", 10, 0, 20));
        items.add(new GenericItem("Item normal", 7, 8, 5));
    }

    @Override
    public ArrayList<Item> GetInventory() {
        return items;
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        this.items = items;
    }
}
