package javaSwingTicTacToe;

//@author Torin

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SwingTicTacToeMain {
	//Creating Delimiter Global Variable
	private static char d = '_';
	
	//Creating Board Array
	private static char[][] brdArr = {
		 							 {d, d, d}, 
									 {d, d, d}, 
									 {d, d, d}
									};
	
	//Creating Window
	private static JFrame w = new JFrame("Tic-Tac-Toe");
	
	//Creating Panels
	private static JPanel p1 = new JPanel();
	private static JPanel p2 = new JPanel();

	
	//Creating Labels
	private static JLabel l = new JLabel("Team: X");
	
	//Creating Buttons
	private static JButton b1 = new JButton(Character.toString(d));
	private static JButton b2 = new JButton(Character.toString(d));
	private static JButton b3 = new JButton(Character.toString(d));
	private static JButton b4 = new JButton(Character.toString(d));
	private static JButton b5 = new JButton(Character.toString(d));
	private static JButton b6 = new JButton(Character.toString(d));
	private static JButton b7 = new JButton(Character.toString(d)); 
	private static JButton b8 = new JButton(Character.toString(d)); 
	private static JButton b9 = new JButton(Character.toString(d)); 
	private static JButton[] JButtonArr = {b1, b2, b3, 
										   b4, b5, b6,
										   b7, b8, b9};
	
	//Creating Button Used Booleans
	private static boolean bool1 = false;
	private static boolean bool2 = false;
	private static boolean bool3 = false;
	private static boolean bool4 = false;
	private static boolean bool5 = false;
	private static boolean bool6 = false;
	private static boolean bool7 = false; 
	private static boolean bool8 = false; 
	private static boolean bool9 = false;
	
	//Other Global Variables
	private static char team = 'x';
	
	public static char check2d3x3CharArr(char[][] cArr) {
		for(int p = 0; p < 3; p++) {
			//Testing If Equal From Top To Bottom Once Per Loop
			if((cArr[p][0]==cArr[p][1]&&cArr[p][1]==cArr[p][2])&&(cArr[p][0]!=d)) {
				return cArr[p][0];
			}
			//Testing If Equal From Left To Right Once Per Loop
			if((cArr[0][p]==cArr[1][p]&&cArr[1][p]==cArr[2][p])&&(cArr[0][p]!=d)) {
				return cArr[0][p];
			}
		}
		if((cArr[0][0]==cArr[1][1]&&cArr[1][1]==cArr[2][2])&&(cArr[1][1]!=d)) {
			return cArr[1][1];
		}
		if((cArr[0][2]==cArr[1][1]&&cArr[1][1]==cArr[2][0])&&(cArr[1][1]!=d)) {
			return cArr[1][1];
		}
		return d;
	}
	
	//To Test That None Of The Slots In Board Match Delimiter
	public static boolean testIfTied(char[][] cArr) {
		for(int x = 0; x < cArr.length; x++) {
			for(int y = 0; y < cArr[x].length; y++) {
				if(cArr[x][y]==d) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void buildWindow() throws InterruptedException {
		//Setting Window Settings
		w.setTitle("Tic-Tac-Toe");
		w.setLayout(new GridLayout(4, 3));
		w.setSize(450, 460);
		w.setResizable(false);
		w.setLocationRelativeTo(null);
		
		//Adding Event Listeners
		b1.addActionListener(new b1Lstnr());
		b2.addActionListener(new b2Lstnr());
		b3.addActionListener(new b3Lstnr());
		b4.addActionListener(new b4Lstnr());
		b5.addActionListener(new b5Lstnr());
		b6.addActionListener(new b6Lstnr());
		b7.addActionListener(new b7Lstnr());
		b8.addActionListener(new b8Lstnr());
		b9.addActionListener(new b9Lstnr());
		
		//Adding Components And Setting Color
		for(JButton b : JButtonArr) {
			b.setBackground(new Color(211, 210, 212));    //new Color(200, 0, 0), new Color(60, 60, 220)
			b.setFont(new Font("Sans-Serif", Font.BOLD, 45));
			b.setFocusPainted(false);
			w.add(b);
		}
		l.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		l.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		p2.add(l);
		w.add(p1);
		w.add(p2);
		
		//Setting Window Visible
		w.setVisible(true);
	}
	
	public static char switchTeam(JButton b) throws InterruptedException {
		if(check2d3x3CharArr(brdArr) != d) {
			if(team == 'x') {
				w.setTitle("Tic-Tac-Toe     Team: O Won");
				b.setBackground(Color.RED);
			} else if(team == 'o') {
				w.setTitle("Tic-Tac-Toe     Team: X Won");
				b.setBackground(Color.BLUE);
			} else {
				System.out.println("There Was An Error!");
				System.exit(-1);
			}
			JOptionPane.showMessageDialog(w, "Team "+Character.toUpperCase(team)+" Won!!");
			System.exit(0);
			return ' ';
		} else if(testIfTied(brdArr) == false) {
			if(team == 'x') {
				w.setTitle("Tic-Tac-Toe");
				l.setText("Team: O");
				b.setBackground(Color.RED);
				return 'o';
			} else if(team == 'o') {
				w.setTitle("Tic-Tac-Toe");
				l.setText("Team: X");
				b.setBackground(Color.BLUE);
				return'x';
			} else {
				System.out.println("There Was An Error!");
				System.exit(-1);
				return ' ';
			}
		} else if(testIfTied(brdArr) == true) {
			JOptionPane.showMessageDialog(null, "It Was A Tie");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "There Was An Error!");
			System.exit(-1);
			return ' ';
		}
		return ' ';
	}
	
	public static void main(String[] args) throws InterruptedException {
		buildWindow();
	}
	
	//Event Listeners
	private static class b1Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool1 == false) {
				b1.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[0][0] = Character.toUpperCase(team);
				bool1 = true;
				try {
					team = switchTeam(b1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b2Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool2 == false) {
				b2.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[0][1] = Character.toUpperCase(team);
				bool2 = true;
				try {
					team = switchTeam(b2);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b3Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool3 == false) {
				b3.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[0][2] = Character.toUpperCase(team);
				bool3 = true;
				try {
					team = switchTeam(b3);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b4Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool4 == false) {
				b4.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[1][0] = Character.toUpperCase(team);
				bool4 = true;
				try {
					team = switchTeam(b4);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b5Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool5 == false) {
				b5.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[1][1] = Character.toUpperCase(team);
				bool5 = true;
				try {
					team = switchTeam(b5);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b6Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool6 == false) {
				b6.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[1][2] = Character.toUpperCase(team);
				bool6 = true;
				try {
					team = switchTeam(b6);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b7Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool7 == false) {
				b7.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[2][0] = Character.toUpperCase(team);
				bool7 = true;
				try {
					team = switchTeam(b7);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b8Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool8 == false) {
				b8.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[2][1] = Character.toUpperCase(team);
				bool8 = true;
				try {
					team = switchTeam(b8);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private static class b9Lstnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(bool9 == false) {
				b9.setText(Character.toString(Character.toUpperCase(team)));
				brdArr[2][2] = Character.toUpperCase(team);
				bool9 = true;
				try {
					team = switchTeam(b9);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
