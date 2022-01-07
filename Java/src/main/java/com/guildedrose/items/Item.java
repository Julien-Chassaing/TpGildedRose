package com.guildedrose.items;

import com.guildedrose.repositories.FileBalanceRepository;

public abstract class Item {

    FileBalanceRepository fileBalanceRepository = new FileBalanceRepository();

    protected int index;
    protected String name;
    protected int sellin;
    protected double quality;
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

    public Item(int index, String name, double quality, int value) {
        this.index = index;
        this.name = name;
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

    protected void CellQualityToHundred() {
        if (this.quality >= 100) {
            this.quality = 100;
        }
    }

    protected void AddRelicPriceToBalance() {
        double balance = fileBalanceRepository.GetBalance();
        double newValue = (this.getQuality() / 1000) * this.getValue();
        fileBalanceRepository.SaveBalance(balance + Math.floor(newValue));
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

    public double getQuality() {
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
