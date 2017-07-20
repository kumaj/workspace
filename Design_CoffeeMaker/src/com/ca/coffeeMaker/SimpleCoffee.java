package com.ca.coffeeMaker;

/**
 * This class makes the simple coffee 
 * @author kumaj04
 *
 */
public class SimpleCoffee implements Coffee {

	@Override
	public String makeCoffee() {
		return "Simple Coffee";
	}

	@Override
	public int getPrice() {
		return 100;
	}

}
