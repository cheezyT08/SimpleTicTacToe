package io.github.cheezychoclit08;

import javax.swing.AbstractButton;

public class GameLogic {
	private static char d = MainWindow.d;
	
	public static char checkSmallBoardWinner(char[][] cArr) {
		for(int p = 0; p < cArr.length; p++) {
			//Testing If Equal From Top To Bottom Once Per Loop
			//int l = (cArr[p].length - 2);
			/*
			 * Later Feature For Larger Boards
			 * 
			*if(l < 1) {
			* 	l = 1;
			*}
			*/
			if((cArr[p][0]==cArr[p][1]&&cArr[p][1]==cArr[p][2])&&(cArr[p][0]!=d)) {
				//System.out.println("Test Passed 1");
				return cArr[p][0];
			}
			//Testing If Equal From Left To Right Once Per Loop
			if((cArr[0][p]==cArr[1][p]&&cArr[1][p]==cArr[2][p])&&(cArr[0][p]!=d)) {
				//System.out.println("Test Passed 2");
				return cArr[0][p];
			}
		}
		if((cArr[0][0]==cArr[1][1]&&cArr[1][1]==cArr[2][2])&&(cArr[1][1]!=d)) {
			//System.out.println("Test Passed 3");
			return cArr[1][1];
		}
		if((cArr[0][2]==cArr[1][1]&&cArr[1][1]==cArr[2][0])&&(cArr[1][1]!=d)) {
			//System.out.println("Test Passed 4");
			return cArr[1][1];
		}
		return d;
	}


	/*public static char checkSmallBoardWinner(char[][] cArr, int fSet) {
		for(int i = 0; i < cArr.length; i++) {
			//Finding Possible Sets Per Row
			int ps = (cArr.length - (fSet - 1));
				
			//Testing Rows
			//Looping Through Each Row For Each Possible Set(ps)
			for(int k = 0; k < ps; k++) {
				//Temporary Boolean To Test Each One, If False It Will Exit That For Loop
				boolean temp = false;
				for(int f = 0; f < (fSet - 1); f++) {
					//Test In Row i At Index Of k+f, k Starts At 0, So It Starts At f, Then It Tests The One To The Right, Then Does It Again One Farther To The Right
					if(cArr[i][k+f] == cArr[i][k+(f+1)] && cArr[i][k+f] != d) {
						temp = true;
					} else {temp = false; f = fSet;}
				}
			}
			
			//Testing Collum
			//Looping Through Each Row For Each Possible Set(ps)
			for(int k = 0; k < ps; k++) {
				//Temporary Boolean To Test Each One, If False It Will Exit That For Loop
				boolean temp = false;
				for(int f = 0; f < (fSet - 1); f++) {
					//Test In Row i At Index Of k+f, k Starts At 0, So It Starts At f, Then It Tests The One To The Right, Then Does It Again One Farther To The Right
					if(cArr[k+f][i] == cArr[k+(f+1)][i] && cArr[k+f][i] != d) {
						temp = true;
					} else {temp = false; f = fSet;}
				}
			}
			
			//Testing Diagonally Like: \
			//Looping Through Each Possible Set
			for(int k = 0; k < ps; k++) {
				for(int f = 0; f < (fSet - 1); f++) {
					
				}
			}
			
		}
		if((cArr[0][0]==cArr[1][1]&&cArr[1][1]==cArr[2][2])&&(cArr[1][1]!=d)) {
			//System.out.println("Test Passed 3");
			return cArr[1][1];
		}
		if((cArr[0][2]==cArr[1][1]&&cArr[1][1]==cArr[2][0])&&(cArr[1][1]!=d)) {
			//System.out.println("Test Passed 4");
			return cArr[1][1];
		}
		return d;
	}*/


	//To Test If All Slots In Board Do Not Match Delimiter
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
	
	public static String[][] getSaFromBa(AbstractButton[][] bArr) {
		//Finding Longest Row In Case Of Ragged Array
		int longestRowL = bArr[0].length;
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i].length > longestRowL) {
				longestRowL = bArr[i].length;
			}
		}
		
		//Creating Empty String Array(Will Contain nulls If Ragged Array Is Passed In)
		String[][] sArr = new String[bArr.length][longestRowL];
		
		//Filling String Array By Getting Text From Button Array And Putting In String Array
		for(int i = 0; i < bArr.length; i++) {
			for(int k = 0; k < bArr[i].length; k++) {
				sArr[i][k] = bArr[i][k].getText();
			}
		}
		return sArr;
	}
	
	public static char[][] getCaFromBa(AbstractButton[][] bArr) {
		//Finding Longest Row In Case Of Ragged Array
		int longestRowL = bArr[0].length;
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i].length > longestRowL) {
				longestRowL = bArr[i].length;
			}
		}
		
		//Creating Empty String Array(Will Contain nulls If Ragged Array Is Passed In)
		char[][] cArr = new char[bArr.length][longestRowL];
		
		//Filling char Array By Getting Text From Button Array And Putting In char Array
		for(int i = 0; i < bArr.length; i++) {
			for(int k = 0; k < bArr[i].length; k++) {
				String s = bArr[i][k].getText();
				cArr[i][k] = s.charAt(0);
			}
		}
		return cArr;
	}
	
}
