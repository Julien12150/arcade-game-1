package com.pl3x.arcade.main;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum SoundID {
	coin("coin.wav"),	// Player earn a coin
	hit("hit.wav");		// Player touch enemy
	
	private String filename;	// Short filename.

	// Constructor
	private SoundID(String filename)
	{
		this.filename = filename;
	}
	
	// Return Clip to play sound
	public Clip getClip() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{	
		Clip clip = AudioSystem.getClip();
		
		clip.open(
			AudioSystem.getAudioInputStream(
					new BufferedInputStream(
							getClass().getResourceAsStream("/com/pl3x/arcade/ressources/wav/" + this.filename)
					)
			)
		);
		
		return clip;
	}
}
