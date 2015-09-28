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
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) tempObject.setVelY(-5); 
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) tempObject.setVelX(-5);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i <handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){ //when the key a released
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) tempObject.setVelX(0);
			}
		}
	}
}
