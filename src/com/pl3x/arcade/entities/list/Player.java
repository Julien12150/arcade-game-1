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
	public static int Direction;
	
	@SuppressWarnings("static-access")
	public Player(int x, int y, ID id, Handler handler, int Direction) {
		super(x, y, id);
		this.handler = handler;
		this.Direction = Direction;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x < 0)x = 0; //if the player's position is less than 0, it's will go to 0
		
		if(x > (Main.WIDTH - 38))x = Main.WIDTH - 38; //same thing...
		
		if(y < 0)y = 0;
		
		if(y > (Main.HEIGHT - 60))y = Main.HEIGHT - 60;
		
		collision();
		
		if(HUD.HEALTH <= 0){
			int coin = HUD.COIN;
			
			System.out.println("Player one died with " + coin + " coins.");
			
			for(int i=0; i < coin; i++){
				handler.addObject(new Coin(x + 8, y + 8, ID.CoinNoHealth, handler, r.nextInt(10) - 5 + this.velX, r.nextInt(10) - 5 + this.velY));
			}
			
			handler.addObject(new PlayerPart(x, y, -5 + this.velX, -5 + this.velY, ID.Decoration, 1));
			handler.addObject(new PlayerPart(x + 16, y, 5 + this.velX, -5 + this.velY, ID.Decoration, 1));
			handler.addObject(new PlayerPart(x + 16, y + 16, 5 + this.velX, 5 + this.velY, ID.Decoration, 1));
			handler.addObject(new PlayerPart(x, y + 16, -5 + this.velX, 5 + this.velY, ID.Decoration, 1));
			
			handler.removeObject(this);
		}
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the player collide with the enemy
					HUD.HEALTH -= 3; //the player lose health
				}
			}
			if(tempObject.getId() == ID.Coin){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the player collide with a coin
					HUD.COIN++; //the player get a coin
					HUD.HEALTH += 5;
				}
			}
			if(tempObject.getId() == ID.CoinNoHealth){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the player collide with a coin
					HUD.COIN++; //the player get a coin
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);  //the color is white
		g.fillRect(x, y, 32, 32); //the size is 32x32 and appear in x and y
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
