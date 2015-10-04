package com.pl3x.arcade.entities;

import com.pl3x.arcade.Main;
import com.pl3x.arcade.entities.list.Coin;

public class Spawn {

	private long coinDuration = 2000000000;	// 1 coin every 2 seconds
	private long deltaCoin;
	
	public Spawn()
	{
		this.deltaCoin = 0;
	}
	
	public void tick(long deltaNano){
		
		// Spawn coin.
		this.deltaCoin += deltaNano;
		if (this.deltaCoin > this.coinDuration)
		{
			this.deltaCoin -= this.coinDuration;
			new Coin(Main.random.nextFloat(), Main.random.nextFloat());
		}
	}	
}