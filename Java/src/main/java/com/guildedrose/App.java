package com.guildedrose;

import com.guildedrose.repositories.GildedRose;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Shop shop = new Shop(new InMemoryRepository());

        shop.updateQuality(1);
    }

}

