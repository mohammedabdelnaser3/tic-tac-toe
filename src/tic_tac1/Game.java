package tic_tac1;

import java.awt.EventQueue;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

import java.util.*;

public class Game extends JFrame {
	private JPanel contentPane;

	static String p1 = "First Player", p2 = "Second Player";
//	static private Names game = new Names();
	static int P1_Score = 0, P2_Score = 0;
	static JLabel playerOne_LBL = new JLabel();
	static JLabel playerTwo_LBL = new JLabel();
	static private Clip soundEffect, winEffect;
	
	static int next = 0, cnt = 0; 
	// WE NEED TO CREATE A WHO START FIRST QUESTION .^-^.  lol
	static char[][] grid = new char[3][3];
	
	static JButton Cell1 = new JButton("");
	static JButton Cell2 = new JButton("");
	static JButton Cell3 = new JButton("");
	static JButton Cell4 = new JButton("");
	static JButton Cell5 = new JButton("");
	static JButton Cell6 = new JButton("");
	static JButton Cell7 = new JButton("");
	static JButton Cell8 = new JButton("");
	static JButton Cell9 = new JButton("");
	
	static int checkForTheWin() {
		boolean X = false, O = false;
		
		for (int i = 0; i < 3; ++i) {

			// Check for win in rows.
			X = (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == 'X' );
			O = (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == 'O' );
			
		
			if (O || X) {
				if (i == 0) {
					Cell1.setBackground(Color.green);
					Cell2.setBackground(Color.green);
					Cell3.setBackground(Color.green);
				} else if (i == 1) {
					Cell4.setBackground(Color.green);
					Cell5.setBackground(Color.green);
					Cell6.setBackground(Color.green);
				} else {
					Cell7.setBackground(Color.green);
					Cell8.setBackground(Color.green);
					Cell9.setBackground(Color.green);
				}
				if (X)
					return 1;
				else if (O)
					return 2;
			}
			
			// Check for win in cols.
			X = (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == 'X' );
			O = (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == 'O' );
			
			
			if (X || O) {
				if (i == 0) {
					Cell1.setBackground(Color.green);
					Cell4.setBackground(Color.green);
					Cell7.setBackground(Color.green);
				} else if (i == 1) {
					Cell2.setBackground(Color.green);
					Cell5.setBackground(Color.green);
					Cell8.setBackground(Color.green);
				} else {
					Cell3.setBackground(Color.green);
					Cell6.setBackground(Color.green);
					Cell9.setBackground(Color.green);
				}
				if (X)
					return 1;
				else if (O)
					return 2;
			
			}
		}
		
		// Check for win in Diagonals.
		X = (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 'X' );
		O = (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 'O' );
		
		
		if (O || X ) {
			Cell1.setBackground(Color.green);
			Cell5.setBackground(Color.green);
			Cell9.setBackground(Color.green);
			if (X)
				return 1;
			else if (O)
				return 2;
		}
		

		// Check for win in Diagonals.
		X = (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[1][1] == 'X' );
		O = (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[1][1] == 'O' );
		
		if (O || X ) {
			Cell3.setBackground(Color.green);
			Cell5.setBackground(Color.green);
			Cell7.setBackground(Color.green);
		}
		if (X)
			return 1;
		else if (O)
			return 2;
		
		return 0;
		
	}
	
	static void nextState(int i, int j) {
		if (next == 0) 
			grid[i][j] = 'X';
		else 
			grid[i][j] = 'O';
			
		++cnt;
		
		int check = checkForTheWin();
			
		if (check == 1) {
			winEffect.start();
			JOptionPane.showMessageDialog(null, p1 + " Won", "Status", JOptionPane.INFORMATION_MESSAGE);
			winEffect.setMicrosecondPosition(0);
			winEffect.stop();
			++P1_Score;
			playerOne_LBL.setText(p1 + " ( X ) " + P1_Score);
		} else if (check == 2) {
			winEffect.start();
			JOptionPane.showMessageDialog(null, p2 + " Won", "Status", JOptionPane.INFORMATION_MESSAGE);
			winEffect.setMicrosecondPosition(0); // 
			winEffect.stop();
			++P2_Score; 
			playerTwo_LBL.setText(p2  + " ( O ) " + P2_Score); 
		} else {
			if (cnt == 9)
				JOptionPane.showMessageDialog(null, "Draw", "Status", JOptionPane.INFORMATION_MESSAGE);
			else
				next = ~next;
		}
			
		if (check != 0 || cnt == 9)
			endGame();
	}
	
