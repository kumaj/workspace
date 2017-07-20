package com.ca.receipe;

import java.util.List;

public class CoffeeController {

	public void displayMenuAndIngredients() {
		List<IngredientAvailibiltyAndCostPerUnit> commonIngr = Ingredients.getCommonIngredientsList();
		List<IngredientAvailibiltyAndCostPerUnit> coffeeIngr = CoffeeIngredients.getCoffeeIngredientsList();
		List<IngredientAvailibiltyAndCostPerUnit> teaIngr = TeaIngredients.getTeaIngredientsList();
		
		System.out.println("Avaialble Menu and ingredients");
		for (MenuItem item : MenuItem.values()) {
			System.out.print(item + " ");
		}
		System.out.println();
		for (IngredientAvailibiltyAndCostPerUnit common : commonIngr) {
			System.out.print(common.getIngredientName() + "-->" + common.getCostPerUnit() + " ");
		}
		for (IngredientAvailibiltyAndCostPerUnit coffee : coffeeIngr) {
			System.out.print(coffee.getIngredientName() + "-->" + coffee.getCostPerUnit() + " ");
		}
		for (IngredientAvailibiltyAndCostPerUnit tea : teaIngr) {
			System.out.print(tea.getIngredientName() + "-->" + tea.getCostPerUnit() + " ");
		}
	}
}
