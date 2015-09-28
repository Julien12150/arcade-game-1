package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.util.Random;

import com.pl3x.arcade.entities.*;

public class Player extends GameObject{

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);  //the color is white
		g.fillRect(x, y, 32, 32); //the size is 32x32 and appear in x and y
	}

}
