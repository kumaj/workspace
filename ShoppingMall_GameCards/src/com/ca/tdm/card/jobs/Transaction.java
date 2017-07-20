package com.ca.tdm.card.jobs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kumaj04
 * This class is responsible to check the existing balance,
 * recharge the card
 * get the cost of the game,
 * deduct the amount and update the DB
 * start the game
 * Finally stop the game.
 */
public class Transaction {

	Games game = null;
	public void initialiseGame(int cardNumeber, String gameName) {
		//Based upon type of the game it will start the game
		if(gameName.equals("BikeRace")) {
			game = new BikeRace();
			game.startGame();
		} else if(gameName.equals("CarRace")) {
			game = new CarRace();
			game.startGame();
		} else if(gameName.equals("NeedForSpeed")) {
			game = new NeedForSpeed();
			game.startGame();
		} else {
			System.out.println("Invalid game selected..");
		}
	}
	
	public void terminateGame(int cardNumeber, String gameName) {
		//Based upon type of the game it will start the game
		if(gameName.equals("BikeRace")) {
			game = new BikeRace();
			game.stopGame();
		} else if(gameName.equals("CarRace")) {
			game = new CarRace();
			game.stopGame();
		} else if(gameName.equals("NeedForSpeed")) {
			game = new NeedForSpeed();
			game.stopGame();
		} else {
			System.out.println("Invalid game selected..");
		}
	}
	
	public void deductAmount(int cardNumber, String gameName) {
		// It will internally get the cost of the specific game and 
		// deduct the cost from its account.
		int cost = 0;
		int balance = 0;
		if(gameName.equals("BikeRace")) {
			game = new BikeRace();
			cost = game.getGameCost();
			balance = getBalance(cardNumber);
			updateBalance(cardNumber, balance - cost);	
		} else if(gameName.equals("CarRace")) {
			game = new CarRace();
			cost = game.getGameCost();
			balance = getBalance(cardNumber);
			updateBalance(cardNumber, balance - cost);
		} else if(gameName.equals("NeedForSpeed")) {
			game = new NeedForSpeed();
			cost = game.getGameCost();
			balance = getBalance(cardNumber);
			updateBalance(cardNumber, balance - cost);
		} else {
			System.out.println("Invalid game selected..");
		}
	}
	
	
	/**
	 * Update the final amount
	 * @param finalAmount
	 */
	public void updateBalance(int cardNumber, int finalAmount) {
		//call the JPA layer to update the amount
	}
	
	/**
	 * 
	 * @param cardNumber
	 */
	public int getBalance(int cardNumber) {
		// Fire the JPA to get the current balance for the card num
		return 100;
	}

	public List<String> getAllGames() {
		List<String> gamesList = new ArrayList<String>();
		return gamesList;
	}
	
}
