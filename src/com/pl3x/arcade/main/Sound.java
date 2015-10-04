package com.pl3x.arcade.main;

import java.io.BufferedInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Sound {
	public Sound(String sound){
		try {
			playSound(sound);
		} catch (Exception e) {
			System.out.println("Error loading the file '" + sound + "'.");
		}
	}
	
	public void playSound(String sound) throws Exception{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(
				    new BufferedInputStream(getClass().getResourceAsStream("/com/pl3x/arcade/ressources/wav/" + sound + ".wav"))));
			clip.start();
	}
}
