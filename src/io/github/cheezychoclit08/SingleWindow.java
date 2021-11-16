package io.github.cheezychoclit08;

//@author Torin

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class SingleWindow extends JPanel{
	//Initializing Delimiter Variable
	private static char d = MainWindow.d;

	//Creating Buttons
	public JButton b1 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b2 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b3 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b4 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b5 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b6 = new JButton(Character.toString(Character.toUpperCase(d)));
	public JButton b7 = new JButton(Character.toString(Character.toUpperCase(d))); 
	public JButton b8 = new JButton(Character.toString(Character.toUpperCase(d))); 
	public JButton b9 = new JButton(Character.toString(Character.toUpperCase(d))); 
	public JButton[][] bArr = {
								{b1, b2, b3,}, 
						    	{b4, b5, b6,},
						    	{b7, b8, b9}
						       };


	//Other Global Variables
	private static char team = 'x';
	
	public SingleWindow() {
		//Setting Button Mnemonics
		b1.setMnemonic('1');
		b2.setMnemonic('2');
		b3.setMnemonic('3');
		b4.setMnemonic('4');
		b5.setMnemonic('5');
		b6.setMnemonic('6');
		b7.setMnemonic('7');
		b8.setMnemonic('8');
		b9.setMnemonic('9');
		
		//Setting Layout
		setLayout(new GridLayout(3, 3));
		
		//Adding Components, Setting Color, And Adding Action Listeners
		for(int i = 0; i < bArr.length; i++) {
			for(int k = 0; k < bArr[i].length; k++) {
				JButton b = bArr[i][k];
				b.setBackground(new Color(211, 210, 212));    //new Color(200, 0, 0), new Color(60, 60, 220)
				b.setFont(new Font("Sans-Serif", Font.BOLD, 45));
				b.setFocusPainted(false);
				b.addActionListener(new BtnLstnr());
				add(b);
			}
		}
		
		setVisible(true);
	}
	
	public char buttonPressFunction(JButton b) throws InterruptedException {
		if(GameLogic.checkSmallBoardWinner(GameLogic.getCaFromBa(bArr)) != d) {
			if(team == 'x') {
				MainWindow.w.setTitle("Tic-Tac-Toe     Team: O Won");
				b.setBackground(Color.RED);
			} else if(team == 'o') {
				MainWindow.w.setTitle("Tic-Tac-Toe     Team: X Won");
				b.setBackground(Color.BLUE);
			} else {
				System.out.println("There Was An Error!");
				System.exit(-1);
			}
			JOptionPane.showMessageDialog(MainWindow.w, "Team "+Character.toUpperCase(team)+" Won!!");
			System.exit(0);
			return ' ';
		} else if(GameLogic.testIfTied(GameLogic.getCaFromBa(bArr)) == false) {
			if(team == 'x') {
				MainWindow.w.setTitle("Tic-Tac-Toe - Team: O");
				MainWindow.lTeam.setText("Team: O ");
				b.setBackground(Color.RED);
				return 'o';
			} else if(team == 'o') {
				MainWindow.w.setTitle("Tic-Tac-Toe - Team: X");
				MainWindow.lTeam.setText("Team: X ");
				b.setBackground(Color.BLUE);
				return'x';
			} else {
				System.out.println("There Was An Error!");
				System.exit(-1);
				return ' ';
			}
		} else if(GameLogic.testIfTied(GameLogic.getCaFromBa(bArr)) == true) {
			JOptionPane.showMessageDialog(null, "It Was A Tie");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "There Was An Error!");
			System.exit(-1);
			return ' ';
		}
		return ' ';
	}
	
	//Event Listeners
	private class BtnLstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String btnText = ((AbstractButton) e.getSource()).getText();
			if(btnText.equals(Character.toString(d))) {
				((JButton) e.getSource()).setText(Character.toString(Character.toUpperCase(team)));
				GameLogic.getCaFromBa(bArr)[0][0] = Character.toUpperCase(team);
				try {
					team = buttonPressFunction((JButton) e.getSource());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
}
