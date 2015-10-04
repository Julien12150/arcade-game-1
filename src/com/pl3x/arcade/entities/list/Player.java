package com.pl3x.arcade.entities.list;

import java.awt.*;
import java.util.ArrayList;

import com.pl3x.arcade.Main;
import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.Sound;

public abstract class Player extends GameObject{

	private int max_health;	// Max life points
	private int health;		// Life points
	private int coins;		// Count of coins earned
	
	// Constructor
	public Player(float x, float y, ID id) {
		super(x, y, 0, 0, 0.5f, id, Color.white, 32, 32);
		
		this.setMaxHealth(100);
		this.setHealth(this.getMaxHealth());
		this.setCoins(0);
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
				try {
					new Sound("hit");
				} catch (Exception e) {
				}
				break;
				
			case Coin:
				this.setHealth(this.getHealth() + 5);
				this.setCoins(this.getCoins() + 1);
				try {
					new Sound("coin");
				} catch (Exception e) {
				}
				object.die();
				break;
				
			case CoinNoHealth:
				this.setCoins(this.getCoins() + 1);
				try {
					new Sound("coin");
				} catch (Exception e) {
				}
				object.die();
				break;

			default:		
			}
		}
	}
	
	// Make the player die
	public void die()
	{	
		// Release coins
		for(int i=0 ; i < this.getCoins() ; i++)
		{
			new Coin(this.getX(), this.getY(), (this.getVelX() + Main.random.nextFloat() - 0.5f) * Main.random.nextFloat(), (this.getVelY() + Main.random.nextFloat() - 0.5f) * Main.random.nextFloat());
		}
		
		// Player explode in 8 pieces
		new Lifetime(this.getX(), this.getY(), this.getVelX() - 0.2f, this.getVelY(), this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX() + 0.2f, this.getVelY(), this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX(), this.getVelY() + 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX(), this.getVelY() - 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX() - 0.2f, this.getVelY() - 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX() + 0.2f, this.getVelY() - 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX() - 0.2f, this.getVelY() + 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
		new Lifetime(this.getX(), this.getY(), this.getVelX() + 0.2f, this.getVelY() + 0.2f, this.getColor(), 16, 16, 3000000000l + 5000000000l * (long) Main.random.nextFloat());
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
