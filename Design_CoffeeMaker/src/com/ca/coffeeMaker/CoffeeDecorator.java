package com.ca.coffeeMaker;

public class CoffeeDecorator implements Coffee {

	protected Coffee coffeeToBeDecorated;
	
	//create the coffee using the constructor
	public CoffeeDecorator(Coffee cofeeToBeDecorated) {
		this.coffeeToBeDecorated = cofeeToBeDecorated;
	}
	
	@Override
	public String makeCoffee() {
		return null;
	}

	@Override
	public int getPrice() {
		return 0;
	}

}
