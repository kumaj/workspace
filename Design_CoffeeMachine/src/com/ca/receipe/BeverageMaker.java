package com.ca.receipe;
/**
 * Interface which makes/process the actual beverage
 * @author kumaj04
 *
 */
public interface BeverageMaker {
	public boolean isAllIngredientsAvailableForBeverage(MenuItem menuItem);
	public Beverage createBeverage(MenuItem menuItem);
	public Beverage addExtraItemToBeverage(Beverage beverage, String ingredientName, double unitsToBeAdded);
}
