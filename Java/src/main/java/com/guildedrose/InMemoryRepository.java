package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.items.AgedItem;
import com.guildedrose.items.EventItem;
import com.guildedrose.items.GenericItem;
import com.guildedrose.items.LegendaryItem;

import java.util.ArrayList;

public class InMemoryRepository implements IInventoryRepository {

    ArrayList<Item> items = new ArrayList<Item>();

    public InMemoryRepository() {
        items.add(new AgedItem("Aged Brie", 5, 5));
        items.add(new LegendaryItem("Sulfuras", 10, 1));
        items.add(new EventItem("Backstage passes", 10, 0));
        items.add(new GenericItem("Item normal", 7, 8));
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
