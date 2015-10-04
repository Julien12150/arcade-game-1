package com.pl3x.arcade.entities.list;

import java.awt.event.KeyEvent;
import com.pl3x.arcade.entities.*;

public class Player2 extends Player{
	
	public Player2(float x, float y) {
		super(x, y, ID.Player2);
	}
	
	// Make the player die
	public void die()
	{	
		System.out.println("Player two died with " + this.getCoins() + " coins.");
		
		super.die();
	}
	
	// key: move player
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch(key)
		{
		case KeyEvent.VK_UP:
			// Go up
			this.setVelY( this.getVelY() - (this.getVelMax()));
			break;
			
		case KeyEvent.VK_DOWN:
			// Go down
			this.setVelY( this.getVelY() + (this.getVelMax()));
			break;
			
		case KeyEvent.VK_RIGHT:
			// Go right
			this.setVelX( this.getVelX() + (this.getVelMax()));
			break;
			
		case KeyEvent.VK_LEFT:
			// Go left
			this.setVelX( this.getVelX() - (this.getVelMax()));
			break;
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_UP:
			// Go up
			this.setVelY(0);
			break;
			
		case KeyEvent.VK_DOWN:
			// Go down
			this.setVelY(0);
			break;
			
		case KeyEvent.VK_RIGHT:
			// Go right
			this.setVelX(0);
			break;
			
		case KeyEvent.VK_LEFT:
			// Go left
			this.setVelX(0);
			break;
		}
	}
}
