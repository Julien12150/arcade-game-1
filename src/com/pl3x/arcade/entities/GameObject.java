package com.pl3x.arcade.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import com.pl3x.arcade.Main;

public class GameObject {
	
	private ID id;				// Type of GameObject
	private float x, y;			// Coordinates: 0..1	
	private float velX, velY;	// Speed, coordinates by seconds
	private float velMax;		// Maximum speed
	private int sizeX, sizeY;	// Size
	private Color color;		// Color
	private float halfSizeXFloat, halfSizeYFloat, sizeXFloat, sizeYFloat;
	private int halfSizeXPixel, halfSizeYPixel;
	
	// Constructor
	public GameObject(float x, float y, float velX, float velY, float velMax, ID id, Color color, int sizeX, int sizeY)
	{
		this.setID(id);
		this.setX(x);
		this.setY(y);
		this.setVelMax(velMax);
		this.setVelX(velX);
		this.setVelY(velY);
		this.setColor(color);
		this.setSizeX(sizeX);
		this.setSizeY(sizeY);
		Main.handler.addObject(this);
	}

	// Tick: move object and collide
	public void tick(long deltaNano) {
		// Move object
		this.x += this.velX * deltaNano / 1000000000;
		this.y += this.velY * deltaNano / 1000000000;
		
		// Collision with borders
		if (this.x - this.halfSizeXFloat <= 0)
		{	
			this.x = this.halfSizeXFloat;
			this.velX = -this.velX;
		}
		else if (this.x + this.halfSizeXFloat >= 1)
		{
			this.x = 1 - this.halfSizeXFloat;
			this.velX = -this.velX;
		}
		
		// Move object Y
		if (this.y - this.halfSizeYFloat <= 0)
		{
			this.y = this.halfSizeYFloat;
			this.velY = -this.velY;
		}
		else if (this.y + this.halfSizeYFloat >= 1)
		{
			this.y = 1 - this.halfSizeYFloat;
			this.velY = -this.velY;
		}
		
		// Detect collisions
		Rectangle2D.Float hitbox = this.getBounds();
		ArrayList<GameObject> hits = new ArrayList<GameObject>();
		
		for(int i = 0; i < Main.handler.object.size(); i++)
		{
			GameObject tempObject = Main.handler.object.get(i);
		
			if ((tempObject != this) && (tempObject.getBounds().intersects(hitbox))) {
				hits.add(tempObject);
			}
		}
		
		if (hits.size() > 0)
			this.collision(hits);
	}
	
	// Collision with GameObjects
	protected void collision(ArrayList<GameObject> hits)
	{
	}

	// Display object
	public void render(Graphics g) {
		int x = (int) (this.x * Main.WIDTH);
		int y = (int) (this.y * Main.HEIGHT);
		g.setColor(this.getColor());
		g.fillRect(x - this.halfSizeXPixel, y - this.halfSizeYPixel, this.sizeX, this.sizeY);
	}

	// Return hitbox
	private Rectangle2D.Float getBounds() {
		return new Rectangle2D.Float(this.x - this.halfSizeXFloat, y - this.halfSizeYFloat, this.sizeXFloat, this.sizeYFloat);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	
	// Make the entity die
	public void die()
	{
		Main.handler.removeObject(this);
	}
	/* Getters */
	public ID getId()
	{
		return this.id;
	}
	
	public float getX()
	{
		return this.x;
	}
	
	public float getY()
	{
		return this.y;
	}
	
	public float getVelX()
	{
		return this.velX;
	}
	
	public float getVelY()
	{
		return this.velY;
	}
	
	public float getVelMax()
	{
		return this.velMax;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public int getSizeX()
	{
		return this.sizeX;
	}
	
	public int getSizeY()
	{
		return this.sizeY;
	}
	
	/* Setters */
	public void setID(ID id)
	{
		this.id = id;
	}
	
	public void setX(float x)
	{
		if (x > 1)
			x = 1;
		else if (x < 0)
			x = 0;
		
		this.x = x;
	}
	
	public void setY(float y)
	{
		if (y > 1)
			y = 1;
		else if (y < 0)
			y = 0;
		
		this.y = y;
	}
	
	public void setVelX(float velX)
	{
		if (velX > this.velMax)
			velX = this.velMax;
		else if (velX < -this.velMax)
			velX = -this.velMax;
		
		this.velX = velX;
	}

	public void setVelY(float velY)
	{
		if (velY > this.velMax)
			velY = this.velMax;
		else if (velY < -this.velMax)
			velY = -this.velMax;
		
		this.velY = velY;
	}
	
	public void setVelMax(float velMax)
	{
		this.velMax = velMax < 0 ? -velMax : velMax;
	}

	public void setColor(Color color) {
		this.color = color;	
	}
	
	public void setSizeX(int sizeX)
	{
		if (sizeX < 0)
			sizeX = -sizeX;
		
		this.sizeX = sizeX;
		this.sizeXFloat = this.getSizeX() / (float) Main.WIDTH;
		this.halfSizeXFloat = this.getSizeX() / (float) (2 * Main.WIDTH);
		this.halfSizeXPixel = this.getSizeX() / 2;
	}
	
	public void setSizeY(int sizeY)
	{
		if (sizeY < 0)
			sizeY = -sizeY;
		
		this.sizeY = sizeY;
		this.sizeYFloat = this.getSizeY() / (float) (Main.HEIGHT);
		this.halfSizeYFloat = this.getSizeY() / (float) (2 * (Main.HEIGHT));
		this.halfSizeYPixel = this.getSizeY() / 2;
	}

	public void keyReleased(KeyEvent e) {
	}
}