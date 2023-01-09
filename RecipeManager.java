import java.util.*;

/**
 * The class RecipeManager contains a few methods to be called in class lab5.
 * @author Jeremywang
 * @version 11th
 * @see class Recipemanager
 * @since 11th
 */
@SuppressWarnings("javadoc")
public class RecipeManager extends RecipeTemplate {
	// the method userInputInt throws exception of none-integer user inputs
	public static int userInputInt() {
		int option;

		try {
			Scanner userInput = new Scanner(System.in);
			option = userInput.nextInt();

			return option;
		} catch (InputMismatchException err) {
			System.out.print("Invalid input.\n");

			return 0;
		}

	}
	// the method showRecipe shows available bread for selection
	public void showRecipe() {
		System.out.print("\n");
		System.out.print("Available recipies are: \n");

		for (int i = 0; i < NUMRECIPES; i++) {
			System.out.println((i + 1) + ". " + names[i]);
		}

	}
	// the method createList shows the bread and its quantity user just chose
	public void createList(int breadNumber, int quantity) {

		System.out.print("You have chosen " + quantity + " loaves of " + names[breadNumber]);

	}
	// the method printList prints the total bread and their quantities and the total amount ingredients required.
	public void printList(boolean[] bread, int[] quantities) {
		// if any of the chosen bread's boolean element is true, it will print the quantities and name.
		for (int i = 0; i < NUMRECIPES; i++) {
			if (bread[i]) {
				System.out.println(quantities[i] + " " + names[i]);
			}
		}

		float flourAmount = 0, yeastAmount = 0, sugarAmount = 0, eggsAmount = 0, butterAmount = 0;
		// accumulate the ingredient amount based on chosen bread and quantities
		for (int i = 0; i < NUMRECIPES; i++) {
			if (bread[i]) {
				flourAmount += (flour[i] * quantities[i]);
				yeastAmount += (yeast[i] * quantities[i]);
				sugarAmount += (sugar[i] * quantities[i]);
				eggsAmount += (eggs[i] * quantities[i]);
				butterAmount += (butter[i] * quantities[i]);

			}
		}

		boolean thereisbread = false;

		for (boolean chosen : bread) {
			thereisbread = chosen;
			if (chosen) {
				break;
			}
		}

		if (!thereisbread) {
			System.out.println("No bread.");
		} else {
			System.out.println("You will need a total of: ");
			if (flourAmount != 0) {
				System.out.println(flourAmount + " grams of flour.");
			}
			if (yeastAmount != 0) {
				System.out.println(yeastAmount + " grams of yeast.");
			}
			if (sugarAmount != 0) {
				System.out.println(sugarAmount + " grams of sugar.");
			}
			if (eggsAmount != 0) {
				System.out.println(eggsAmount + " eggs.");
			}
			if (butterAmount != 0) {
				System.out.println(butterAmount + " grams of butter.");
			}

		}
	}

	public void quitProgram() {
		System.out.println("Thank you for using Jeremy's app, bye~");
	}

}
