package tic_tac1;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


class tictac {

	private JFrame frmTicTacToe;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tictac window = new tictac();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public tictac() {
		initialize();
	}
	


	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.getContentPane().setForeground(Color.BLACK);
		frmTicTacToe.getContentPane().setBackground(new Color(96, 170, 140));
		frmTicTacToe.setFont(new Font("Dialog", Font.BOLD, 12));
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohamed sabry\\Desktop\\27783897.jpg"));
		frmTicTacToe.setBounds(100, 100, 628, 430);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton1 = new JButton("PLAY");
		btnNewButton1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login start = new Login();
				start.main(null);
				frmTicTacToe.dispose();
				

				
			}
		});
		btnNewButton1.setBounds(227, 112, 141, 43);
		btnNewButton1.setBackground(new Color(240, 240, 240));
		
		frmTicTacToe.getContentPane().setLayout(null);
		frmTicTacToe.getContentPane().add(btnNewButton1);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnAbout.setBounds(227, 193, 141, 43);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About JFr=new About();
				JFr.setVisible(true);
				
			}
		});
		frmTicTacToe.getContentPane().add(btnAbout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnExit.setIcon(null);
		btnExit.setBounds(227, 279, 141, 43);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String[] options = { "YES", "NO"};
				 
				if(JOptionPane.showOptionDialog(null, "Do you want to exit ?", "EXIT", 
                        0, 2, null, options, options[0]) == 0)
				System.exit(0);
			}
		});
		frmTicTacToe.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Tic Tac Toe Game");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(174, 11, 578, 62);
		frmTicTacToe.getContentPane().add(lblNewLabel_1);
	}


	public void setVisible(boolean b) {
		//بقيت button back علشان يتعدل
		tictac game = new tictac();
		game.setVisible(true);

		
	}


	
}




