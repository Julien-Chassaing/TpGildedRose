package com.gildedrose.Inventory;

import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.items.*;
import com.guildedrose.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InventoryTest {

    @Test
    void testGetInventory() {
        InventoryInteractor shop = new InventoryInteractor(new InMemoryItemsRepository());

        assertNotNull(shop.getInventory());
    }

    @Test
    void testSaveInventory() {
        InventoryInteractor shop = new InventoryInteractor(new InMemoryItemsRepository());
        ArrayList<Item> items = shop.getInventory();

        AgedItem agedItem1 = new AgedItem("Aged Brie 2", 2, 30, 50);

        items.add(agedItem1);

        shop.SaveInventory(items);

        assertEquals(shop.getInventory().get(items.size() - 1), agedItem1);
    }

    @Test
    void testGetInventoryByQuantity() {
        InventoryInteractor shop = new InventoryInteractor(new InMemoryItemsRepository());
        Stream<Map.Entry<String, Long>> sortedByQuantity = shop.getInventoryByQuantity();

        Map<String, Long> testSortedByQuantity = new HashMap<>();

        sortedByQuantity.forEach((k) -> testSortedByQuantity.put(k.getKey(), k.getValue()));

        assertEquals(testSortedByQuantity.get("Backstage passes"), 3);
        assertEquals(testSortedByQuantity.get("Aged Brie"), 2);
        assertEquals(testSortedByQuantity.get("Sulfuras"), 1);
    }
}
