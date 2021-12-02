package com.guildedrose.entities;

public abstract class Item {

    protected String nom;
    protected int sellin;
    protected int quality;

    public Item(String name, int sellin, int quality) {
        this.nom = name;
        this.sellin = sellin;
        this.quality = quality;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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


    @Override
    public String toString() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", sellin=" + sellin +
                ", quality=" + quality +
                '}';
    }

    public String toStringLeg() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", quality=" + quality +
                '}';
    }
}
