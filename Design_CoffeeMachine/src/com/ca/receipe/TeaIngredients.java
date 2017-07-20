package com.ca.receipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Ingredients for the tea
 * @author kumaj04
 *
 */
public class TeaIngredients extends Ingredients {
	private static List<IngredientAvailibiltyAndCostPerUnit> teaIngredientsList = new ArrayList<IngredientAvailibiltyAndCostPerUnit>();
	
	public void addTeaIngredients(IngredientAvailibiltyAndCostPerUnit ingredientName) {
		teaIngredientsList.add(ingredientName);
	}
	
	public void removeTeaIngredients(IngredientAvailibiltyAndCostPerUnit ingredientName) {
		teaIngredientsList.remove(ingredientName);
	}
	
	public void printTeaIngredients() {
		for (IngredientAvailibiltyAndCostPerUnit ingredient : teaIngredientsList) {
			System.out.println("Ingrdient Name : " + ingredient.getIngredientName() + " Cost Per unit : " + ingredient.getCostPerUnit());
		}
	}

	/**
	 * Method to update the availibilty unit
	 * @param ingredientName
	 * @param newUnit
	 */
	public void updateTeaIngredientUnit(String ingredientName, double newUnit) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : teaIngredientsList) {
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
	public void updateTeaIngredientCostPerUnit(String ingredientName, double newPrice) {
		for (IngredientAvailibiltyAndCostPerUnit commonIngr : teaIngredientsList) {
			if(ingredientName.equals(commonIngr.getIngredientName())) {
				commonIngr.setCostPerUnit(newPrice);
				break;
			}
		}
	}

	
	/**
	 * @return the teaIngredientsList
	 */
	public static List<IngredientAvailibiltyAndCostPerUnit> getTeaIngredientsList() {
		return teaIngredientsList;
	}

	/**
	 * @param teaIngredientsList the teaIngredientsList to set
	 */
	public static void setTeaIngredientsList(List<IngredientAvailibiltyAndCostPerUnit> teaIngredientsList) {
		TeaIngredients.teaIngredientsList = teaIngredientsList;
	}
}
