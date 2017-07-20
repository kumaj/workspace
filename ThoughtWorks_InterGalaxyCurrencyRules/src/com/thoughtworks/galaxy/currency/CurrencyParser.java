package com.thoughtworks.galaxy.currency;

public interface CurrencyParser {
	public void parseCurrency(String userInput);
	public void buildCurrencyStorage();
}
