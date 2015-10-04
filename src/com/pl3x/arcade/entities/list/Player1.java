package com.pl3x.arcade.entities.list;

import java.awt.event.KeyEvent;
import com.pl3x.arcade.entities.*;

public class Player1 extends Player{
	
	public Player1(float x, float y) {
		super(x, y, ID.Player);
	}
	
	// Make the player die
	public void die()
	{	
		System.out.println("Player one died with " + this.getCoins() + " coins.");
		
		super.die();
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
}
