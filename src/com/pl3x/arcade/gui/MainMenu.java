package com.pl3x.arcade.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pl3x.arcade.Main;
import com.pl3x.arcade.Main.STATE;

public class MainMenu {
	
	private int titleSize = 50;
	
	public int select;
	
	public STATE State;
	
	public MainMenu(){
		select = 0;
	}
	
	public void render(Graphics g){
	String[] button;
	button = new String[3];
	
	button[0] = "Singleplayer";
	button[1] = "Multiplayer";
	button[2] = "Quit";
	
	
		Font fnt0 = new Font("arial", Font.BOLD, titleSize);
		Font fnt1 = new Font("arial", Font.PLAIN, 20);
		
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("an arcade game without name", (Main.WIDTH / 2) - (titleSize * 7), 100);
		
		g.setFont(fnt1);
		if(select == 2) g.setColor(Color.green);
		else 			g.setColor(Color.white);
		g.drawString(button[2], 20, Main.HEIGHT + 40);
		if(select == 1) g.setColor(Color.green);
		else 			g.setColor(Color.white);
		g.drawString(button[1], 20, Main.HEIGHT + 20);
		if(select == 0) g.setColor(Color.green);
		else 			g.setColor(Color.white);
		g.drawString(button[0], 20, Main.HEIGHT);
	}
	
}
