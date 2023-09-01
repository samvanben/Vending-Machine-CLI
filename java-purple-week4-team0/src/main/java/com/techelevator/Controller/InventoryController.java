package com.techelevator.Controller;

import com.techelevator.Model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InventoryController {
    public List<Item> loadInventory() {
        // Create file object
        File inputFile = new File("main.csv");
        List<Item> items = new ArrayList<>();
        // Check for file existence
        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()) {
                //Load data from file
                String nextLine = input.nextLine();
                //Split into array
                String[] vendingAttributes = nextLine.split("\\,");
                String button = vendingAttributes[0];
                String name = vendingAttributes[1];
                double price = Double.parseDouble(vendingAttributes[2]);
                String type = vendingAttributes[3];
                int stock = 5;

                //Big Switch or if statement to load file into the right subclass
                if (type.equals("Gum")) {
                    Gum gum = new Gum(button, name, price, stock);
                    items.add(gum);
                }

                if (type.equals("Munchy")) {
                    Munchy munchy = new Munchy(button, name, price, stock);
                    items.add(munchy);
                }
                if (type.equals("Drink")) {
                    Drink drink = new Drink(button, name, price, stock);
                    items.add(drink);
                }
                if (type.equals("Candy")) {
                    Candy candy = new Candy(button, name, price, stock);
                    items.add(candy);
                }

                // to.....
                /*
                if type is Candy
                then make a Candy object and place it into the list items

                if type is Drink
                then make a Drink object and place it in the list items
                 */

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;

    }

    double Balance = 0;
    int purchaseCounter = 0;


    public void feedMoney(Scanner scanner) {
        System.out.println("Please enter in a dollar amount: ");
        String amountToAdd = scanner.nextLine();
        Balance += Double.parseDouble(amountToAdd);
        System.out.format("Current Money provided : %.2f", Balance);
        System.out.println();
        logTransactions("FEED MONEY ", Double.parseDouble(amountToAdd), Balance);
    }

    public void selectButton(Scanner scanner, List<Item> items) {
        int itemCost = 0;
        System.out.println("Available Items: ");
        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println("Please select item using the corresponding button (A1/B1/etc): ");
        String itemCode = scanner.nextLine().toUpperCase();
        Item vendingProduct = null;

        for (Item selection : items) {
            if (selection.getButton().equals(itemCode)) {
                vendingProduct = selection;
            }

        }
        if (vendingProduct == null) {
            System.out.println("The button you entered is not valid, please try again.");
        } else if (vendingProduct.getStock() == 0) {
            System.out.println("ERROR: OUT Of STOCK");
        } else if (itemCode.equals(vendingProduct.getButton())) {
            if (vendingProduct.getPrice() > Balance) {
                System.out.println("ERROR: INSUFFICIENT FUNDS");
            } else if (vendingProduct.getPrice() < Balance) {
                double amountPaid = vendingProduct.getPrice();
                purchaseCounter++;
                if (purchaseCounter % 2 == 0) {
                    double salePrice = -1.00;
                    Balance = Balance - salePrice;
                    amountPaid = vendingProduct.getPrice() - 1;
                }
                // Decrementing stock by 1 when chosen by user
                int remainingStock = vendingProduct.getStock() - 1;
                vendingProduct.setStock(remainingStock);

                // Subtracting price from remaining balance, printing out messages
                Balance -= vendingProduct.getPrice();
                System.out.println(vendingProduct.getSound());
                System.out.println("Dispensing: " + vendingProduct.getName());
                System.out.printf("amount paid: $%.2f", amountPaid);
                System.out.printf(" Balance Remaining: $%.2f", Balance);
                System.out.println();
                logTransactions(vendingProduct.getName(), vendingProduct.getPrice() , Balance);
            }
        }
    }
    public void getChange(){
        double previousBalance = Balance;
        int totalChange = (int) (Balance*100);
        int quarters = (int) Math.round(totalChange/25.00);
        totalChange %= 25;

        int dimes = (int) Math.round(totalChange/10.00);
        totalChange %= 10;

        int nickels = (int) Math.round(totalChange/5.00);

        Balance = 0;

        System.out.println("Your change is " + quarters + " Quarters, " + dimes + " Dimes, and "
                + nickels + " Nickels.");
        logTransactions("Change Dispensed ", previousBalance, Balance);
    }
    public void logTransactions(String operation, double firstDollarAmount, double secondDollarAmount){
        try(FileOutputStream bean = new FileOutputStream("Log.txt", true)) {
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            LocalDateTime current = LocalDateTime.now();
            String dateTime = current.format(date);
            String logInput = (dateTime + operation + " " + String.format("%.2f",firstDollarAmount) + " " + String.format("%.2f",secondDollarAmount) + System.lineSeparator());

            byte[] logInputBytes = logInput.getBytes();
            bean.write(logInputBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
