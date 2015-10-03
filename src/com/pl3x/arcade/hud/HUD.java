package com.pl3x.arcade.hud;

import java.awt.*;

import com.pl3x.arcade.entities.list.Player;
import com.pl3x.arcade.main.*;

public class HUD {
	private boolean isInfoShowed = false;
	private Player playerLeft = null;
	private Player playerRight = null;
	
	public HUD()
	{
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, Main.HEIGHT, Main.WIDTH, Main.HUD_HEIGHT);
		
		if (this.playerLeft != null)
		{
			int health = this.playerLeft.getHealth();
			
			// Life bar
			g.setColor(Color.red);
			g.fillRect(4, Main.HEIGHT + 4, this.playerLeft.getMaxHealth() * 2, Main.HUD_HEIGHT - 8);
			g.setColor(Color.green);
			g.fillRect(4, Main.HEIGHT + 4, health * 2, Main.HUD_HEIGHT - 8);
			g.setColor(health > 50 ? Color.black : Color.white);
			g.drawString("" + health, 99, Main.HEIGHT + (Main.HUD_HEIGHT / 2) + 4);
			
			// Coins
			g.setColor(Color.yellow);
			g.fillRect(208, Main.HEIGHT + Main.HUD_HEIGHT - 20, 16, 16);
			g.setColor(Color.black);
			g.drawString("" + this.playerLeft.getCoins(), 4 + (208), Main.HEIGHT + Main.HUD_HEIGHT - 8);
		}

		if(this.getIsInfoShowed())
		{
			Info.render(g, this.getPlayerLeft(), this.getPlayerRight());
		}
	}
	
	// Getters
	public boolean getIsInfoShowed()
	{
		return this.isInfoShowed;
	}
	
	public Player getPlayerLeft()
	{
		return this.playerLeft;
	}
	
	public Player getPlayerRight()
	{
		return this.playerRight;
	}
	
	// Setters
	public void setIsInfoShowed(boolean isInfoShowed)
	{
		this.isInfoShowed = isInfoShowed;
	}
	
	public void setPlayerLeft(Player player)
	{
		this.playerLeft = player;
	}
	
	/*
	public void render2(Graphics g, Handler handler){
		render(g, handler);
		g.setColor(Color.red);
		g.fillRect(Main2Player.WIDTH - 200 - 10, (Main2Player.HEIGHT - (Main2Player.HUD_HEIGHT / 2) - 3) + 4, 100 * 2, Main2Player.HUD_HEIGHT - 8);
		g.setColor(Color.green);
		g.fillRect(Main2Player.WIDTH - HEALTH2 * 2 - 10, (Main2Player.HEIGHT - (Main2Player.HUD_HEIGHT / 2) - 3) + 4, HEALTH2 * 2, Main2Player.HUD_HEIGHT - 8);
		if(HEALTH2 > 50)g.setColor(Color.black);
		if(HEALTH2 < 50)g.setColor(Color.white);
		g.drawString("" + HEALTH2, (Main2Player.WIDTH - 200 - 4) + (200) / 2 - 5, 500);
		g.setColor(Color.yellow);
		g.fillRect(Main2Player.WIDTH - 200 - 30, Main2Player.HEIGHT - (Main2Player.HUD_HEIGHT / 2) + 4, 16, 16);
		g.setColor(Color.black);
		g.drawString("" + COIN2, Main2Player.WIDTH - 200 - 25, 510);
	}
	*/
	
}
