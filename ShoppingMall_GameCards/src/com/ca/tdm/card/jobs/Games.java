package com.ca.tdm.card.jobs;
/**
 * 
 * @author kumaj04
 * This class will initiate the game.
 * This is the base class which will be implemented by the specific game. 
 * This class is not responsible for deduction and verfying the account balance
 */
public abstract class Games {

	int gameID;
	int gameCost;
	String gameName;
	String duration;
	String type;
	int players_required;
	
	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getGameCost() {
		return gameCost;
	}

	public void setGameCost(int gameCost) {
		this.gameCost = gameCost;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPlayers_required() {
		return players_required;
	}

	public void setPlayers_required(int players_required) {
		this.players_required = players_required;
	}
	
	public abstract void startGame();
	
	public abstract void stopGame();
}
