package com.ca.receipe;

import java.util.List;

/**
 * 
 * @author kumaj04
 *
 */
public class Beverage {
	private String beverageName;
	private List<ReceipeItem> ingredientList; // Ingredient name and its unit 
	private double totalCost;
	private String status;
	
	public Beverage(String beverageName, List<ReceipeItem> ingredientList, double totalCost, String status) {
		this.setBeverageName(beverageName);
		this.setIngredientList(ingredientList);
		this.setTotalCost(totalCost);
		this.setStatus(status);
	}

	/**
	 * @return the beverageName
	 */
	public String getBeverageName() {
		return beverageName;
	}

	/**
	 * @param beverageName the beverageName to set
	 */
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}

	/**
	 * @return the ingredientList
	 */
	public List<ReceipeItem> getIngredientList() {
		return ingredientList;
	}

	/**
	 * @param ingredientList the ingredientList to set
	 */
	public void setIngredientList(List<ReceipeItem> ingredientList) {
		this.ingredientList = ingredientList;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
