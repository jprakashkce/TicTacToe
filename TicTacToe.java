package projects;

import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n;
			n = sc.nextInt();
			String[][] board = new String[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					board[i][j] = " - ";
				}
			}

			System.out.println("Let's Start our Game...!");
			System.out.println("Player 1, Tell me your Name...");
			String p1 = sc.next();
			System.out.println("Player 2, Tell me your Name...");
			String p2 = sc.next();
			boolean player1 = true;
			boolean gameEnded = false;
			while(!gameEnded) {
				drawBoard(board);
				if(player1) {
					System.out.println(p1+" 's Turn (X) : ");
				}
				else {
					System.out.println(p2+" 's Turn (O) : ");
				}

				String c = " - ";
				if(player1) {
					c = " X ";
				}

				else {
					c = " O ";
				}
				int row = 0;
				int col = 0;
				while(true) {
					System.out.println("Enter a row Number to Insert : ");
					row = sc.nextInt();
					System.out.println("Enter a Column Number to Insert : ");
					col = sc.nextInt();
					if(row<0 || col<0 || row>=n || col>=n) {
						System.out.println("This Position is off the Bound of the Board! Try again.");

					}
					else if(board[row][col]!=" - ") {
						System.out.println("Opponnet has already made a move at this position! try Again.");

					}
					else {
						break;
					}

				}
				board[row][col] = c;
				if(playerHasWon(board)==" X ") {
					System.out.println(p1 + " has Won!");
					gameEnded = true;
				}
				else if(playerHasWon(board)==" O ") {
					System.out.println(p2 + " has Won!");
					gameEnded = true;
				}
				else {
					if(boardIsFull(board)) {
						System.out.println(" It's a Tie!");
						gameEnded = true;
					}
					else {
						player1 = !player1;
					}
				}
			}
			drawBoard(board);

	}

	public static void drawBoard(String[][] board) {
		System.out.println("Board:");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public static String playerHasWon(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			boolean inARow = true;
			String value = board[i][0];
			if (value == " - ") {
				inARow = false;
			} else {
				for (int j = i; j < board[i].length; j++) {
					if (board[i][j] != value) {
						inARow = false;
						break;
					}
				}
			}
			if (inARow) {
				return value;
			}
		}
		for (int j = 0; j < board[0].length; j++) {
			boolean inACol = true;
			String value = board[0][j];
			if (value == " - ") {
				inACol = false;
			} else {
				for (int i = 1; i < board.length; i++) {
					if (board[i][j] != value) {
						inACol = false;
						break;
					}
				}
			}

			if (inACol) {
				return value;
			}
		}
		boolean inADiag1 = true;
		String value1 = board[0][0];
		if (value1 == " - ")
			inADiag1 = false;
		else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != value1) {
					inADiag1 = false;
					break;
				}
			}
		}
		if (inADiag1) {
			return value1;
		}

		boolean inADiag2 = true;
		String value2 = board[0][board.length - 1];
		if (value2 == " - ") {
			inADiag2 = false;
		} else {
			for (int i = 1; i < board.length; i++) {
				if (board[i][board.length - 1 - i] != value2) {
					inADiag2 = false;
					break;
				}
			}
		}
		if (inADiag2) {
			return value2;
		}
		return " ";
	}

	public static boolean boardIsFull(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == " - ") {
					return false;
				}
			}
		}
		return true;
	}

}