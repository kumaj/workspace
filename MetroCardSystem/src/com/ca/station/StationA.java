package com.ca.station;

import java.util.HashMap;
import java.util.Map;

import com.ca.journey.PriceListing;
import com.ca.metro.Card;

public class StationA implements Station{

	private static final String code = "A";
	private static String name = "A";
	private static Integer totalPassenger;
	static Map<Integer, Card> passengerList = new HashMap<Integer, Card>();
	
	PriceListing price = new PriceListing();
	
	@Override
	public void enterStation(Integer cardNo) {
		System.out.println("Entered into station A");
		totalPassenger++;
	}

	public Integer getTotalPassenger() {
		return totalPassenger;
	}

	@Override
	public void exitStation(Integer cardNo) {
		System.out.println("Exited station B");
		//Now get the journey cost
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
