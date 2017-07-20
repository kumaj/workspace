package com.ca.tdm.card.jobs;

/**
 * 
 * @author kumaj04
 * The player will recharge his card and start playing the games.
 */
public class Player {
	
	static CardInfo cardInfo = new CardInfo();
	static GameManager mgr = new GameManager();
	// Player will contains cards
	public static void main(String[] args) {
		
		int cardNumber = 1234435454;
		int amount = 100;
		System.out.println("Enter the card number");
		System.out.println("Enter the amount to be recharge");
		cardInfo.rechargeCard(cardNumber, amount);
		
		// Once the recharge is successful, the player will start the game
		mgr.getGamesList();
		
		mgr.startGame("BikeRace", cardNumber);
	}
}
