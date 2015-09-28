package com.pl3x.arcade.entities.list;

import java.awt.*;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.*;

public class Enemy extends GameObject {

	public Enemy(int x, int y, ID id, int velX, int velY) {
		super(x, y, id);
		
		this.velX = velX;
		this.velY = velY;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Main.HEIGHT - 47) velY *= -1;
		if(x <= 0 || x >= Main.WIDTH - 22) velX *= -1;
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
