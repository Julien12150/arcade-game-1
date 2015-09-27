package com.pl3x.arcade.main;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		int HEIGHT = 1020;
		int WIDTH = 720;
		
		JFrame frame = new JFrame("An arcade game");          //The title TODO: make it to the real title name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what happen when you click the close button
		
		frame.setResizable(false);                            //it's resizable?
		
		frame.setVisible(true);                               //now let show it!
	}
}
