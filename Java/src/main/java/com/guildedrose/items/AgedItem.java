package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class AgedItem extends Item {
    public AgedItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
