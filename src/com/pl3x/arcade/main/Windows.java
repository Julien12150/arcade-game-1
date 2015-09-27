package com.pl3x.arcade.main;

import java.awt.*;
import javax.swing.*;

public class Windows extends Canvas {

	private static final long serialVersionUID = -8681307114418070490L;
	
	public Windows(int width, int height, String title, Main main){
		JFrame frame = new JFrame(title); //lets make a new frame!
		
		frame.setPreferredSize(new Dimension(width, height)); //width/height of the windows
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what happen when you click the X button? the program close!
		frame.setResizable(false); //it's resizable? nah
		frame.setLocationRelativeTo(null); 
		frame.add(main); //it's add "main"
		frame.setVisible(true); //its become visible!
		main.start();
	}
	
}
