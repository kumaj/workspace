package com.ca.receipe;
/**
 * Ingredient for coffee
 */
import java.util.ArrayList;
import java.util.List;

public class CoffeeIngredients extends Ingredients {
	private static List<IngredientAvailibiltyAndCostPerUnit>  coffeeIngredientsList = new ArrayList<IngredientAvailibiltyAndCostPerUnit>();
	
	public void addCoffeeIngredients(IngredientAvailibiltyAndCostPerUnit availibiltyAndCostPerUnit) {
		coffeeIngredientsList.add(availibiltyAndCostPerUnit);
	}
	
	public void removeCoffeeIngredients(String ingredientName) {
		coffeeIngredientsList.remove(ingredientName);
	}
	
	public void printCoffeeIngredients() {
		for (IngredientAvailibiltyAndCostPerUnit ingredient : coffeeIngredientsList) {
			System.out.println("Ingrdient Name : " + ingredient.getIngredientName() + " Cost Per unit : " + ingredient.getCostPerUnit());
		}
	}

	public static List<IngredientAvailibiltyAndCostPerUnit> getCoffeeIngredientsList() {
		return coffeeIngredientsList;
	}

	public static void setCoffeeIngredientsList(
			List<IngredientAvailibiltyAndCostPerUnit> coffeeIngredientsList) {
		CoffeeIngredients.coffeeIngredientsList = coffeeIngredientsList;
	}
	
	/**
	 * Method to update the availibilty unit
	 * @param ingredientName
	 * @param newUnit
	 */
	public void updateCoffeeIngredientUnit(String ingredientName, double newUnit) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : coffeeIngredientsList) {
			if(ingredientName.equals(commonIngr.getIngredientName())) {
				commonIngr.setUnitsAvailable(newUnit);
				break;
			}
		}
	}
	

	/**
	 * Method to update the cost per unit
	 * @param ingredientName
	 * @param newUnit
	 */
	public void updateCoffeeIngredientCostPerUnit(String ingredientName, double newPrice) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : coffeeIngredientsList) {
			if(ingredientName.equals(commonIngr.getIngredientName())) {
				commonIngr.setCostPerUnit(newPrice);
				break;
			}
		}
	}
}
