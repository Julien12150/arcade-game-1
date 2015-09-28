package com.pl3x.arcade.entities;

import java.util.Random;

import com.pl3x.arcade.entities.list.Coin;
import com.pl3x.arcade.main.Handler;
import com.pl3x.arcade.main.Main;

public class Spawn {
	
	private Random r;
	
	private int time;
	
	private Handler handler;
	
	public Spawn(Handler handler){
		this.handler = handler;
	}
	
	public void tick(){
		r = new Random();
		
		time++;
		if(time >= 200){
			time = 0;
			handler.addObject(new Coin(r.nextInt(Main.WIDTH - 16), r.nextInt(Main.HEIGHT - 16), ID.Coin, handler));
		}
	}
	
}
