package com.pl3x.arcade.entities;

import java.awt.Color;

import com.pl3x.arcade.main.Main;


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
			new GameObject(Main.random.nextFloat(), Main.random.nextFloat(), 0, 0, 0, ID.Coin, Color.yellow, 16, 16);
		}
	}	
}
