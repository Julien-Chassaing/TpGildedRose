package com.guildedrose;

import com.guildedrose.repositories.GildedRose;

public class App {

    public static void main(String[] args) {
        //GildedRose gr = new GildedRose();
        //gr.shop();
        Shop shop = new Shop(new InMemoryRepository());

    }

}

