package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;

import java.io.*;


public class FileBalanceRepository implements BalanceRepository {
    @Override
    public double GetBalance() {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("balance.txt"));
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(line.replace(",", "."));
    }

    @Override
    public void SaveBalance(double balance) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("balance.txt"));
            bw.write(String.format("%.2f", balance));

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
