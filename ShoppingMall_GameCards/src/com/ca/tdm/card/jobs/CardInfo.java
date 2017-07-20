package com.ca.tdm.card.jobs;

import com.ca.tdm.card.beans.Card;

public class CardInfo {
	
	Transaction trans = new Transaction();
	/**
	 * Method to validate the card
	 * @param cardNumber
	 */
	public boolean validateCard(int cardNumber) {
		
		// How the card will be validated
		// 1. It should belong to specific mall
		// 2. Check expiry date 
		return true;
	}
	
	/**
	 * Get the details of a specific card card 
	 * @param cardNumber
	 * @return
	 */
	public Card getCardInfo(int cardNumber) {
		Card cardDetails = new Card();
		
		
		return cardDetails;
	}
	
	/**
	 * Get the existing balance corresponding to the card
	 * @param cardNumber
	 * @return
	 */
	public int getCardBalance(int cardNumber) {
		// Fire the JPA to get the balance
		return trans.getBalance(cardNumber);
	}
	
	/**
	 * Method to recharge the card
	 * @param cardNumber
	 * @param amount
	 */
	public void rechargeCard(int cardNumber, int amount) {
		//fire the JPA class to update the existing balance of the card
		trans.updateBalance(cardNumber, amount);
	}
	
	
}
