package com.example.design.snake_ladder_lld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.design.snake_ladder_lld.model.Board;
import com.example.design.snake_ladder_lld.model.Ladder;
import com.example.design.snake_ladder_lld.model.Player;
import com.example.design.snake_ladder_lld.model.Snake;
import com.example.design.snake_ladder_lld.service.GameService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Scanner st = new Scanner(System.in);
    	
    	System.out.println("Number of players : ");
    	int playerCount = st.nextInt();
    	
    	
    	List<Player> players = new ArrayList();
    	for(int i=0;i<playerCount;i++) {
    		
    		System.out.println("Details for Player: "+ (i+1));
    		int id = st.nextInt();
    		st.nextLine();
    		String name = st.nextLine();
    		
    		players.add(new Player(id, name, 0));
    	}
    	
    	List<Snake> snakes = new ArrayList<>();
    	List<Ladder> ladders = new ArrayList<>();
    	
    	Snake snake1 = new Snake(12, 28);
    	Snake snake2 = new Snake(34, 78);
    	Snake snake3 = new Snake(6, 69);
    	Snake snake4 = new Snake(65, 84);
    	
    	Ladder ladder1 = new Ladder(24, 56);
    	Ladder ladder2 = new Ladder(43, 83);
    	Ladder ladder3 = new Ladder(3, 31);
    	Ladder ladder4 = new Ladder(72, 91);    
    	
    	snakes.addAll(Arrays.asList(snake1, snake2, snake3, snake4));
    	ladders.addAll(Arrays.asList(ladder1,ladder2, ladder3, ladder4));
    	
    	
    	
    	GameService service = new GameService();
    	service.getSnakeAndLadderBoard().setLadders(ladders);
    	service.getSnakeAndLadderBoard().setPlayers(players);
    	service.getSnakeAndLadderBoard().setSnakes(snakes);
    	
    	service.startGame();
    }
}
