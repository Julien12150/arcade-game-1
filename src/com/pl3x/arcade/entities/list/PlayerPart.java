package com.pl3x.arcade.entities.list;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pl3x.arcade.entities.GameObject;
import com.pl3x.arcade.entities.ID;
import com.pl3x.arcade.main.Main;

public class PlayerPart extends GameObject{
	
	int time = 5;
	int player;
	
	public PlayerPart(int x, int y, int velX, int velY, ID id, int player) {
		super(x, y, id);
		
		this.velX = velX;
		this.velY = velY;
		this.player = player;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Main.HEIGHT - 47) velY *= -1;
		if(x <= 0 || x >= Main.WIDTH - 22) velX *= -1;
		
		time--;
		
		if(time <= 0){
			time = 5;
			if(velX > 0){
				velX--;
			}else if(velX < 0){
				velX++;
			}
			if(velY > 0){
				velY--;
			}else if(velY < 0){
				velY++;
			}
		}
		
	}

	public void render(Graphics g) {
		if(player == 1){
			g.setColor(Color.white);
			g.fillRect(x, y, 16, 16);
		}else if(player == 2){ 
			g.setColor(Color.green);
			g.fillRect(x, y, 16, 16);
		}
	}

	public Rectangle getBounds() {
		return null;
	}

}
