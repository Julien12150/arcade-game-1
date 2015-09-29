package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.*;

public class Coin extends GameObject {
	
	Handler handler;
	
	public Coin(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
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
