package com.pl3x.arcade.hud;

import java.awt.*;

import com.pl3x.arcade.entities.list.Player;
import com.pl3x.arcade.main.*;

public class Info {
	public static int fps;
	
	public static void render(Graphics g, Player playerLeft, Player playerRight)
	{
		int y = 12;
		g.setColor(Color.white);
		g.drawString("E: " + Main.handler.object.size(), 0, y);
		g.drawString("fps: " + fps, 0, y + 12);

		if (playerLeft == null)
		{
			g.drawString("No player left", 0, y + 24);
			y = y + 36;
		}
		else
		{
			g.drawString("Player left COINS: " + playerLeft.getCoins(), 0, y + 24);
			g.drawString("Player left HEALTH: " + playerLeft.getHealth(), 0, y + 36);
			g.drawString("LC: " + playerLeft.getX() + " " + playerLeft.getY() + " | " + playerLeft.getVelX() + " " + playerLeft.getVelY(), 0, y + 48);
			y = y + 60;
		}

		if (playerRight == null)
		{
			g.drawString("No player right", 0, y);
		}
		else {
			g.drawString("Player right COINS: " + playerLeft.getCoins(), 0, y);
			g.drawString("Player right HEALTH: " + playerLeft.getHealth(), 0, y + 12);
			g.drawString("RC: " + playerLeft.getX() + " " + playerLeft.getY() + " | " + playerLeft.getVelX() + " " + playerLeft.getVelY(), 0, y + 24);
		}
	}
}
