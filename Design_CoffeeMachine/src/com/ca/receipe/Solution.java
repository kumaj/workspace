package com.ca.receipe;

/**
 * Driver class to initiate the coffee machine
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		//Initialise the ingredient, its initial amount and cost per unit
		IngredientAvailibiltyAndCostPerUnit ing1 = new IngredientAvailibiltyAndCostPerUnit("Milk", 4.0, 2.0);
		IngredientAvailibiltyAndCostPerUnit ing2 = new IngredientAvailibiltyAndCostPerUnit("Water", 4.0, 0.0);
		IngredientAvailibiltyAndCostPerUnit ing3 = new IngredientAvailibiltyAndCostPerUnit("Tea", 4.0, 3.0);
		IngredientAvailibiltyAndCostPerUnit ing4 = new IngredientAvailibiltyAndCostPerUnit("Coffee", 4.0, 4.0);
		IngredientAvailibiltyAndCostPerUnit ing5 = new IngredientAvailibiltyAndCostPerUnit("Cream", 4.0, 5.0);
		
		Ingredients ingr = new Ingredients();
		ingr.addCommonIngredients(ing1); ingr.addCommonIngredients(ing2);
		
		TeaIngredients teaIngr = new TeaIngredients();
		teaIngr.addTeaIngredients(ing3);
		
		CoffeeIngredients coffeeIngr = new CoffeeIngredients();
		coffeeIngr.addCoffeeIngredients(ing4); coffeeIngr.addCoffeeIngredients(ing5);
		
		CoffeeController controller = new CoffeeController();
		controller.displayMenuAndIngredients();
	}
}
