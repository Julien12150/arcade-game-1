package com.pl3x.arcade.level;

import com.pl3x.arcade.Main;
import com.pl3x.arcade.entities.Spawn;
import com.pl3x.arcade.entities.list.*;

public class LevelClassic {
	
	public Spawn spawner;
	
	public LevelClassic(boolean twoPlayer){
		spawner = new Spawn();
		
		// Spawn 4 enemy and 4 coins
		for (int i=0 ; i < 4 ; i++)
		{
			new Enemy(Main.random.nextFloat(), Main.random.nextFloat(), Main.random.nextFloat() / 2, Main.random.nextFloat() / 2);
			new Coin(Main.random.nextFloat(), Main.random.nextFloat());
 		}
		
		if (twoPlayer)
		{
			Main.player1  = new Player1(1f / 3, 0.5f);
			Main.player2  = new Player2(2f / 3, 0.5f);
		}
		else
		{
			// Spawn player1 in the middle of the screen.
			Main.player1 = new Player1(0.5f, 0.5f);
			Main.player2 = null;
		}
	}
}
