package com.guildedrose.repositories;

import com.guildedrose.inventory.ItemsRepository;
import com.guildedrose.items.*;

import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemsRepository {

    ArrayList<Item> items = new ArrayList<Item>();

    public InMemoryItemsRepository() {
        items.add(new AgedItem(1,"Aged Brie", 5, 5, 50));
        items.add(new LegendaryItem(2,"Sulfuras", 10, 1, 500));
        items.add(new EventItem(3,"Backstage passes", 10, 0, 20));
        items.add(new GenericItem(4,"Item normal", 7, 8, 5));
        items.add(new RelicItem(5, "Relic", 60, 50));
        items.add(new AgedItem(6,"Aged Brie", 10, 2, 60));
        items.add(new EventItem(7,"Backstage passes", 5, 15, 80));
        items.add(new EventItem(8,"Backstage passes", 50, 1, 10));
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
