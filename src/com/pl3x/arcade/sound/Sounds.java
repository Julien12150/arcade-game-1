/**
 * To play sounds, bufferize them.
 */
package com.pl3x.arcade.sound;

import java.util.ArrayList;
import java.util.HashMap;


public class Sounds {
	static final int MAX_BUFFER_SOUND_COUNT = 20;
	
	// Buffer to store sounds, a list for each sound.
	private HashMap<SoundID, ArrayList<Sound>> sounds;
	
	// Constructor
	public Sounds()
	{
		this.sounds = new HashMap<SoundID, ArrayList<Sound>>();
	}
	
	// Play a sound.
	public void play(SoundID soundId)
	{
		if (! this.sounds.containsKey(soundId)) {
			this.sounds.put(soundId, new ArrayList<Sound>());
		}

		// Sounds list for required soundId
		ArrayList<Sound> sounds = this.sounds.get(soundId);
		
		int i;
		for (i=0 ; i < sounds.size() ; i++) {
			if (sounds.get(i).play()) {
				// System.out.println("Sound: play sound from buffer: " + soundId);
				return;
			}
		}
		
		if (i == Sounds.MAX_BUFFER_SOUND_COUNT) {
			System.out.println("Sound: cannot load more (" + Sounds.MAX_BUFFER_SOUND_COUNT + " max): " + soundId);
			return;
		}
		
		// Add a new sound to buffer.
		Sound sound = new Sound(soundId);
		if (sound.play()) {
			// System.out.println("Sound: play new sound: " + soundId);
			sounds.add(sound);
		}
		else {
			System.out.println("Sound: cannot play new sound: " + soundId);
		}
	}
}