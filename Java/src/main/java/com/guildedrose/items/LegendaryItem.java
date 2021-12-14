package com.guildedrose.items;

public class LegendaryItem extends Item {
    public LegendaryItem(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }
    public LegendaryItem(int index, String name, int sellin, int quality, int value) {
        super(index, name, sellin, quality, value);
    }

    @Override
    public void update() {
    }

}
