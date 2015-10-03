package com.pl3x.arcade.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

// import com.pl3x.arcade.entities.ID;
import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.entities.list.*;
import com.pl3x.arcade.hud.*;

public class Main extends Canvas implements Runnable
{
	private static final long serialVersionUID = 6230533464412165714L; //random number

	public static Handler handler;
	public static HUD hud;
	public static Windows window;
	public static Random random;
	
	public static final int WIDTH = 750;  //the screen resolution
	public static int HEIGHT = 500;
	public static final int HUD_HEIGHT = 50;
	
	// FPS limitation.
	private static final int MAX_FPS = 60;
	private static final int MIN_NANOSECONDS_BETWEEN_2_FRAMES  = 1000000000 / MAX_FPS;
	
	public static String name = "Arcade game"; //TODO: change the title
	
	private Thread thread;
	private boolean isRunning = false; //it's running? nah, very logic inside a program
	
	//private Random r;
	
	
	private Spawn spawner;
	
	public Main(){
		Main.handler = new Handler();
		Main.hud = new HUD();
		Main.random = new Random();
		
		this.addKeyListener(new KeyInput(Main.handler)); //it's will listen to keys NOTE: it's seem to not work in mac
		
		Main.window = new Windows(WIDTH, Main.HEIGHT + Main.HUD_HEIGHT, name, this); //it's make a new Windows
		Dimension r = Main.window.frame.getContentPane().getSize();	// Get real frame size (without borders)
		Main.HEIGHT = r.height - Main.HUD_HEIGHT;
		
		this.spawner = new Spawn();
		
		// Spawn 4 enemy and 4 coins
		for (int i=0 ; i < 4 ; i++)
		{
			new Enemy(Main.random.nextFloat(), Main.random.nextFloat(), Main.random.nextFloat() / 2, Main.random.nextFloat() / 2);
			new GameObject(Main.random.nextFloat(), Main.random.nextFloat(), 0, 0, 0, ID.Coin, Color.yellow, 16, 16);
 		}
		
		// Spawn left player in the middle of the screen.
		Player playerLeft = new Player(0.5f, 0.5f);
		Main.hud.setPlayerLeft(playerLeft);
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
	
	public void run()
	{
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
			
			long deltaNano = now - lastFrameTime;
			Main.handler.tick(deltaNano);
			this.spawner.tick(deltaNano);
			lastFrameTime = now;
			
			render();
		}

		stop();
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);         //the background will be black
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT + Main.HUD_HEIGHT);//and it's do the size of the screen
		
		Main.handler.render(g);
		Main.hud.render(g);

		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Main(); //what happen when the program start? it's make a new "Main"
	}
}
