package com.pl3x.arcade.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.pl3x.arcade.Main;
import com.pl3x.arcade.Main.STATE;
import com.pl3x.arcade.entities.GameObject;
import com.pl3x.arcade.level.LevelClassic;
public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private Main main;
	
	
	public static boolean canDropCoinBeUsed = true;
	public static boolean canDropCoinBeUsed2 = true;
	
	public STATE State;
	
	
	
	public KeyInput(Handler handler, Main main){
		this.handler = handler;
		this.main = main;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(main.State == STATE.MENU){
			if(key == KeyEvent.VK_UP){
				if(Main.menu.select <= 0) Main.menu.select = 2;
				else Main.menu.select--;
				try{	new Sound("menu_select");	}catch(Exception e1){}
			}
			else if(key == KeyEvent.VK_DOWN){
				if(Main.menu.select >= 2) Main.menu.select = 0;
				else Main.menu.select++;
				try{	new Sound("menu_select"); }catch(Exception e1){}
			}
		}
		
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER && main.State == STATE.MENU){
			if(Main.menu.select == 0){
				Main.menu = null;
				new LevelClassic(false);
				return;
			}
			else if(Main.menu.select == 1){
				Main.menu = null;
				new LevelClassic(true);
				return;
			}
			else if(Main.menu.select == 2) System.exit(0);
		}
		
		if (key == KeyEvent.VK_F3)
		{
			Main.hud.setIsInfoShowed(! Main.hud.getIsInfoShowed());
			return;
		}
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			tempObject.keyPressed(e);
			
			/*
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z){tempObject.setVelY(-5); //pressing w or z will go up
					Player.Direction = 0;
				}
				if(key == KeyEvent.VK_S){ tempObject.setVelY(5); //pressing s will go down
					Player.Direction = 180;
				}
				if(key == KeyEvent.VK_D){ tempObject.setVelX(5); //pressing d will go right
					Player.Direction = 90;
				}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q){ tempObject.setVelX(-5); //pressing a or q will go left
					Player.Direction = -90;
				}
				
				if(HUD.COIN > 0 && canDropCoinBeUsed && key == KeyEvent.VK_SPACE){	
					if(Player.Direction == 0){
						handler.addObject(new Coin(tempObject.getX() + 8, tempObject.getY() - 17, ID.CoinNoHealth, this.handler, 0, -5));
						HUD.COIN--;
					}
					if(Player.Direction == 90){
						handler.addObject(new Coin(tempObject.getX() + 33, tempObject.getY() + 8, ID.CoinNoHealth, this.handler, 5, 0));
						HUD.COIN--;
					}
					if(Player.Direction == 180){
						handler.addObject(new Coin(tempObject.getX() + 8, tempObject.getY() + 33, ID.CoinNoHealth, this.handler, 0, 5));
						HUD.COIN--;
					}
					if(Player.Direction == -90){
						handler.addObject(new Coin(tempObject.getX() - 17, tempObject.getY() + 8, ID.CoinNoHealth, this.handler, -5, 0));
						HUD.COIN--;
					}
					canDropCoinBeUsed = false;
				}
			}
			if(tempObject.getId() == ID.Player2){
				if(key == KeyEvent.VK_UP){ tempObject.setVelY(-5); //pressing w or z will go up
					Player2.Direction = 0;
				}
				if(key == KeyEvent.VK_DOWN){ tempObject.setVelY(5); //pressing s will go down
					Player2.Direction = 180;
				}
				if(key == KeyEvent.VK_RIGHT){ tempObject.setVelX(5); //pressing d will go right
					Player2.Direction = 90;
				}
				if(key == KeyEvent.VK_LEFT){ tempObject.setVelX(-5); //pressing a or q will go left
					Player2.Direction = -90;
				}
				
				if(HUD.COIN2 > 0 && canDropCoinBeUsed2 && key == KeyEvent.VK_SHIFT){	
					if(Player2.Direction == 0){
						handler.addObject(new Coin(tempObject.getX() + 8, tempObject.getY() - 17, ID.CoinNoHealth, this.handler, 0, -5));
						HUD.COIN2--;
					}
					if(Player2.Direction == 90){
						handler.addObject(new Coin(tempObject.getX() + 33, tempObject.getY() + 8, ID.CoinNoHealth, this.handler, 5, 0));
						HUD.COIN2--;
					}
					if(Player2.Direction == 180){
						handler.addObject(new Coin(tempObject.getX() + 8, tempObject.getY() + 33, ID.CoinNoHealth, this.handler, 0, 5));
						HUD.COIN2--;
					}
					if(Player2.Direction == -90){
						handler.addObject(new Coin(tempObject.getX() - 17, tempObject.getY() + 8, ID.CoinNoHealth, this.handler, -5, 0));
						HUD.COIN2--;
					}
					canDropCoinBeUsed2 = false;
				}
			}
			*/
		}
	}
	@SuppressWarnings("unused")
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
		
			tempObject.keyReleased(e);
		/*
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){ //when the key a released
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_Z) tempObject.setVelY(0); //release w or z, s, d, a or q will stop the player
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_Q) tempObject.setVelX(0);
				
				if(key == KeyEvent.VK_SPACE) canDropCoinBeUsed = true;
			}
			if(tempObject.getId() == ID.Player2){ //when the key a released
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0); //release w or z, s, d, a or q will stop the player
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_Q) tempObject.setVelX(0);
					
				if(key == KeyEvent.VK_SHIFT) canDropCoinBeUsed2 = true;
			}
		}
		 */
		}
	}
}
