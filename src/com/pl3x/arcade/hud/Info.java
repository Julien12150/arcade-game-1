package com.pl3x.arcade.hud;

import java.awt.*;

import com.pl3x.arcade.entities.*;
import com.pl3x.arcade.main.*;

public class Info {
	public static int fps;
	
	public static void render(Graphics g, Handler handler){
		g.setColor(Color.white);
		g.drawString("COIN: " + HUD.COIN + " | " + HUD.COIN2, 0, 10);
		g.drawString("HEALTH: " + HUD.HEALTH + " | " + HUD.HEALTH2, 0, 22);
		g.drawString("E: " + handler.object.size(), 0, 34);
		g.drawString("fps: " + fps, 0, 46);
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player){
				g.drawString("1C: " + tempObject.getX() + " " + tempObject.getY() + " | " + tempObject.getVelX() + " " + tempObject.getVelY(), 0, 58);
			}
			if(tempObject.getId() == ID.Player2){
				g.drawString("2C: " + tempObject.getX() + " " + tempObject.getY() + " | " + tempObject.getVelX() + " " + tempObject.getVelY(), 0, 70);
			}
		}
	}
}
