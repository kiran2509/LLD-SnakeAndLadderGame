package com.example.design.snake_ladder_lld.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	
	private int dimension;
	
	private List<Player> players;
	
	private List<Snake> snakes;
	
	private List<Ladder> ladders;
	
	
	public Board() {
		
	}
	
	public Board(int dimension) {
	
		this.dimension = dimension;
		this.players = new ArrayList<>();
		this.snakes = new ArrayList<>();
		this.ladders = new ArrayList<>();
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}
		
}
