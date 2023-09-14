package com.example.design.snake_ladder_lld.model;


public class Player {

	private int playerId;
	private String playerName;
	private int playerPos;
	
	public Player() {
		//code;
	}
	
	public Player(int playerId, String playerName, int playerPos) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerPos = playerPos;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(int playerPos) {
		this.playerPos = playerPos;
	}
	
}
