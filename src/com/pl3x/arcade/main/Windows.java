package com.pl3x.arcade.main;

import java.awt.*;
import javax.swing.*;

public class Windows extends Canvas {

	private static final long serialVersionUID = -8681307114418070490L;
	public JFrame frame;
	
	public Windows(int width, int height, String title){
		this.frame = new JFrame(title); //lets make a new frame!
		
		this.frame.setPreferredSize(new Dimension(width, height)); //width/height of the windows
		this.frame.setMaximumSize(new Dimension(width, height));
		this.frame.setMinimumSize(new Dimension(width, height));
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what happen when you click the X button? the program close!
		this.frame.setResizable(false); //it's resizable? nah
		this.frame.setLocationRelativeTo(null); 
		this.frame.add(this);
		this.frame.setVisible(true); //its become visible!
	}
	
}
