package com.guildedrose.items;

public class EventItem extends Item {
    public EventItem(int index, String name, int sellin, int quality, int value) {
        super(index, name, sellin, quality, value);
    }

    @Override
    public void update() {
        this.sellin --;

        if(this.sellin <= 10 && this.sellin > 5){
            this.quality += 2;
        }
        else if(this.sellin <= 5 && this.sellin > 0){
            this.quality += 3;
        }
        else {
            this.quality ++;
        }
        if(this.sellin < 0){
            this.quality = 0;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
