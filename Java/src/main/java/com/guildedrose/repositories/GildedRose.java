package com.guildedrose.repositories;

import com.guildedrose.entities.Item;

import java.util.Arrays;

public class GildedRose {

    public void updateQuality(){

        int day = 10;

        Item item1 = new Item();
        item1.setNom("Aged Brie");
        item1.setSellin(5);
        item1.setQuality(5);

        Item item2 = new Item();
        item2.setNom("Sulfuras");
        item2.setQuality(10);
        item2.setLegendary(1);

        Item item3 = new Item();
        item3.setNom("Backstage passes");
        item3.setSellin(10);
        item3.setQuality(0);

        Item item4 = new Item();
        item4.setNom("Item normal");
        item4.setSellin(7);
        item4.setQuality(8);

        Item items [] = {item1, item2, item3, item4};

        for(int i = 0; i < day; i++){
            for ( Item item : items) {
                if(item.getNom() != "Sulfuras"){
                    if(item.getSellin() != 0){
                        item.setSellin(item.getSellin() -1);
                    }
                    else{
                        item.setSellin(0);
                    }
                }
                if(item.getNom() == "Aged Brie"){
                    if(item.getQuality() < 50){
                        item.setQuality(item.getQuality() +1);
                    }
                    else{
                        item.setQuality(50);
                    }
                }
                else if(item.getNom() == "Backstage passes"){
                    if(item.getQuality() < 50 && item.getSellin() > 10){
                        item.setQuality(item.getQuality() +1);
                    }
                    else if(item.getQuality() < 49 && item.getSellin() <= 10 && item.getSellin() > 5){
                        item.setQuality(item.getQuality() +2);
                    }
                    else if(item.getQuality() < 48 && item.getSellin() <= 5 && item.getSellin() > 0){
                        item.setQuality(item.getQuality() +3);
                    }
                    else if(item.getSellin() == 0){
                        item.setQuality(0);
                    }
                }
                else if(item.getLegendary() == 1){
                    item.setQuality(item.getQuality());
                }
                else {
                    if(item.getQuality() > 0){
                        item.setQuality(item.getQuality() -1);
                    }
                    else{
                        item.setQuality(0);
                    }
                }
            }
        }
        for ( Item item : items) {
            if(item.getLegendary() != 1){
                System.out.println(item.toString());
            }
            else{
                System.out.println(item.toStringLeg());
            }
        }
    }

}
