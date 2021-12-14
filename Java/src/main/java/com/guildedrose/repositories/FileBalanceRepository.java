package com.guildedrose.repositories;

import com.guildedrose.items.Item;
import com.guildedrose.shop.BalanceRepository;

import java.io.*;
import java.nio.Buffer;

public class FileBalanceRepository implements BalanceRepository {
    @Override
    public int GetBalance() {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("balance.txt"));
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(line);
    }

    @Override
    public void SaveBalance(int balance) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("balance.txt"));
            bw.write(String.format("%d", balance));

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
