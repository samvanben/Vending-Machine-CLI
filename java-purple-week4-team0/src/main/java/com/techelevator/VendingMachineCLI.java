package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import com.techelevator.Controller.InventoryController;
import com.techelevator.Model.Item;
import com.techelevator.View.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "(1) Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "(2) Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "(3) Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	List<Item> result;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		InventoryController controller = new InventoryController();

		result = controller.loadInventory();
	}

	public static void main(String[] args) {
		// You will need to create a Menu class to handle display.
		Menu menu = new Menu();
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void run() {



		InventoryController controller = new InventoryController();
		List<Item> result = new ArrayList<>();
		result = controller.loadInventory();

		double Balance = 0;





		// To check list size
//		System.out.println(result.size());

		while (true) {
			// Printing out the three options

			menu.chooseVendingOption(MAIN_MENU_OPTIONS);
			// Use a method from your Menu class to initialize this value
			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();


			if (choice.equals("1")) {
				// display vending machine items
				//ToDo:update stock to reflect current stock/out of stock, indicate item is SOLD OUT
                // This is printing the list of items.
				for(Item current : result){
					System.out.println(current);
					continue;
				}

			} while (choice.equals("2")) {
				// Print out Purchase Options
				menu.purchaseOptions(MAIN_MENU_OPTION_PURCHASE);
				// do purchase
				Scanner purchaseScanner = new Scanner(System.in);
				String purchaseMenuChoice = scanner.nextLine();
				if (purchaseMenuChoice.equals("1")) {
					controller.feedMoney(scanner);



				}else if (purchaseMenuChoice.equals("2")) {
					for (Item current : result) {
						controller.selectButton(scanner, result);
						break;
					}


				}else if(purchaseMenuChoice.equals("3")){
					controller.getChange();
					break;
				}
			}
			if(choice.equals("3")){
				break;
			}
		}
	}
}
