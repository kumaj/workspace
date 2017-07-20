package com.ca.receipe;

import java.util.List;

/**
 * Class to create the coffee
 * @author kumaj04
 *
 */
public class CoffeeMaker implements BeverageMaker {

	@Override
	public boolean isAllIngredientsAvailableForBeverage(MenuItem menuItem) {
		// Get the avaialable ingredent for coffee and item required for creating the coffee 
		// compare between both.
		List<IngredientAvailibiltyAndCostPerUnit> commIngr = Ingredients.getCommonIngredientsList();
		List<IngredientAvailibiltyAndCostPerUnit> coffeeIngr = CoffeeIngredients.getCoffeeIngredientsList();
		coffeeIngr.addAll(commIngr);
		
		//get the receipe to create the coffee
		Receipe receipe = new CoffeeReceipe();
		List<ReceipeItem> coffeeReceipe =  receipe.receipe();
		for (ReceipeItem coffeeReceipeItem : coffeeReceipe) {
			for (IngredientAvailibiltyAndCostPerUnit coffeeIngred : coffeeIngr) {
				if(coffeeReceipeItem.getReciepeName().equals(coffeeIngred.getIngredientName()) && coffeeReceipeItem.getUnitsRequired() < coffeeIngred.getUnitsAvailable())
					return false;
			}
		}
		return true;
	}

	@Override
	public Beverage createBeverage(MenuItem menuItem) {
		// first of all check the avaialbilty , if true
		// get the items for available list and check how much quantity is required
		// update the quantity
		// return the response
		// in case of error, return appropiate error response
		Beverage beverage = null;
		if(isAllIngredientsAvailableForBeverage(menuItem)) {
			List<IngredientAvailibiltyAndCostPerUnit> commIngr = Ingredients.getCommonIngredientsList();
			List<IngredientAvailibiltyAndCostPerUnit> coffeeIngr = CoffeeIngredients.getCoffeeIngredientsList();
			coffeeIngr.addAll(commIngr);
			
			beverage = processCoffeeMaking(coffeeIngr);
			//return the response
		} else {
			Receipe receipe = new CoffeeReceipe();
			List<ReceipeItem> coffeeReceipe =  receipe.receipe();
			beverage = new Beverage("Coffee", coffeeReceipe, 0, "Error : Items unavailable to create coffee.");
		}
		return beverage;
	}

	/**
	 * Method to update the avaialbilty of items and calculate the total cost
	 * @param coffeeIngr
	 * @return
	 */
	private Beverage processCoffeeMaking(List<IngredientAvailibiltyAndCostPerUnit> coffeeIngr) {
		Beverage beverage = null;
		CoffeeIngredients coffee = new CoffeeIngredients();		
		//get the receipe to create the coffee
		// and update the unit = available units - required units
		Double totalCost = 0.0;
		Receipe receipe = new CoffeeReceipe();
		List<ReceipeItem> coffeeReceipe =  receipe.receipe();
		for (ReceipeItem coffeeReceipeItem : coffeeReceipe) {
			for (IngredientAvailibiltyAndCostPerUnit coffeeIngred : coffeeIngr) {
				if(coffeeReceipeItem.getReciepeName().equals(coffeeIngred.getIngredientName()) && coffeeReceipeItem.getUnitsRequired() < coffeeIngred.getUnitsAvailable()) {
					coffee.updateCoffeeIngredientUnit(coffeeReceipeItem.getReciepeName(), coffeeIngred.getUnitsAvailable() - coffeeReceipeItem.getUnitsRequired());
					totalCost = totalCost + coffeeReceipeItem.getUnitsRequired()*coffeeIngred.getCostPerUnit();
				}
			}
		}
		beverage = new Beverage("Coffee", coffeeReceipe, totalCost, "Coffee completed successfully");
		return beverage;
	}

	@Override
	public Beverage addExtraItemToBeverage(Beverage beverage, String ingredientName, double unitsToBeAdded) {
		Beverage updatedBeverage = null;
		//Get the list of receipe items of the beverage.
		List<ReceipeItem> receipeItemsList = beverage.getIngredientList();
		ReceipeItem newItem = new ReceipeItem(ingredientName, unitsToBeAdded);
		receipeItemsList.add(newItem);
		
		double ingredPerUnitCost = calculateNewIngredientPerUnitCost(ingredientName);
		double newCost = beverage.getTotalCost() + ingredPerUnitCost*unitsToBeAdded;
		updatedBeverage = new Beverage(beverage.getBeverageName(), receipeItemsList, newCost, "New items added");
		return updatedBeverage;
	}

	/**
	 * Method to calculate the per unit cost of new ingredient.
	 * @param ingredientName
	 * @return
	 */
	private double calculateNewIngredientPerUnitCost(String ingredientName) {
		double ingredPerUnitCost = 0.0;
		List<IngredientAvailibiltyAndCostPerUnit> coffeeIngr = CoffeeIngredients.getCoffeeIngredientsList();
		for (IngredientAvailibiltyAndCostPerUnit ingredient : coffeeIngr) {
			if(ingredient.getIngredientName().equals(ingredientName)) {
				ingredPerUnitCost = ingredient.getCostPerUnit();
			}
		}
		return ingredPerUnitCost;
	}

}
