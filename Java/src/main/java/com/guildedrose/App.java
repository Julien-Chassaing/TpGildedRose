package com.guildedrose;

import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.inventory.InventoryUpdater;
import com.guildedrose.inventory.InventoryViewer;
import com.guildedrose.items.Item;
import com.guildedrose.repositories.FileItemsRepository;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("-------------------------Menu Guilded Rose--------------------------");
            System.out.println("0.Quitter le menu");
            System.out.println("1.Afficher l'inventaire");
            System.out.println("2.Afficher l'inventaire en fonction de la quantité");
            System.out.println("3.Mettre à jour l'inventaire");
            System.out.println("4.Afficher le solde du shop");
            System.out.print("Saisir votre choix : ");
            choice = scanner.nextInt();
            System.out.println();
            switch(choice)
            {
                case 0:
                    System.exit(0);

                case 1:
                    System.out.println("Inventaire : \n");
                    DisplayInventoryCommand();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Inventaire par quantité : ");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Mise à jour de l'inventaire... ");
                    UpdateInventoryCommand();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Solde du shop :");
                    System.out.println();
                    break;

                default: String error = "Choix inexistant dans le menu !";
                    System.out.println(error);
                    break;
            }
        }while(true);
    }

    public static void DisplayInventoryCommand(){
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        for (Item item : inventoryViewer.getInventory()) {
            System.out.printf("Name=%s, SellIn=%d, Quality=%d%n, Value=%d", item.getName(), item.getSellin(), item.getQuality(), item.getValue());
        }
    }
    public static void DisplayInventoryByCountCommand() throws IOException {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        inventoryViewer.getInventoryByQuantity();
    }
    public static void UpdateInventoryCommand(){
        InventoryUpdater inventoryUpdater = new InventoryInteractor(new FileItemsRepository());
        inventoryUpdater.updateQuality();
        System.out.println("Inventaire mis à jour !");
    }





}

