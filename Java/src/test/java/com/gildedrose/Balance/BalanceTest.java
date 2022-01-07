package com.gildedrose.Balance;

import com.guildedrose.balance.BalanceInteractor;
import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.items.AgedItem;
import com.guildedrose.items.EventItem;
import com.guildedrose.items.Item;
import com.guildedrose.items.RelicItem;
import com.guildedrose.repositories.FileBalanceRepository;
import com.guildedrose.repositories.InMemoryBalanceRepository;
import com.guildedrose.repositories.InMemoryItemsRepository;
import com.guildedrose.shop.BalanceRepository;
import com.guildedrose.shop.ShopInteractor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BalanceTest {

    @Test
    public void testGetBalance() {
        InMemoryBalanceRepository repository = new InMemoryBalanceRepository();

        assertEquals(500000, repository.GetBalance());
    }

    @Test
    public void testSaveBalance() {
        InMemoryBalanceRepository repository = new InMemoryBalanceRepository();

        repository.SaveBalance(250000);

        assertEquals(250000, repository.GetBalance());
    }

    @Test
    public void testSellItem() {
        ShopInteractor shopInteractor = new ShopInteractor(new InMemoryItemsRepository(), new InMemoryBalanceRepository());

        shopInteractor.sellItem(3); // new EventItem(3,"Backstage passes", 10, 0, 20) -> price = 20

        assertEquals(500000 + 20, shopInteractor.GetBalance());
        assertFalse(shopInteractor.GetInventory().contains(new EventItem(3,"Backstage passes", 10, 0, 20)));
    }

    @Test
    public void testBuyItem() {
        ShopInteractor shopInteractor = new ShopInteractor(new InMemoryItemsRepository(), new InMemoryBalanceRepository());
        ArrayList<Item> items = shopInteractor.GetInventory();

        shopInteractor.buyItem("AgedItem", "Aged Brie Test", 15, 5, 20);

        assertEquals(500000 - 20, shopInteractor.GetBalance());

        assertEquals(items.get(items.size() - 1).getName(), "Aged Brie Test");
        assertEquals(items.get(items.size() - 1).getSellin(), 15);
        assertEquals(items.get(items.size() - 1).getQuality(), 5);
        assertEquals(items.get(items.size() - 1).getValue(), 20);
    }

}
