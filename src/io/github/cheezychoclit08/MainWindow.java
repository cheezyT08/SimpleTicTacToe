package io.github.cheezychoclit08;

//@author Torin

import java.awt.*;

import javax.swing.*;
public class MainWindow {
	//Creating Delimiter Global Variable
		static char d = '_';
		
		//Creating Labels
		public static JLabel lTeam = new JLabel("Team: X");
			
		//Creating Panel And Label To Display Team
		private static JPanel pTeam = new JPanel();
		
		//Initializing MainWindow
		public static JFrame w = new JFrame("Tic-Tac-Toe");

		public static void buildWindow() {
			//Setting MainWindow Settings
			w.setTitle("Tic Tac Toe - Team: X");
			w.setLayout(new GridLayout(2, 1));
			w.setResizable(false);
			
			//Adding Components
			lTeam.setBorder(BorderFactory.createEmptyBorder(20,97,0,0));
			lTeam.setFont(new Font("Sans-Serif", Font.BOLD, 25));
			pTeam.add(lTeam);
			w.add(new SingleWindow());
			w.add(lTeam);
			
			//Packing Centering And Making MainWindow Visible
			w.setSize(300, 460);
			w.setLocationRelativeTo(null);
			w.setVisible(true);
		}
		
}
