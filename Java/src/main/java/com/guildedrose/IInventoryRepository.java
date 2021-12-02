package com.guildedrose;

import com.guildedrose.entities.Item;

import java.util.ArrayList;

public interface IInventoryRepository {
    ArrayList<Item> GetInventory();

    void SaveInventory(ArrayList<Item> items);
}
