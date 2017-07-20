package com.ca.tdm.card.jobs;

import java.util.ArrayList;
import java.util.List;

import com.ca.tdm.card.beans.Card;
import com.ca.tdm.card.beans.Game;

/**
 * 
 * @author kumaj04
 * This is the manager class which add, update and delete the games
 */
public class GameManager {
	
	Transaction trans = new Transaction();
	CardInfo cardd = new CardInfo();
	public void AddGame(Game game) {
		
	}
	
	public void deleteGame(Game game) {
		
	}
	
	public void startGame(Game game, Card card) {
		//Before initializing the card, validate the card first
		cardd.validateCard(card.getCardNo());
		
		// on success start initialising the game
		trans.initialiseGame(card.getCardNo(), game.getGameName());
		
		//deduct the amount
		trans.deductAmount(card.getCardNo(), game.getGameName());
		
		//stop the game
		trans.terminateGame(card.getCardNo(), game.getGameName());
	}
	
	public List<String> getGamesList() {
		return trans.getAllGames();
	}
}
