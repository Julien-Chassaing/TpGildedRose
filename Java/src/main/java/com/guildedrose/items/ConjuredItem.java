package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin--;
        this.quality -= 2;

        this.CellQualityToFifty();
        this.FloorQualityToZero();


    }
}
