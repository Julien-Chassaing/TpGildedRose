package com.guildedrose;

import com.guildedrose.balance.BalanceInteractor;
import com.guildedrose.inventory.InventoryInteractor;
import com.guildedrose.inventory.InventoryUpdater;
import com.guildedrose.inventory.InventoryViewer;
import com.guildedrose.items.Item;
import com.guildedrose.items.RelicItem;
import com.guildedrose.repositories.FileBalanceRepository;
import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.shop.ShopInteractor;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        do
        {
            System.out.println("-------------------------Menu Guilded Rose--------------------------");
            System.out.println("0.Quitter le menu");
            System.out.println("1.Afficher l'inventaire");
            System.out.println("2.Afficher l'inventaire en fonction de la quantité");
            System.out.println("3.Mettre à jour l'inventaire");
            System.out.println("4.Afficher le solde du shop");
            System.out.println("5.Acheter un objet");
            System.out.println("6.Vendre un objet");
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
                    DisplayInventoryByCountCommand();
                    break;

                case 3:
                    System.out.println("Mise à jour de l'inventaire... ");
                    UpdateInventoryCommand();
                    System.out.println();
                    break;

                case 4:
                    DisplayBalance();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("1.AgedItem\n2.LegendaryItem\n3.EventItem\n4.GenericItem\n5.ConjuredItem");
                    System.out.print("Selectionner le type d'item à acheter : ");
                    int typeItem = sc.nextInt();
                    System.out.print("Indiquez le nom de l'item à acheter : ");
                    String nameItem = scString.nextLine();
                    System.out.print("Indiquez le sellin de l'item à acheter : ");
                    int sellinItem = sc.nextInt();
                    System.out.print("Indiquez la quality de l'item à acheter : ");
                    int qualityItem = sc.nextInt();
                    System.out.print("Indiquez le prix de l'item à acheter : ");
                    int valueItem = sc.nextInt();
                    switch (typeItem){
                        case 1:
                            BuyItemCommand("AgedItem",nameItem,sellinItem,qualityItem,valueItem);
                            break;
                        case 2 :
                            BuyItemCommand("LegendaryItem",nameItem,sellinItem,qualityItem,valueItem);
                            break;
                        case 3:
                            BuyItemCommand("EventItem",nameItem,sellinItem,qualityItem,valueItem);
                            break;
                        case 4 :
                            BuyItemCommand("GenericItem",nameItem,sellinItem,qualityItem,valueItem);
                            break;
                        case 5 :
                            BuyItemCommand("ConjuredItem",nameItem,sellinItem,qualityItem,valueItem);
                            break;
                        default: String error = "Choix inexistant dans le menu !";
                            System.out.println(error);
                            break;
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Veuillez indiquer l'id de l'objet à vendre : ");
                    int idItem = sc.nextInt();
                    SellItemCommand(idItem);
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
            if(item instanceof RelicItem) {
                System.out.printf("Index=%d, Name=%s, Quality=%,.2f, Value=%d %n", item.getIndex(), item.getName(), item.getQuality(), item.getValue());
            }
            else {
                System.out.printf("Index=%d, Name=%s, SellIn=%d, Quality=%,.2f, Value=%d %n", item.getIndex(), item.getName(), item.getSellin(), item.getQuality(), item.getValue());
            }
        }
    }
    public static void DisplayInventoryByCountCommand() throws IOException {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        Stream<Map.Entry<String, Long>> sortedByQuantity = inventoryViewer.getInventoryByQuantity();

        //Stream<Map.Entry<String, Long>> sortedByQuantity = inventoryViewer.getInventoryByQuantity();
        sortedByQuantity.forEach((k) -> System.out.println("Item: " + k.getKey() + ", Quantity: " + k.getValue()));
    }
    public static void UpdateInventoryCommand(){
        InventoryUpdater inventoryUpdater = new InventoryInteractor(new FileItemsRepository());
        inventoryUpdater.updateQuality();
        System.out.println("Inventaire mis à jour !");
    }

    public static void SellItemCommand(int index){
        ShopInteractor shopInteractor = new ShopInteractor(new FileItemsRepository(), new FileBalanceRepository());
        shopInteractor.sellItem(index);
        System.out.println("Item vendu !");
    }


    public static void BuyItemCommand(String typeItem, String name, int sellIn, int quality, int value){
        ShopInteractor shopInteractor = new ShopInteractor(new FileItemsRepository(), new FileBalanceRepository());
        shopInteractor.buyItem(typeItem, name, sellIn, quality, value);
        System.out.println("Item acheté !");
    }

    public static void DisplayBalance(){
        BalanceInteractor balanceInteractor = new BalanceInteractor(new FileBalanceRepository());
        System.out.println("Solde du shop : "+balanceInteractor.getBalance());
    }


}

