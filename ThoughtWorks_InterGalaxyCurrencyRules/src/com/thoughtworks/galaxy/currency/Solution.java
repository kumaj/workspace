package com.thoughtworks.galaxy.currency;

import java.io.InputStream;
import java.util.Scanner;

import com.thoughtworks.galaxy.exception.BadRequestException;

public class Solution {

	public static void main(String[] args) {
		RomanToInt romantoInt = new RomanToInt();
		//System.out.println(romantoInt.convertRomanToInt("MI"));
		InterGalaxyCurrency curr = new InterGalaxyCurrency();
		//Scan the user input and map the other galaxy string8 to roman
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String userInput = sc.nextLine();
			try {
				curr.parseUserInput(userInput);
			} catch (BadRequestException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//Scan the user input and get the value of the currency 
	}
}
