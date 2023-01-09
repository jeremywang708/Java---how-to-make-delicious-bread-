/**
 * File name: Lab5.java
 * Author: Yun Wang, ID# 041069121
 * Course: CST8132 – OOP, Lab Section: 302
 * Lab: 05
 * Date: 2022-11-29
 * Professor: Gustavo Adami
 */

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * The Lab5 class is to run the method menu() and execute different operations based on different user input.
 * @author Jeremywang
 * @version This is the 11th version
 * @see class Recipe, class Recipemanager and class RecipeTemplate
 * @since version 11
 */
@SuppressWarnings("javadoc")
public class Lab5 {

	static RecipeManager manager = new RecipeManager();
	static boolean[] bread = new boolean[manager.NUMRECIPES];
	static int[] quantities = new int[manager.NUMRECIPES];

	public static void main(String[] args) throws Throwable {
		menu();
	}
	
	/**This menu method serves to show menu options and execute operations based on different user selections, 
     * it returns nothing.
     */
	public static void menu() throws InterruptedException {

		Scanner input = new Scanner(System.in);

		System.out.println("------Menu------ ");
		System.out.println("1. Show available recipes.");
		System.out.println("2. Create a shopping list.");
		System.out.println("3. Print the shopping list.");
		System.out.println("4. Quit the program.");
		System.out.println("0. Reprint this menu.");
		System.out.print("Enter Choice Here: ");

		int option = manager.userInputInt();
		// the method showRecipe will be called if user chooses option 1
		if (option == 1) {
			manager.showRecipe();

			TimeUnit.SECONDS.sleep(3);
			System.out.println("\n\n\n");
			menu();
			
		} else if (option == 2) {
			// limit the user to choose only between 1 to 7
			int breadNumber;
			while (true) {
				System.out.print("Which bread would you like? Pls enter your choice: ");
				breadNumber = manager.userInputInt() - 1;

				if (breadNumber >= 0 && breadNumber <= 6) {
					break;
				}
				System.out.print("Invalid, options are only from 1 to 7!\n");
			}
			// if a certain type of bread is chosen, the according element in the boolean array becomes true
			bread[breadNumber] = true;

			System.out.print("How many loaves of this bread do you want? Pls enter your quantity: ");
			int quantity = manager.userInputInt();
			// accumulate the quantity of the same bread
			quantities[breadNumber] += quantity;

			if (quantities[breadNumber] < 0) {
				quantities[breadNumber] = 0;
			}

			if (quantities[breadNumber] == 0) {
				bread[breadNumber] = false;
			}
			// call the method createList to store the bread and its quantity user just chose
			manager.createList(breadNumber, quantity);

			TimeUnit.SECONDS.sleep(3);
			System.out.println("\n\n\n");
			menu();
		} else if (option == 3) {
			// call the method printList to print everything user just chose
			manager.printList(bread, quantities);
			System.out.println("\n\n\n");
			menu();
		} else if (option == 4) {
			manager.quitProgram();
		} else if (option == 0) {
			System.out.println("\n\n\n");
			menu();
		} else {
			System.out.println("Invalid.");
			System.out.println("\n\n\n");
			menu();
		}
	}

}
