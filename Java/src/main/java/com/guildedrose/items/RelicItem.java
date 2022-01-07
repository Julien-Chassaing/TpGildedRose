package com.guildedrose.items;

public class RelicItem extends Item {

    public RelicItem(int index, String name, int quality, int value) {
        super(index, name, quality, value);
    }

    @Override
    public void update() {
        this.quality += ((this.quality*5)/100);

        this.CellQualityToHundred();

        this.AddRelicPriceToBalance();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }




}
