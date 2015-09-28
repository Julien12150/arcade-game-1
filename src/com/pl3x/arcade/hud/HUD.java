package com.pl3x.arcade.hud;

import java.awt.*;

import com.pl3x.arcade.main.*;

public class HUD {
	
	public static int HEALTH = 100;
	
	public void tick(){
		//HEALTH--; //always drown the healt (DEBUG USE ONLY)
		
		if(HEALTH > 100) HEALTH = 100; //when it's more than 100, it's will be 100
		if(HEALTH < 0) HEALTH = 0;     //when it's less than 0, it's will be 0
		
		//if(HEALTH == 0) HEALTH = 100; //when it's goes to 0, it's make the health full (DEBUG USE ONLY)
	}
	
	public void render(Graphics g){ //some stuff for the hud
		g.setColor(Color.gray);
		g.fillRect(0, Main.HEIGHT - (Main.HUD / 2) - 3, Main.WIDTH, Main.HUD);
		g.setColor(Color.red);
		g.fillRect(4, (Main.HEIGHT - (Main.HUD / 2) - 3) + 4, 100 * 2, Main.HUD - 8);
		g.setColor(Color.green);
		g.fillRect(4, (Main.HEIGHT - (Main.HUD / 2) - 3) + 4, HEALTH * 2, Main.HUD - 8);
		if(HEALTH > 50)g.setColor(Color.black);
		if(HEALTH < 50)g.setColor(Color.white);
		g.drawString("" + HEALTH, 4 + (200) / 2 - 5, 500);
	}
	
}
