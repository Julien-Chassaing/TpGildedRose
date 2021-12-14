package com.guildedrose.repositories;

import com.guildedrose.inventory.ItemsRepository;
import com.guildedrose.items.Item;
import com.guildedrose.items.*;

import java.io.*;
import java.util.ArrayList;

public class FileItemsRepository implements ItemsRepository {

    ArrayList<Item> items = new ArrayList<Item>();

    public FileItemsRepository(){
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
                switch(item[1]) {
                    case "AgedItem":
                        items.add(new AgedItem(Integer.parseInt(item[0]), item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "LegendaryItem":
                        items.add(new LegendaryItem(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "EventItem":
                        items.add(new EventItem(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "GenericItem":
                        items.add(new GenericItem(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "ConjuredItem":
                        items.add(new ConjuredItem(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
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
                bw.write(String.format("%d,%s,%s,%d,%d,%d", item.getIndex(), item.getClass().getSimpleName(), item.getName(), item.getSellin(), item.getQuality(), item.getValue()));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
