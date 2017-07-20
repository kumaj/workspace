package com.ca.coffeeMaker;

/**
 * This is the interface to make the coffee and get its price.
 * Decorator design pattern has been used
 * @author kumaj04
 *
 */
public interface Coffee {

	public String makeCoffee();
	
	public int getPrice();
}
