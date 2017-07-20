package com.ca.tdm.card.jobs;

public class BikeRace extends Games{

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
	
	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopGame() {
		// TODO Auto-generated method stub
		
	}

}
