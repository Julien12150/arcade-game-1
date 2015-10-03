package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.pl3x.arcade.entities.*;

public class Player extends GameObject{

	private int max_health;	// Max life points
	private int health;		// Life points
	private int coins;		// Count of coins earned
	
	// Constructor
	public Player(float x, float y) {
		super(x, y, 0, 0, 0.5f, ID.Player, Color.white, 32, 32);
		
		this.setMaxHealth(100);
		this.setHealth(this.getMaxHealth());
		this.setCoins(0);
	}
	
	// key: move player
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch(key)
		{
		case KeyEvent.VK_W:
		case KeyEvent.VK_Z:
			// Go up
			this.setVelY( this.getVelY() - (this.getVelMax() / 10));
			break;
			
		case KeyEvent.VK_S:
			// Go down
			this.setVelY( this.getVelY() + (this.getVelMax() / 10));
			break;
			
		case KeyEvent.VK_D:
			// Go right
			this.setVelX( this.getVelX() + (this.getVelMax() / 10));
			break;
			
		case KeyEvent.VK_A:
		case KeyEvent.VK_Q:
			// Go left
			this.setVelX( this.getVelX() - (this.getVelMax() / 10));
			break;
		}
	}
	
	// Collision with GameObjects
	public void collision(ArrayList<GameObject> hits)
	{
		for (int i = 0 ; i < hits.size() ; i++)
		{
			GameObject object = hits.get(i);
			
			switch(object.getId())
			{
			case Enemy:
				this.setHealth(this.getHealth() - 3);
				object.setVelX(-object.getVelX());
				object.setVelY(-object.getVelY());
				break;
				
			case Coin:
				this.setHealth(this.getHealth() + 5);
				this.setCoins(this.getCoins() + 1);
				object.die();
				break;
				
			case CoinNoHealth:
				this.setCoins(this.getCoins() + 1);
				object.die();
				break;

			default:		
			}
		}
	}
	
	// Make the player die
	public void die()
	{	
		System.out.println("Player one died with " + this.getCoins() + " coins.");
		
		for(int i=0 ; i < this.getCoins() ; i++){
			// handler.addObject(new Coin(x + 8, y + 8, ID.CoinNoHealth, handler, r.nextInt(10) - 5 + this.velX, r.nextInt(10) - 5 + this.velY));
		}
		
		/*
		handler.addObject(new PlayerPart(x, y, -5 + this.velX, -5 + this.velY, ID.Decoration, 1));
		handler.addObject(new PlayerPart(x + 16, y, 5 + this.velX, -5 + this.velY, ID.Decoration, 1));
		handler.addObject(new PlayerPart(x + 16, y + 16, 5 + this.velX, 5 + this.velY, ID.Decoration, 1));
		handler.addObject(new PlayerPart(x, y + 16, -5 + this.velX, 5 + this.velY, ID.Decoration, 1));
		*/
		super.die();
	}
	
	// Getter
	public int getMaxHealth()
	{
		return this.max_health;
	}
	
	public int getHealth()
	{
		return this.health;
	}
	
	public int getCoins()
	{
		return this.coins;
	}

	
	// Setter
	public void setMaxHealth(int max_health)
	{
		this.max_health = max_health;
		
		if (this.health > max_health)
			this.setHealth(max_health);
	}
	
	public void setHealth(int health)
	{
		if (health < 0)
			health = 0;
		else if (health > this.getMaxHealth())
			health = this.getMaxHealth();
		
		this.health = health;
		
		if (this.health <= 0)
			this.die();
	}
	
	public void setCoins(int coins)
	{
		if (coins < 0)
			coins = 0;
		
		this.coins = coins;
	}
}
