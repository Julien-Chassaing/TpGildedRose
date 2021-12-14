package com.guildedrose.items;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    public ConjuredItem(int index, String name, int sellin, int quality, int value) {
        super(index, name, sellin, quality, value);
    }

    @Override
    public void update() {
        this.sellin--;
        this.quality -= 2;

        this.CellQualityToFifty();
        this.FloorQualityToZero();


    }
}
