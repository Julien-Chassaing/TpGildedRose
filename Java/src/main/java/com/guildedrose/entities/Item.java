package com.guildedrose.entities;

public class Item {

    private String nom;
    private int sellin;
    private int quality;
    private int legendary;

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

    public int getLegendary() {return legendary; }

    public void setLegendary(int legendary) {this.legendary = legendary; }

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
