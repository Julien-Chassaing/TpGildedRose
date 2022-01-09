package com.guildedrose.inventory;

import com.guildedrose.items.Item;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

public interface InventoryViewer {
    ArrayList<Item> getInventory();
    Stream<Map.Entry<String, Long>> getInventoryByQuantity();
}
