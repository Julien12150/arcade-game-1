package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.*;

public class Enemy extends GameObject {
	
	Handler handler;
	
	public Enemy(int x, int y, ID id, int velX, int velY, Handler handler) {
		super(x, y, id);
		
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Main.HEIGHT - 47) velY *= -1;
		if(x <= 0 || x >= Main.WIDTH - 22) velX *= -1;
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the enemy collide with another enemy
					velX *= -1;
					velY *= -1;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
