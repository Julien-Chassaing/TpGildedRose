package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.items.AgedItem;
import com.guildedrose.items.EventItem;
import com.guildedrose.items.GenericItem;
import com.guildedrose.items.LegendaryItem;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class InMemoryRepository implements IInventoryRepository {
    FileWriter fileWriter = new FileWriter("inventory.txt");
    String line = "";

    ArrayList<Item> items = new ArrayList<Item>();

    public InMemoryRepository() throws IOException {
        items.add(new AgedItem("Aged Brie", 5, 5));
        items.add(new LegendaryItem("Sulfuras", 10, 1));
        items.add(new EventItem("Backstage passes", 10, 0));
        items.add(new GenericItem("Item normal", 7, 8));

        SaveInventory(items);
    }

    @Override
    public ArrayList<Item> GetInventory() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.txt"));
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] employee = line.split(splitBy);
                System.out.println("Employee [Item=" + employee[0] + ", Name=" + employee[1] + ", SellIn=" + employee[2] + ", Quality=" + employee[3] + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        try {
            FileWriter fileWriter = new FileWriter("inventory.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Item item : items) {
                bw.write(String.format("%s,%s,%d,%d", item.getClass().getSimpleName(), item.getNom(), item.getSellin(), item.getQuality()));
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.items = items;
    }
}
