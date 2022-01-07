package com.guildedrose.inventory;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryUpdater {
    void updateQuality();
    void SaveInventory(ArrayList<Item> items);
}
