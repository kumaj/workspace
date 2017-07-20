package com.ca.receipe;
import java.util.ArrayList;
import java.util.List;

/**
 * Class having the common ingredients list.
 * Map to store ingredientName and its cost/unit and its available unit of quantity
 * @author kumaj04
 *
 */
public class Ingredients {
	private static List<IngredientAvailibiltyAndCostPerUnit> commonIngredientsList = new ArrayList<IngredientAvailibiltyAndCostPerUnit>();

	/**
	 * @return the commonIngredientsList
	 */
	public static List<IngredientAvailibiltyAndCostPerUnit> getCommonIngredientsList() {
		return commonIngredientsList;
	}

	/**
	 * @param commonIngredientsList the commonIngredientsList to set
	 */
	public static void setCommonIngredientsList(List<IngredientAvailibiltyAndCostPerUnit> commonIngredientsList) {
		Ingredients.commonIngredientsList = commonIngredientsList;
	}
	
	public void addCommonIngredients(IngredientAvailibiltyAndCostPerUnit ingredientName) {
		commonIngredientsList.add(ingredientName);
	}
	
	public void removeCommonIngredients(IngredientAvailibiltyAndCostPerUnit ingredientName) {
		commonIngredientsList.remove(ingredientName);
	}
	
	/**
	 * Method to update the availibilty unit
	 * @param ingredientName
	 * @param newUnit
	 */
	public void updateCommonIngredientUnit(String ingredientName, double newUnit) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : commonIngredientsList) {
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
	public void updateCommonIngredientCostPerUnit(String ingredientName, double newPrice) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : commonIngredientsList) {
			if(ingredientName.equals(commonIngr.getIngredientName())) {
				commonIngr.setCostPerUnit(newPrice);
				break;
			}
		}
	}
	
	public void printCommonIngredients() {
		for (IngredientAvailibiltyAndCostPerUnit ingredient : commonIngredientsList) {
			System.out.println("Ingrdient Name : " + ingredient.getIngredientName() + " Cost Per unit : " + ingredient.getCostPerUnit());
		}
	}
	
}
