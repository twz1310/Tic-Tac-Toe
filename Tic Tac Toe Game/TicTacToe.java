import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
	private JButton[][] board; // 2 dimensional array to store board
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	private String currentPlayer; // Differentiate between X and O's turn
	private boolean isWinner; // Determine when program stops
	private Container cp;

	public TicTacToe() {
		cp = getContentPane();
		cp.setLayout(new GridLayout(3, 3));
		setTitle("Tic Tac Toe");
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = new JButton[3][3];
		currentPlayer = "x";
		isWinner = false;
		initialiseBoard();
		initialiseMenuBar();

	}

	private void initialiseMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard(); // Clears the board
			}
		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Terminates the program
			}
		});
		menu.add(newGame); // menu represented by file 
		menu.add(quit);
		menuBar.add(menu); 
		setJMenuBar(menuBar); // initialise menu bar
	}

	private void resetBoard() {
		currentPlayer = "x";
		isWinner = false;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col].setText("");
			}
		}
	}

	private void initialiseBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
				board[row][col] = btn;
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (((JButton) e.getSource()).getText().equals("") && isWinner == false) {
							btn.setText(currentPlayer); // check validity of move, btn must be empty
							isWinner(); // check to see if there is a winner before proceeding
							togglePlayer(); // change turns
						}

					}
				});
				cp.add(btn);
			}
		}
	}

	private void togglePlayer() {
		if (currentPlayer.equals("x"))
			currentPlayer = "o";
		else
			currentPlayer = "x";
	}

	// Determines if there are 3 Xs or Os consecutively
	private void isWinner() {
		if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 1st Column
		} else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 2nd Column
		} else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 3rd Column
		} else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer)
				&& board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 1st Row
		} else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 2nd Row
		} else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 3rd Row
		} else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 1st Diagonal
		} else if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the winner!");
			isWinner = true; // Check 2nd Diagonal
		} else
			isWinner = false;
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new TicTacToe();
			}
		});
	}
}
