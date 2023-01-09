/**
 * a plain Java class. It has getters and setters for each ingredient in the ingredient list: yeast, flour, sugar, eggs, and butter
 * @author Jeremywang
 * @version 11th
 * @see class Recipemanager
 * @since 11th
 */
@SuppressWarnings("javadoc")
public class Recipe {

	private float yeast;
	private float flour;
	private float sugar;
	private float eggs;
	private float butter;

	private int quantity;
	private String breadName;

	public Recipe() {

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBreadName() {
		return breadName;
	}

	public void setBreadName(String breadName) {
		this.breadName = breadName;
	}

	public float getYeast() {
		return yeast;
	}

	public void setYeast(float yeast) {
		this.yeast = yeast;
	}

	public float getFlour() {
		return flour;
	}

	public void setFlour(float flour) {
		this.flour = flour;
	}

	public float getSugar() {
		return sugar;
	}

	public void setSugar(float sugar) {
		this.sugar = sugar;
	}

	public float getEggs() {
		return eggs;
	}

	public void setEggs(float eggs) {
		this.eggs = eggs;
	}

	public float getButter() {
		return butter;
	}

	public void setButter(float butter) {
		this.butter = butter;
	}

}
