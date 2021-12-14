package com.guildedrose.inventory;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryViewer {
    ArrayList<Item> getInventory();
    ArrayList<Item> getInventoryByQuantity();
}
