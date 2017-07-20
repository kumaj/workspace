package com.ca.receipe;
/**
 * class to store the reciepe name and amount of unit required 
 * @author kumaj04
 *
 */
public class ReceipeItem {
	private String reciepeName;
	private double unitsRequired;
	
	public ReceipeItem(String reciepeName, double unitsRequired) {
		this.reciepeName = reciepeName;
		this.unitsRequired = unitsRequired;
	}
	
	/**
	 * @return the reciepeName
	 */
	public String getReciepeName() {
		return reciepeName;
	}
	
	/**
	 * @param reciepeName the reciepeName to set
	 */
	public void setReciepeName(String reciepeName) {
		this.reciepeName = reciepeName;
	}
	
	/**
	 * @return the units
	 */
	public double getUnitsRequired() {
		return unitsRequired;
	}
	
	/**
	 * @param units the units to set
	 */
	public void setUnitsRequired(double unitsRequired) {
		this.unitsRequired = unitsRequired;
	}
}
