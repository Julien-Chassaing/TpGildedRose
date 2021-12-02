package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class EventItem extends Item {
    public EventItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        if(this.sellin <= 10 && this.sellin > 5){
            this.quality += 2;
        }
        else if(this.quality < 48 && this.sellin <= 5 && this.sellin > 0){
            this.quality += 3;
        }
        else if(this.sellin == 0){
            this.quality = 0;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
