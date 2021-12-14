package com.guildedrose.items;

public class AgedItem extends Item {
    public AgedItem(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }
    public AgedItem(int index, String name, int sellin, int quality, int value) {
        super(index, name, sellin, quality, value);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
