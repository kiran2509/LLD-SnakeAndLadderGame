package com.example.design.snake_ladder_lld.model;

public class Ladder {

	private int start;
	private int end;
	
	Ladder(){
		
	}
	
	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
