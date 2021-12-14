package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import java.io.*;
import java.util.ArrayList;

public class InMemoryRepository implements IInventoryRepository {
    //fichier txt
    File file;


    ArrayList<Item> items = new ArrayList<Item>();

    public InMemoryRepository() throws IOException {
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter("inventory.txt");
            items.add(new AgedItem("Aged Brie", 5, 5));
            items.add(new LegendaryItem("Sulfuras", 10, 1));
            items.add(new EventItem("Backstage passes", 10, 0));
            items.add(new GenericItem("Item normal", 7, 8));

            SaveInventory(items);
        }
    }

    @Override
    public ArrayList<Item> GetInventory() {
        ArrayList<Item> items = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.txt"));
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] item = line.split(splitBy);
                switch(item[0]) {
                    case "AgedItem":
                        items.add(new AgedItem(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
                        break;
                    case "LegendaryItem":
                        items.add(new LegendaryItem(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
                        break;
                    case "EventItem":
                        items.add(new EventItem(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
                        break;
                    case "GenericItem":
                        items.add(new GenericItem(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
                        break;
                    case "ConjuredItem":
                        items.add(new ConjuredItem(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.txt"));
            for (Item item : items) {
                bw.write(String.format("%s,%s,%d,%d", item.getClass().getSimpleName(), item.getNom(), item.getSellin(), item.getQuality()));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.items = items;
    }
}
