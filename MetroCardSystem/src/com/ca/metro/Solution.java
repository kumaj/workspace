package com.ca.metro;
/**
 * This is the main entry class to start the operation
 * @author kumaj04
 * Use cases :
 * 1. User will ask for a metro card no
 */
public class Solution {

	public static void main(String[] args) {
		//create the card
		Card card = new Card();
		Recharge rech = new Recharge();
		System.out.println("Card succefully created. ID : " + card.createNewCard("aaaa", "Varanasi"));
		//create 2nd card
		System.out.println("Card succefully created. ID : " + card.createNewCard("bbbb", "Patna"));
		// create 3rd card
		System.out.println("Card succefully created. ID : " + card.createNewCard("cccc", "Kashi"));
		
		//Print total no of cardds
		System.out.println("Total card count : " + card.getTotalCardCount());
		
		// Once the user will get the card he will recharge it first
		System.out.println("Currennt Balance : " + rech.getAccountBalance(1));
		System.out.println("Recharge with Rs.100 : " + rech.rechargeCard(1, 100));
		System.out.println("After Recharge : " + rech.getAccountBalance(1));
		
		
		
	}
}
