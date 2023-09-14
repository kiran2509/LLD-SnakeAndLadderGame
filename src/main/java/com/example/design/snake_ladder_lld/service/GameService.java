package com.example.design.snake_ladder_lld.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.design.snake_ladder_lld.GameStatus;
import com.example.design.snake_ladder_lld.model.Board;
import com.example.design.snake_ladder_lld.model.Ladder;
import com.example.design.snake_ladder_lld.model.Player;
import com.example.design.snake_ladder_lld.model.Snake;

public class GameService {

	
	private Queue<Player> playerQueue;
	private Board snakeAndLadderBoard;
	private int DEFAULTBOARDSIZE = 100;
	private int size;
	private GameStatus status;
	
	public GameService() {
		this.size = DEFAULTBOARDSIZE;
		status = GameStatus.NOT_STARTED;
		snakeAndLadderBoard = new Board();
	}
	
	
	public GameService(int size) {
		this.size = size;
	}

	public Board getSnakeAndLadderBoard() {
		return snakeAndLadderBoard;
	}


	public void setSnakeAndLadderBoard(Board snakeAndLadderBoard) {
		this.snakeAndLadderBoard = snakeAndLadderBoard;
	}


	public void startGame() {
		
		playerQueue = new LinkedList<>(snakeAndLadderBoard.getPlayers());
		
		System.out.println("-----------Game started------------");
		while(!status.equals(GameStatus.FINISHED)) {
			
			int diceNum = getCurrentRollValue();
			Player player = playerQueue.poll();
			movePosition(player, diceNum);
			printBoard();
			
			if(isPlayerWon(player)) {
				status = GameStatus.FINISHED;
				System.out.println("Player Won the game : "+player.getPlayerId()+" "+player.getPlayerName());
			}
			else {
				playerQueue.add(player);
			}
		}
	}
	
	private void printBoard() {
		
		System.out.println("---------------------------------");
		for(Player player : snakeAndLadderBoard.getPlayers()) {
			System.out.println(player.getPlayerName()+" "+ player.getPlayerPos());
		}
		System.out.println("----------------------------------");
	}

	private boolean isPlayerWon(Player player) {
		return player.getPlayerPos() == size;
	}

	private void movePosition(Player player, int diceNum) {
		
		int curPosition = player.getPlayerPos();
		int nextPosition = curPosition + diceNum;
		
		nextPosition = nextPosition > this.size ? curPosition : getNextPositionBasedOnSnakeAndLadder(nextPosition);
		
		player.setPlayerPos(nextPosition);
	}

	private int getNextPositionBasedOnSnakeAndLadder(int nextPosition) {
		
		int newPosition;
		do {
			newPosition = nextPosition;
			for(Snake snake : this.snakeAndLadderBoard.getSnakes()) {
				if(snake.getStart() == nextPosition) {
					nextPosition = snake.getEnd();
				}
			}
			
			for(Ladder ladder : this.snakeAndLadderBoard.getLadders()) {
				
				if(ladder.getStart() == nextPosition) {
					nextPosition = ladder.getEnd();
				}
			}
		
		}while(newPosition != nextPosition);
		
		return newPosition;
	}

	private int getCurrentRollValue() {
		return DiceService.roll();
	}
}
