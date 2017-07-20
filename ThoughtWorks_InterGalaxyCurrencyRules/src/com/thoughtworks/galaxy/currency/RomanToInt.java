package com.thoughtworks.galaxy.currency;

import java.util.HashMap;

public class RomanToInt {
	//Take a hash Map which store the roman as key and its int as its value
	HashMap<Character, Integer> romanToIntMap = null;
	
	public RomanToInt() {
		romanToIntMap = new HashMap<Character, Integer>();
		romanToIntMap.put('I', 1);
		romanToIntMap.put('V', 5);
		romanToIntMap.put('X', 10);
		romanToIntMap.put('L', 50);
		romanToIntMap.put('C', 100);
		romanToIntMap.put('D', 500);
		romanToIntMap.put('M', 1000);
	}
	
	/**
	 * Convert the roman string into integer value
	 * @param romanStr
	 * @return Integer value
	 */
	public Integer convertRomanToInt(String romanStr) {
		if(romanStr == null || romanStr.length() == 0)
			return 0;
		int romanlength = romanStr.length();
		Integer prev = romanToIntMap.get(romanStr.charAt(romanlength - 1));
		Integer curr = prev;
		Integer resultantValue = prev;
		int index = romanlength - 2;
		while(index >= 0 ) {
			curr = romanToIntMap.get(romanStr.charAt(index));
			if(curr < prev) {
				resultantValue = resultantValue - curr;
			} else {
				resultantValue = resultantValue + curr;
			}
			index--;
		}
		return resultantValue;
	}
	
	public HashMap<Character, Integer> getRomanToIntConversion() {
		return romanToIntMap;
	}
}
