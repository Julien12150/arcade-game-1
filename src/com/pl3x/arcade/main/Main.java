package com.pl3x.arcade.main;

import java.awt.Canvas;

public class Main extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 6230533464412165714L;
	
	public Main(){
		new Windows(750, 500, "Arcade Game", this); //TODO: change the title
	}
	
	public synchronized void start(){
		
	}
	
	public void run(){
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
