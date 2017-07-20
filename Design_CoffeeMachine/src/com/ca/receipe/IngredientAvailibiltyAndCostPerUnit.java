package com.ca.receipe;
/**
 * Class to store the units of items available and cost per unit.
 * @author kumaj04
 *
 */
public class IngredientAvailibiltyAndCostPerUnit {
	private String ingredientName;
	private double unitsAvailable;
	private double costPerUnit;
	
	public IngredientAvailibiltyAndCostPerUnit(String ingredientName, double unitsAvailable, double costPerUnit) {
		this.ingredientName = ingredientName;
		this.unitsAvailable = unitsAvailable;
		this.costPerUnit = costPerUnit;
	}
	
	/**
	 * @return the unitsAvailable
	 */
	public double getUnitsAvailable() {
		return unitsAvailable;
	}
	/**
	 * @param unitsAvailable the unitsAvailable to set
	 */
	public void setUnitsAvailable(double unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}
	/**
	 * @return the costPerUnit
	 */
	public double getCostPerUnit() {
		return costPerUnit;
	}
	/**
	 * @param costPerUnit the costPerUnit to set
	 */
	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}
	/**
	 * @param ingredientName the ingredientName to set
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
}
