package com.thoughtworks.galaxy.currency;

import java.util.HashMap;

import com.thoughtworks.galaxy.exception.BadRequestException;

/**
 * This class will parse the user string and get the 
 * other galaxy currency name and its value
 * @author kumaj04
 *
 */
public class InterGalaxyCurrency {
	HashMap<String, Character> interGalaxyRomanMap = null;
	HashMap<String, Double> interGalaxyCurrMap = null;
	RomanToInt romantoInt = new RomanToInt();
	public InterGalaxyCurrency() {
		interGalaxyRomanMap = new HashMap<String, Character>();
		interGalaxyCurrMap = new HashMap<String, Double>();
	}
	
	public void parseUserInput(String userInput) throws BadRequestException {
		String[] splittedUserInput = userInput.split(" ");
		Double result = 1D;
		if(splittedUserInput.length == 0)
			throw new BadRequestException("I have no idea what you are talking about");
		
		if(userInput.contains("how many") || userInput.contains("how much")) {
			String[] strToBeComputed = userInput.split("is");
			if(strToBeComputed.length > 2)
				throw new BadRequestException("Roman input provided is wrong");
			//get the 2nd half of the string based on "is"
			String amtToBeComputed = strToBeComputed[1];
			//Split the str based on " " and get the romans and currency amt
			String[] romanAndCurrStr = amtToBeComputed.split(" ");
			// Iterate over the roman and curr and get its value
			StringBuilder romanGalaxyStr = new StringBuilder();
			
			for (String userStr : romanAndCurrStr) {
				if(interGalaxyRomanMap.containsKey(userStr)) {
					romanGalaxyStr.append(interGalaxyRomanMap.get(userStr));
				} else if(interGalaxyCurrMap.containsKey(userStr)) {
					//Get the integer value corresponding to the roman str
					if(romanGalaxyStr != null || romanGalaxyStr.length() > 0) {
						Integer romanValue = romantoInt.convertRomanToInt(romanGalaxyStr.toString());
						result = romanValue.doubleValue();
					}
					Double currValue = interGalaxyCurrMap.get(userStr);
					result = result*currValue;
					romanGalaxyStr = new StringBuilder();
					System.out.println("Result is " + result);
				} else
					throw new BadRequestException("I have no idea what you are talking about");
			}
		} else {
			//Split the String based upon the spaces
			if(userInput.contains("credits")) {
				StringBuilder romanStr = new StringBuilder();
				String[] splittedCurrencyInput = userInput.split("is");
				for (String userStr : splittedUserInput) {
					if(interGalaxyRomanMap.containsKey(userStr)) {
						romanStr.append(interGalaxyRomanMap.get(userStr));
					} else {
						//Parse the roman String and get it's equivalent integer value
						if(userStr.contains("is")) 
							continue;
						else {
							Integer romanValue = romantoInt.convertRomanToInt(romanStr.toString());
							if(splittedCurrencyInput.length > 2)
								throw new BadRequestException("Bad Input");
							String splittedCurr = splittedCurrencyInput[1];
							String[] amt = splittedCurr.split(" ");
							int creditAmt = Integer.parseInt(amt[0]);
							Double currValue = (double) (creditAmt/romanValue);	
							interGalaxyCurrMap.put(userStr, currValue);
						}
					}
				}
			} else {
				char[] rmnStr = splittedUserInput[2].toCharArray();
				if(rmnStr.length == 1)
					interGalaxyRomanMap.put(splittedUserInput[0],  rmnStr[0]);
				else
					throw new BadRequestException("Roman input provided is wrong");
			}
		}
	}
	
	
}
