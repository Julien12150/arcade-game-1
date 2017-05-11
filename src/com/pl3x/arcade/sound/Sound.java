package com.pl3x.arcade.sound;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * A sound of SoundID.
 *
 */
public class Sound {

	// The SoundId
	private SoundID soundId;

	// Clip.
	private Clip clip;

	// Sound
	private AudioInputStream sound;

	// Constructor
	public Sound(SoundID soundId)
	{
		this.soundId = soundId;
		this.clip = null;
		this.sound = null;
	}
	
	/**
	 * Play sound.
	 * 
	 * @return boolean true if sound played, false else.
	 */
	public boolean play() {
		Clip clip;

		try {
			clip = this.getClip();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println("Sound: cannot get clip: " + this);
			return false;
		}
		
		if (clip.isRunning()) {
			// System.out.println("Sound: cannot play: sound is running: " + this.soundId);
			return false;
		}
		
		// Play sound.
		clip.setFramePosition(0);
		clip.start();
		return true;
	}

	// Return clip to play sound.
	protected Clip getClip() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{	
		if (this.clip == null)
		{
			this.clip = AudioSystem.getClip();
			
			this.sound = AudioSystem.getAudioInputStream(
					new BufferedInputStream(
							getClass().getResourceAsStream("/com/pl3x/arcade/ressources/wav/" + this.soundId.filename + ".wav")
					)
			);

			this.clip.open(this.sound);
		}
				
		return this.clip;
	}
	
	// Release clip and sound
	public void close()
	{
		if (this.clip != null) {
			this.clip.close();
			this.clip = null;
		}
		
		if (this.sound != null) {
			try {
				this.sound.close();
			} catch (IOException e) {
			}
			this.sound = null;
		}
	}
}
