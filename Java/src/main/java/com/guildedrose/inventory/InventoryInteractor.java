package com.guildedrose.inventory;

import com.guildedrose.items.Item;
import com.guildedrose.items.RelicItem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer{
    private ItemsRepository repository;

    public InventoryInteractor(ItemsRepository repository){
        this.repository = repository;
    }

    public void updateQuality(){
        ArrayList<Item> items = this.repository.GetInventory();

        for(Item item : items){
            item.update();
        }

        this.repository.SaveInventory(items);
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        repository.SaveInventory(items);
    }

    @Override
    public ArrayList<Item> getInventory() {
        return repository.GetInventory();
    }

    @Override
    public Stream<Map.Entry<String, Long>> getInventoryByQuantity() {
        ArrayList<Item> items = repository.GetInventory();

        return items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }



}
