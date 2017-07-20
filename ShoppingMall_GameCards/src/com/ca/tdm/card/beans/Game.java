package com.ca.tdm.card.beans;

/**
 * 
 * @author kumaj04
 * This class store the specific details about a game.
 */
public class Game {
	
	private String gameName;
	private String duration;
	private String type;
	private int players_required;
	
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
}
