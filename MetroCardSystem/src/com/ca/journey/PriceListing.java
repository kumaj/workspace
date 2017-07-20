package com.ca.journey;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is dedicated for the price listing of different station.
 * @author kumaj04
 *
 */
public class PriceListing {
 // So how will organize the price listing
	// Suppose the price between each station us equal. A--B --> 10 Rs.\
	private static int priceBetweenStation = 10;
	
	/**
	 * Return the cost of the journey
	 * @param sourceStation
	 * @param destStation
	 * @return
	 */
	public int getPrice(String sourceStation, String destStation) {
		
		// convert the source station and target int int
		char[] source = sourceStation.toCharArray();
		char s = source[0];
		int ss = s;
		
		char[] target = destStation.toCharArray();
		char t = target[0];
		int tt = t; 
		
		return priceBetweenStation*Math.abs(tt-ss);
		
	}
	
	/**
	 * Increment the price
	 * @param newPrice
	 */
	public void incrementPrice(Integer newPrice) {
		priceBetweenStation = newPrice;
	}
}
