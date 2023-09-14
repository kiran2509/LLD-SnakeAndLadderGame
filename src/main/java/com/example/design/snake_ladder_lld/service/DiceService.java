package com.example.design.snake_ladder_lld.service;

import java.util.Random;

public class DiceService {

	public static int roll() {
		
		return new Random().nextInt(6)+1;
	}
}
