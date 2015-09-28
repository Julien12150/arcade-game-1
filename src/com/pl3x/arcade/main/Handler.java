package com.pl3x.arcade.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.pl3x.arcade.entities.GameObject;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick(); //tick stuff
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g); //render stuff
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object); //it's will add an object with "addObject"
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object); //same but will remove it
	}
	
}
