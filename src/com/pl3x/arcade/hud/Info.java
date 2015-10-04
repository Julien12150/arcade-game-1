package com.pl3x.arcade.hud;

import java.awt.*;
import com.pl3x.arcade.main.*;

public class Info {
	public static int fps;
	
	public static void render(Graphics g)
	{
		int y = 12;
		g.setColor(Color.white);
		g.drawString("E: " + Main.handler.object.size(), 0, y);
		g.drawString("fps: " + fps, 0, y + 12);

		if (Main.player1 == null)
		{
			g.drawString("No player 1", 0, y + 24);
			y = y + 36;
		}
		else
		{
			g.drawString("Player 1 COINS: " + Main.player1.getCoins(), 0, y + 24);
			g.drawString("Player 1 HEALTH: " + Main.player1.getHealth(), 0, y + 36);
			g.drawString("1C: " + Main.player1.getX() + " " + Main.player1.getY() + " | " + Main.player1.getVelX() + " " + Main.player1.getVelY(), 0, y + 48);
			y = y + 60;
		}

		if (Main.player2 == null)
		{
			g.drawString("No player 2", 0, y);
		}
		else {
			g.drawString("Player 2 COINS: " + Main.player2.getCoins(), 0, y);
			g.drawString("Player 2 HEALTH: " + Main.player2.getHealth(), 0, y + 12);
			g.drawString("2C: " + Main.player2.getX() + " " + Main.player2.getY() + " | " + Main.player2.getVelX() + " " + Main.player2.getVelY(), 0, y + 24);
		}
	}
}