	public static void main(String pp1, String pp2){
		p1 = pp1; 
		p2 = pp2;
		Game frame = new Game();
		frame.setVisible(true);
		Arrays.stream(grid).forEach(row -> Arrays.fill(row, '.')); // Fill array with {.};
		playerOne_LBL.setText(p1 + " ( X ) " + P1_Score);
		playerTwo_LBL.setText(p2  + " ( O ) " + P2_Score);
		
		File song1 = new File("Pen Clicking .wav");		
		File song2 = new File("Win.wav");
		AudioInputStream audioStream1 = null; // 
		AudioInputStream audioStream2 = null;
		
		BackGroundColor();
	
		try {
			audioStream1 = AudioSystem.getAudioInputStream(song1);
			audioStream2 = AudioSystem.getAudioInputStream(song2);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			soundEffect = AudioSystem.getClip();
			winEffect = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			soundEffect.open(audioStream1);
			winEffect.open(audioStream2);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Game() {
		setTitle("Tic Tac Toe");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 483);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(95, 158, 140));
		contentPane.setBackground(new Color(225, 222, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel board_PNL = new Panel();
		board_PNL.setBackground(new Color(17, 33, 58));
		board_PNL.setForeground(new Color(95, 185, 140));
		board_PNL.setBounds(0, 60, 537, 382);
		contentPane.add(board_PNL);
		board_PNL.setLayout(null);
		
		Cell1.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell1.setBounds(10, 11, 155, 103);
		board_PNL.add(Cell1);
		Cell2.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell2.setBounds(185, 11, 155, 103);
		board_PNL.add(Cell2);
		Cell4.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell4.setBounds(10, 137, 155, 103);
		board_PNL.add(Cell4);
		Cell7.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell7.setBounds(10, 268, 155, 103);
		board_PNL.add(Cell7);
		Cell3.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell3.setBounds(361, 11, 155, 103);
		board_PNL.add(Cell3);
		Cell5.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell5.setBounds(185, 137, 155, 103);
		board_PNL.add(Cell5);
		Cell8.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell8.setBounds(185, 268, 155, 103);
		board_PNL.add(Cell8);
		Cell6.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell6.setBounds(361, 137, 155, 103);
		board_PNL.add(Cell6);
		Cell9.setFont(new Font("Tahoma", Font.BOLD, 90));
		Cell9.setBounds(361, 268, 155, 103);
		board_PNL.add(Cell9);
		
		Panel scoreAndNames_PNL = new Panel();
		scoreAndNames_PNL.setLayout(null);
		scoreAndNames_PNL.setForeground(new Color(95, 185, 140));
		scoreAndNames_PNL.setBackground(new Color(17, 33, 58));
		scoreAndNames_PNL.setBounds(543, 60, 338, 207);
		contentPane.add(scoreAndNames_PNL);
		playerOne_LBL.setForeground(new Color(255, 255, 255));
		
		playerOne_LBL.setBounds(10, 45, 196, 52);
		scoreAndNames_PNL.add(playerOne_LBL);
		playerOne_LBL.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		playerTwo_LBL.setForeground(new Color(255, 255, 255));
		
		playerTwo_LBL.setBounds(10, 143, 209, 42);
		scoreAndNames_PNL.add(playerTwo_LBL);
		playerTwo_LBL.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		
		Cell1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[0][0] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell1.setText("X");
					else
						Cell1.setText("O");
					
					nextState(0, 0);
				}
			}
		});
		
		Cell2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[0][1] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell2.setText("X");
					else
						Cell2.setText("O");
					
					nextState(0, 1);
				}
			}
		});
		
		Cell3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[0][2] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell3.setText("X");
					else
						Cell3.setText("O");
					
					nextState(0, 2);
				}
			}
		});
		
		Cell4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[1][0] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell4.setText("X");
					else
						Cell4.setText("O");

					nextState(1, 0);
				}
			}
		});
		
		Cell7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[2][0] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell7.setText("X");
					else
						Cell7.setText("O");
					
					nextState(2, 0);
				}
			}
		});
		
		
		Cell5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[1][1] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell5.setText("X");
					else
						Cell5.setText("O");
					
					nextState(1, 1);
				}
			}
		});
		
		Cell8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[2][1] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell8.setText("X");
					else
						Cell8.setText("O");

					nextState(2, 1);
				}
			}
		});
		
		Cell6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[1][2] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell6.setText("X");
					else
						Cell6.setText("O");

					nextState(1, 2);
				}
			}
		});
		
		Cell9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grid[2][2] == '.') {
					soundEffect.start();
					soundEffect.setMicrosecondPosition(0);
					
					if (next == 0)
						Cell9.setText("X");
					else
						Cell9.setText("O");

					nextState(2, 2);
				}
			}
		});
		
		JLabel VS_LBL = new JLabel("VS");
		VS_LBL.setForeground(new Color(255, 255, 255));
		VS_LBL.setBackground(new Color(255, 255, 255));
		VS_LBL.setBounds(44, 108, 61, 35);
		scoreAndNames_PNL.add(VS_LBL);
		VS_LBL.setFont(new Font("Showcard Gothic", Font.BOLD, 23));
		
		Panel Score_PNL = new Panel();
		Score_PNL.setBounds(75, 10, 196, 35);
		scoreAndNames_PNL.add(Score_PNL);
		Score_PNL.setForeground(new Color(95, 185, 140));
		Score_PNL.setBackground(new Color(255, 255, 255));
		Score_PNL.setLayout(null);
		
		JLabel Score_LBL = new JLabel("SCORE");
		Score_LBL.setBounds(0, 0, 196, 31);
		Score_PNL.add(Score_LBL);
		Score_LBL.setBackground(new Color(255, 255, 255));
		Score_LBL.setHorizontalAlignment(SwingConstants.CENTER);
		Score_LBL.setForeground(new Color(0, 0, 0));
		Score_LBL.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		
		Panel Bottons_PNL = new Panel();
		Bottons_PNL.setLayout(null);
		Bottons_PNL.setForeground(new Color(95, 185, 140));
		Bottons_PNL.setBackground(new Color(17, 33, 58));
		Bottons_PNL.setBounds(543, 273, 338, 169);
		contentPane.add(Bottons_PNL);
		
		JButton Reset_BTN = new JButton("Reset");
		Reset_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		Reset_BTN.setBounds(25, 96, 141, 49);
		Bottons_PNL.add(Reset_BTN);
		Reset_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Reset Everything.
		        endGame();
		        P1_Score = P2_Score = 0;
		        playerOne_LBL.setText(p1 + " ( X ) " + P1_Score);
		        playerTwo_LBL.setText(p2 + " ( O ) " + P2_Score);
		        JOptionPane.showMessageDialog(Reset_BTN, "Game has been reset", "Status", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton Back_BTN = new JButton("BACK");
		Back_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		Back_BTN.setBounds(187, 96, 141, 49);
		Bottons_PNL.add(Back_BTN);
		Back_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        tictac.main(null);
		        tictac.Music.setMicrosecondPosition(0);
		        tictac.Music.start();
		        endGame();
		        dispose();
			}
		});
		
		JButton new_Game_BTN = new JButton("New Game");
		new_Game_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		new_Game_BTN.setBounds(45, 21, 238, 52);
		Bottons_PNL.add(new_Game_BTN);
		new_Game_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Names.main(null);
				dispose();
			}
		});
		
		Panel game_PNL = new Panel();
		game_PNL.setBounds(0, 0, 879, 54);
		contentPane.add(game_PNL);
		game_PNL.setLayout(null);
		game_PNL.setForeground(new Color(95, 185, 140));
		game_PNL.setBackground(new Color(17, 33, 58));
		
		JLabel tittle_LBL = new JLabel("TIC TAC TOE GAME");
		tittle_LBL.setForeground(new Color(255, 255, 255));
		tittle_LBL.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		tittle_LBL.setBounds(317, 11, 335, 34);
		game_PNL.add(tittle_LBL);
	}
	
	static void BackGroundColor() {
		Cell1.setBackground(Color.white);
		Cell2.setBackground(Color.white);
		Cell3.setBackground(Color.white);
		Cell4.setBackground(Color.white);
		Cell5.setBackground(Color.white);
		Cell6.setBackground(Color.white);
		Cell7.setBackground(Color.white);
		Cell8.setBackground(Color.white);
		Cell9.setBackground(Color.white);
	}
	
	static void endGame() {
		next = cnt = 0;
		
		Cell1.setText("");
        Cell1.setEnabled(true);
        Cell2.setText("");
        Cell2.setEnabled(true);
        Cell3.setText("");
        Cell3.setEnabled(true);
        Cell4.setText("");
        Cell4.setEnabled(true);
        Cell5.setText("");
        Cell5.setEnabled(true);
        Cell6.setText("");
        Cell6.setEnabled(true);
        Cell7.setText("");
        Cell7.setEnabled(true);
        Cell8.setText("");
        Cell8.setEnabled(true);
        Cell9.setText("");
        Cell9.setEnabled(true);
        
        BackGroundColor();
        
		Arrays.stream(grid).forEach(row -> Arrays.fill(row, '.'));
	}
}