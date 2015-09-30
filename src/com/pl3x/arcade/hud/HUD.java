package com.pl3x.arcade.hud;

import java.awt.*;

import com.pl3x.arcade.main.*;

public class HUD {
	
	public static int HEALTH = 100;
	public static int HEALTH2 = 100;
	public static int COIN;
	public static int COIN2;
	
	public void tick(){
		//HEALTH--; //always drown the healt (DEBUG USE ONLY)
		//HEALTH2--; //always drown the healt (DEBUG USE ONLY)
		
		if(HEALTH > 100) HEALTH = 100; //when it's more than 100, it's will be 100
		if(HEALTH < 0) HEALTH = 0;     //when it's less than 0, it's will be 0
		
		if(HEALTH2 > 100) HEALTH2 = 100; //when it's more than 100, it's will be 100
		if(HEALTH2 < 0) HEALTH2 = 0;     //when it's less than 0, it's will be 0
		
		//if(HEALTH == 0) HEALTH = 100; //when it's goes to 0, it's make the health full (DEBUG USE ONLY)
		//if(HEALTH2 == 0) HEALTH2 = 100; //when it's goes to 0, it's make the health full (DEBUG USE ONLY)
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
		g.setColor(Color.yellow);
		g.fillRect(208, Main.HEIGHT - (Main.HUD / 2) + 4, 16, 16);
		g.setColor(Color.black);
		g.drawString("" + COIN, 4 + (208), 510);
	}
	
	public void render2(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, Main2Player.HEIGHT - (Main2Player.HUD / 2) - 3, Main2Player.WIDTH, Main2Player.HUD);
		
		g.setColor(Color.red);
		g.fillRect(4, (Main2Player.HEIGHT - (Main2Player.HUD / 2) - 3) + 4, 100 * 2, Main2Player.HUD - 8);
		g.setColor(Color.green);
		g.fillRect(4, (Main2Player.HEIGHT - (Main2Player.HUD / 2) - 3) + 4, HEALTH * 2, Main2Player.HUD - 8);
		if(HEALTH > 50)g.setColor(Color.black);
		if(HEALTH < 50)g.setColor(Color.white);
		g.drawString("" + HEALTH, 4 + (200) / 2 - 5, 500);
		g.setColor(Color.yellow);
		g.fillRect(208, Main2Player.HEIGHT - (Main2Player.HUD / 2) + 4, 16, 16);
		g.setColor(Color.black);
		g.drawString("" + COIN, 4 + (208), 510);
		
		g.setColor(Color.red);
		g.fillRect(Main2Player.WIDTH - 200 - 10, (Main2Player.HEIGHT - (Main2Player.HUD / 2) - 3) + 4, 100 * 2, Main2Player.HUD - 8);
		g.setColor(Color.green);
		g.fillRect(Main2Player.WIDTH - HEALTH2 * 2 - 10, (Main2Player.HEIGHT - (Main2Player.HUD / 2) - 3) + 4, HEALTH2 * 2, Main2Player.HUD - 8);
		if(HEALTH2 > 50)g.setColor(Color.black);
		if(HEALTH2 < 50)g.setColor(Color.white);
		g.drawString("" + HEALTH2, (Main2Player.WIDTH - 200 - 4) + (200) / 2 - 5, 500);
		g.setColor(Color.yellow);
		g.fillRect(Main2Player.WIDTH - 200 - 30, Main2Player.HEIGHT - (Main2Player.HUD / 2) + 4, 16, 16);
		g.setColor(Color.black);
		g.drawString("" + COIN2, Main2Player.WIDTH - 200 - 25, 510);
	}
	
}
