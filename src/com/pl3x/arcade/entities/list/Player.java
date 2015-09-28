package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.util.Random;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.Main;

public class Player extends GameObject{

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x < 0)x = 0; //if the player's position is less than 0, it's will go to 0
		
		if(x > (Main.WIDTH - 38))x = Main.WIDTH - 38; //same thing...
		
		if(y < 0)y = 0;
		
		if(y > (Main.HEIGHT - 60))y = Main.HEIGHT - 60;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);  //the color is white
		g.fillRect(x, y, 32, 32); //the size is 32x32 and appear in x and y
	}

}
