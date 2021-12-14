package com.guildedrose.items;

public class GenericItem extends Item {

    public GenericItem(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    @Override
    public void update() {
        this.sellin --;

        if (sellin < 0) {
            this.quality -= 2;
        }
        else {
            this.quality --;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
