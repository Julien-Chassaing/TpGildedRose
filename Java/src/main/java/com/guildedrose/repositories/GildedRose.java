package com.guildedrose.repositories;

import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import java.util.Arrays;

public class GildedRose {

    public void shop(){

        int day = 10;

        Item item1 = new AgedItem("Aged Brie", 5, 5);

        Item item2 = new LegendaryItem("Sulfuras", 10, 1);

        Item item3 = new EventItem("Backstage passes", 10, 0);

        Item item4 = new GenericItem("Item normal", 7, 8);

        Item[] items = {item1, item2, item3, item4};

        for(int i = 0; i < day; i++){
            for ( Item item : items) {
                item.update();
            }
        }
        for( Item item: items){
            System.out.println(item);
        }
     }

}
