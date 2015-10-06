package com.pl3x.arcade.main;

import java.io.IOException;
import java.util.HashMap;


import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private HashMap<SoundID, Clip> clips;	// Buffer to store sounds (ie 1 sound = 1 clip)
	
	// Constructor
	public Sound()
	{
		// Create empty sound list.
		this.clips = new HashMap<SoundID, Clip>();
	}
	
	// Player 1 sound
	public void play(SoundID soundId)
	{
		
		try {
			Clip clip = soundId.getClip();
			clip.start();
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			System.out.println("Sound: cannot load extra clip " + soundId);
		}
		
		if (true)
		return;
		if (! this.clips.containsKey(soundId))
			// Add clip to buffer.
			try {
				this.clips.put(soundId, soundId.getClip());
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
				System.out.println("Sound: cannot load clip " + soundId);
				return;
			}
		/*
		// Get sound from  buffer.
		 clip = this.clips.get(soundId);
		
		if (! clip.isRunning())
		{
			// Play sound from buffer.
			clip.setFramePosition(0);
			clip.start();
		}
		else
		{
			// Buffer sound is currently played: play new sound from outside of buffer.
			try {
				clip = soundId.getClip();
			} catch (LineUnavailableException | IOException
					| UnsupportedAudioFileException e) {
				System.out.println("Sound: cannot load extra clip " + soundId);
			}
			clip.start();
			return;
			*/
		
	}
}
