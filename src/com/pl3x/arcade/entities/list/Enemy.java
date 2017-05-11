package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;

public class Enemy extends GameObject {
	
	// Constructor
	public Enemy(float x, float y, float velX, float velY)
	{
		super(x, y, velX, velY, 1f, ID.Enemy, Color.red, 16, 16);
	}
}
