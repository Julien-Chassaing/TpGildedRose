package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class GenericItem extends Item {

    public GenericItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality --;

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
