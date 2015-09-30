package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.util.Random;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.hud.HUD;
import com.pl3x.arcade.main.Handler;
import com.pl3x.arcade.main.Main;

public class Player2 extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player2(int x, int y, ID id, Handler handler) {
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
		
		if(HUD.HEALTH2 <= 0){
			handler.addObject(new PlayerPart(x, y, -5, -5, ID.Decoration, 2));
			handler.addObject(new PlayerPart(x + 16, y, 5, -5, ID.Decoration, 2));
			handler.addObject(new PlayerPart(x + 16, y + 16, 5, 5, ID.Decoration, 2));
			handler.addObject(new PlayerPart(x, y + 16, -5, 5, ID.Decoration, 2));
			handler.removeObject(this);
		}
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the player collide with the enemy
					HUD.HEALTH2 -= 3; //the player lose health
				}
			}
			if(tempObject.getId() == ID.Coin){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the player collide with a coin
					HUD.COIN2++; //the player get a coin
					HUD.HEALTH2 += 5;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.green);  //the color is white
		g.fillRect(x, y, 32, 32); //the size is 32x32 and appear in x and y
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
