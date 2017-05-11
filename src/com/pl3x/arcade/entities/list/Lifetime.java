package com.pl3x.arcade.entities.list;

import java.awt.Color;

import com.pl3x.arcade.entities.GameObject;
import com.pl3x.arcade.entities.ID;

public class Lifetime extends GameObject{
	
	private long lifetime;	// Lifetime duration in nanoseconds
	
	public Lifetime(float x, float y, float velX, float velY, Color color, int sizeX, int sizeY, long lifetime)
	{
		super(x, y, velX, velY, Math.max(velX, velY), ID.Decoration, color, sizeX, sizeY);

		this.setLifetime(lifetime);
	}

	// Tick: reduce lifetime
	public void tick(long deltaNano) {
		super.tick(deltaNano);
		
		this.setLifetime(this.getLifetime() - deltaNano);
	}

	// Getters
	public long getLifetime()
	{
		return this.lifetime;
	}
	
	// Setters
	public void setLifetime(long lifetime)
	{
		if (lifetime < 0)
			lifetime = 0;
		
		this.lifetime = lifetime;
		
		if (this.lifetime <= 0)
			this.die();
	}
}