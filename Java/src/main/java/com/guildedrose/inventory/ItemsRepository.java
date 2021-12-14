package com.guildedrose.inventory;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface ItemsRepository {
    ArrayList<Item> GetInventory();

    void SaveInventory(ArrayList<Item> items);
}
