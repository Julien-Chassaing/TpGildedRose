package com.guildedrose.items;

public abstract class Item {

    protected int index;
    protected String name;
    protected int sellin;
    protected int quality;
    protected int value;

    public Item(String name, int sellin, int quality, int value) {
        this.name = name;
        this.sellin = sellin;
        this.quality = quality;
        this.value = value;
    }

    public Item(int index, String name, int sellin, int quality, int value) {
        this.index = index;
        this.name = name;
        this.sellin = sellin;
        this.quality = quality;
        this.value = value;
    }

    public abstract void update();

    protected void CellQualityToFifty() {
        if (this.quality > 50) {
            this.quality = 50;
        }
    }

    protected void FloorQualityToZero() {
        if (this.quality < 0) {
            this.quality = 0;
        }
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

    public int getSellin() {
        return sellin;
    }

    public void setSellin(int sellin) {
        this.sellin = sellin;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Item{" +
                "nom='" + name + '\'' +
                ", sellin=" + sellin +
                ", quality=" + quality +
                ", value=" + value +
                '}';
    }
}
