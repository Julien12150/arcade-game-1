package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.util.Random;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.hud.HUD;
import com.pl3x.arcade.main.Handler;
import com.pl3x.arcade.main.Main;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x < 0)x = 0; //if the player's position is less than 0, it's will go to 0
		
		if(x > (Main.WIDTH - 38))x = Main.WIDTH - 38; //same thing...
		
		if(y < 0)y = 0;
		
		if(y > (Main.HEIGHT - 60))y = Main.HEIGHT - 60;
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy){ //when the player colide with the enemy 
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1; //the player lose health
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);  //the color is white
		g.fillRect(x, y, 32, 32); //the size is 32x32 and appear in x and y
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
