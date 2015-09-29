package com.pl3x.arcade.main;

import java.awt.event.*;

import com.pl3x.arcade.entities.*;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){ //when the key are pressed
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) tempObject.setVelY(-5); //pressing w or z will go up
				if(key == KeyEvent.VK_S) tempObject.setVelY(5); //pressing s will go down
				if(key == KeyEvent.VK_D) tempObject.setVelX(5); //pressing d will go right
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) tempObject.setVelX(-5); //pressing a or q will go left
			}
			if(tempObject.getId() == ID.Player2){ //when the key are pressed
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5); //pressing w or z will go up
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5); //pressing s will go down
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5); //pressing d will go right
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5); //pressing a or q will go left
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){ //when the key a released
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) tempObject.setVelY(0); //release w or z, s, d, a or q will stop the player
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) tempObject.setVelX(0);
			}
			if(tempObject.getId() == ID.Player2){ //when the key a released
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0); //release w or z, s, d, a or q will stop the player
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_Q) tempObject.setVelX(0);
			}
		}
	}
}
