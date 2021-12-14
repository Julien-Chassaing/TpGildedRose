package com.guildedrose.shop;


import com.guildedrose.items.Item;

public interface ShopBuy {
    void buyItem(String typeItem, String name, int sellIn, int quality, int value);
}
