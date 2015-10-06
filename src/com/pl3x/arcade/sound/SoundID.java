package com.pl3x.arcade.sound;

public enum SoundID {
	coin		("coin.wav"),			// Player earn a coin
	hit			("hit.wav"),			// Player touch enemy
	menu_select	("menu_select.wav");	// Menu item change

	// Short filename.
	public String filename;	

	// Constructor
	private SoundID(String filename)
	{
		this.filename = filename;
	}
}
