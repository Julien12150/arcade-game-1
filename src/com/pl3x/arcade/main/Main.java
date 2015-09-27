package com.pl3x.arcade.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 6230533464412165714L;
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 500;
	
	public static String name = "Arcade game"; //TODO: change the title
	
	private Thread thread;
	private boolean isRunning = false;
	
	public Main(){
		new Windows(WIDTH, HEIGHT, name, this); //it's make a new Windows
	}
	
	public synchronized void start(){ //when it's start
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		System.out.println("Started");
	}
	public synchronized void stop(){
		try{
			thread.join();
			isRunning = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){ //many things about fps stuff
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(isRunning)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,  0, WIDTH, HEIGHT);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Main(); //what happen when the program start? it's make a new "Main"
	}
}
