package com.pl3x.arcade.entities.list;

import java.awt.event.KeyEvent;
import com.pl3x.arcade.entities.*;

public class Player1 extends Player{
	
//	float velUpTime = 0;
//	float velDownTime = 0;
//	float velRightTime = 0;
//	float velLeftTime = 0;
	
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
			// Go up TODO: finish this code
			/*velUpTime++;
			
			if(velUpTime == 1){
				setVelY(velUpTime);
				velUpTime = 0;
			}*/
			
			this.setVelY( this.getVelY() - (this.getVelMax()));
			break;
			
		case KeyEvent.VK_S:
			// Go down
			this.setVelY( this.getVelY() + (this.getVelMax()));
			break;
			
		case KeyEvent.VK_D:
			// Go right
			this.setVelX( this.getVelX() + (this.getVelMax()));
			break;
			
		case KeyEvent.VK_A:
		case KeyEvent.VK_Q:
			// Go left
			this.setVelX( this.getVelX() - (this.getVelMax()));
			break;
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_Z:
			// Go up
			this.setVelY(0);
			break;
			
		case KeyEvent.VK_S:
			// Go down
			this.setVelY(0);
			break;
			
		case KeyEvent.VK_D:
			// Go right
			this.setVelX(0);
			break;
			
		case KeyEvent.VK_A:
		case KeyEvent.VK_Q:
			// Go left
			this.setVelX(0);
			break;
		}
	}
}
