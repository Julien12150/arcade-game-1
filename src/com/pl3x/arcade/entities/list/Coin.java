package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.*;

public class Coin extends GameObject {
	
	int time = 5;
	Handler handler;
	
	public Coin(int x, int y, ID id, Handler handler, int velX, int velY) {
		super(x, y, id);
		this.handler = handler;
		this.velX = velX;
		this.velY = velY;
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
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){ 
				if(getBounds().intersects(tempObject.getBounds())){ //when the coin collide with the player
					handler.removeObject(this);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
