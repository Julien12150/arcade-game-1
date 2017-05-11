package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;

public class Coin extends GameObject {
	
	// Constructors
	public Coin(float x, float y)
	{
		super(x, y, 0, 0, 0, ID.Coin, Color.yellow, 16, 16);
	}
	
	public Coin(float x, float y, float velX, float velY)
	{
		super(x, y, velX, velY, Math.max(velX,  velY), ID.Coin, Color.yellow, 16, 16);
	}
}
