package com.pl3x.arcade.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.entities.list.*;
import com.pl3x.arcade.hud.*;

public class Main extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 6230533464412165714L; //random number
	
	public static final int WIDTH = 750;  //the screen resolution
	public static final int HEIGHT = 500;
	public static final int HUD = 50;
	
	// FPS limitation.
	private static final int MAX_FPS = 60;
	private static final int MIN_NANOSECONDS_BETWEEN_2_FRAMES  = 1000000000 / MAX_FPS;
	
	public static String name = "Arcade game"; //TODO: change the title
	
	private Thread thread;
	private boolean isRunning = false; //it's running? nah, very logic inside a program
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	
	public Main(){
		handler = new Handler(); //the handler is a new Handler :O
		this.addKeyListener(new KeyInput(handler)); //it's will listen to keys NOTE: it's seem to not work in mac
		
		new Windows(WIDTH, HEIGHT + HUD, name, this); //it's make a new Windows
		
		hud = new HUD();
		spawner = new Spawn(handler);
		r = new Random();
		
		handler.addObject(new Player(r.nextInt(WIDTH - 32), r.nextInt(HEIGHT - 32), ID.Player, handler, 0)); //it's will spawn a player in the middle of the screen
		handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, 5, 5, handler));
		handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, -5, 5, handler));
		handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, 5, -5, handler));
		handler.addObject(new Enemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Enemy, -5, -5, handler));
		handler.addObject(new Coin(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), ID.Coin, handler, 0, 0));
	}
	
	public synchronized void start(){ //when it's start
		thread = new Thread(this);
		thread.start();
		isRunning = true; //when it's start, it's will run
		System.out.println("Started"); //it's write "started" in the console
	}
	public synchronized void stop(){
		try{
			thread.join();
			isRunning = false; //when it's stop, it's stop running
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){ //many things about fps stuff
		this.requestFocus();
	
		// Limit to MAX_FPS
		long lastFrameTime = System.nanoTime();
		long nextFrameTime = lastFrameTime;
		long now;
		
		// Count FPS.
		int  frames = 0;
		long nextCountFramesTime = lastFrameTime + 1000000000;

		while(isRunning){
			
			// Limit to MAX_FPS FPS.
			do {
				
				now = System.nanoTime();
			}
			while (now < nextFrameTime);
			nextFrameTime = now + MIN_NANOSECONDS_BETWEEN_2_FRAMES;
			
			// Count FPS.
			frames++;
			if (now > nextCountFramesTime) {
				Info.fps = frames;
				frames = 0;
				nextCountFramesTime = now + 1000000000;
			}
			
			tick();
			render();
		}
		stop();
	}
	
	private void tick(){
		 handler.tick();
		 spawner.tick();
	 	 hud.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);         //the background will be black
		g.fillRect(0,  0, WIDTH, HEIGHT);//and it's do the size of the screen
		
		handler.render(g);
		hud.render(g, handler);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Main(); //what happen when the program start? it's make a new "Main"
	}
}
