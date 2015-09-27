package com.pl3x.arcade.main;

import java.awt.*;
import javax.swing.*;

public class Windows extends Canvas {

	private static final long serialVersionUID = -8681307114418070490L;
	
	public Windows(int width, int height, String title, Main main){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(main);
		frame.setVisible(true);
		main.start();
	}
	
}
