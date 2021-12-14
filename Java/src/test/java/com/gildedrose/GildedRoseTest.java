package com.gildedrose;

import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.items.*;
import com.guildedrose.repositories.InMemoryBalanceRepository;
import com.guildedrose.repositories.InMemoryItemsRepository;
import com.guildedrose.shop.BalanceRepository;
import com.guildedrose.shop.ShopInteractor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    // Test on AgedBrie Item

    @Test
    void testSellInAndQualityAgedItem() {
        AgedItem agedItem = new AgedItem("Aged Brie", 5, 8, 10);
        agedItem.update();

        // Test SellIn
        assertEquals(4, agedItem.getSellin());

        // Test Quality
        assertEquals(9, agedItem.getQuality());
    }

    @Test
    void testMaxQualityAgedItem() {
        AgedItem agedItem = new AgedItem("Aged Brie", 10, 50, 5);
        agedItem.update();

        assertEquals(50, agedItem.getQuality());
    }

    // Test on Conjured Item

    @Test
    void testSellInAndQualityConjuredItem() {
        ConjuredItem conjuredItem = new ConjuredItem("Conjured", 10, 15, 10);
        conjuredItem.update();

        // Test SellIn
        assertEquals(9, conjuredItem.getSellin());

        // Test Quality
        assertEquals(13, conjuredItem.getQuality());
    }

    @Test
    void testMinQualityConjuredItem() {
        ConjuredItem conjuredItem = new ConjuredItem("Conjured", 10, 1, 20);
        conjuredItem.update();

        assertEquals(0, conjuredItem.getQuality());
    }

    // Test on Legendary Item

    @Test
    void testSellInAndQualityLegendayItem() {
        LegendaryItem legendaryItem = new LegendaryItem("Sulfuras", 10, 15, 15);
        legendaryItem.update();

        // Test SellIn
        assertEquals(10, legendaryItem.getSellin());

        // Test Quality
        assertEquals(15, legendaryItem.getQuality());
    }

    // Test on Generic Item

    @Test
    void testSellInAndQualityGenericItem() {
        GenericItem genericItem = new GenericItem(1,"normal Item", 7, 8, 10);
        genericItem.update();

        // Test SellIn
        assertEquals(6, genericItem.getSellin());

        // Test Quality
        assertEquals(7, genericItem.getQuality());
    }

    @Test
    void testQualityIfSellInNegative() {
        GenericItem genericItem = new GenericItem(2,"normal Item", 0, 6, 53);
        genericItem.update();

        // Test SellIn
        assertEquals(-1, genericItem.getSellin());

        // Test Quality
        assertEquals(4, genericItem.getQuality());
    }

    // Test on Event Item

    @Test
    void testSellInAndQualityEventItem() {
        EventItem eventItem = new EventItem(3,"Backstage passes", 15, 30, 10);
        eventItem.update();

        // Test SellIn
        assertEquals(14, eventItem.getSellin());

        // Test Quality
        assertEquals(31, eventItem.getQuality());
    }

    @Test
    void testQualityWhenSellInBetween10And5() {
        EventItem eventItem = new EventItem(4,"Backstage passes", 8, 15, 20);
        eventItem.update();

        assertEquals(17, eventItem.getQuality());
    }

    @Test
    void testQualityWhenSellInBetween5And0() {
        EventItem eventItem = new EventItem(5,"Backstage passes", 4, 17, 15);
        eventItem.update();

        assertEquals(20, eventItem.getQuality());
    }

    @Test
    void testQualityWhenSellInInf0() {
        EventItem eventItem = new EventItem(6,"Backstage passes", 0, 30, 50);
        eventItem.update();

        // Test SellIn
        assertEquals(-1, eventItem.getSellin());

        // Test Quality
        assertEquals(0, eventItem.getQuality());
    }

    @Test
    void testGetInventory() {
        InventoryInteractor shop = new InventoryInteractor(new InMemoryItemsRepository());
        ArrayList<Item> items = shop.getInventory();

        assertNotNull(items);
    }

    @Test
    void testSellItem() {
        InventoryInteractor shop = new InventoryInteractor(new InMemoryItemsRepository());
        ShopInteractor shopInteractor = new ShopInteractor(new InMemoryItemsRepository(), new InMemoryBalanceRepository());
        shopInteractor.sellItem(3);

    }

}
