package tic_tac1;
import javax.swing.ImageIcon;
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
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sound.sampled.*;

class tictac {
	private JFrame frmTicTacToe;

	static protected Clip Music;
	static protected double percent;
	static protected FloatControl volume;
	static protected float dB;
	
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
		
		File song = new File("mainMenu.wav");
		AudioInputStream audioStream = null;
		
		try {
			audioStream = AudioSystem.getAudioInputStream(song);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Music = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Music.open(audioStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Music.loop(Music.LOOP_CONTINUOUSLY); // REPEAT SONG
		
		volume = (FloatControl) Music.getControl(FloatControl.Type.MASTER_GAIN);	//ACCESS TO MUSIC
	    // set the percent (between 0.0 and 1.0)
	    double percent = 1.0;   
	    float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0); // CONVERTING 
	    volume.setValue(dB);  // 
	}

	public tictac() {
		initialize();
	}
	
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.getContentPane().setForeground(Color.BLACK);
		frmTicTacToe.getContentPane().setBackground(new Color(255, 255, 255));
		frmTicTacToe.setFont(new Font("Dialog", Font.BOLD, 12));
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frmTicTacToe.setBounds(100, 100, 628, 430);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Play_BTN = new JButton("PLAY");
		Play_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		Play_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Names.main(null);
				frmTicTacToe.dispose();
			}
		});
		
		Play_BTN.setBounds(227, 106, 169, 43);
		Play_BTN.setBackground(new Color(138, 198, 197));
		
		frmTicTacToe.getContentPane().setLayout(null);
		frmTicTacToe.getContentPane().add(Play_BTN);
		
		JButton About_BTN = new JButton("About");
		About_BTN.setBackground(new Color(138, 198, 197));
		About_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		About_BTN.setBounds(227, 235, 169, 43);
		About_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About JFr = new About();
				JFr.setVisible(true);
			}
		});
		
		frmTicTacToe.getContentPane().add(About_BTN);
		
		JButton exit_BTN = new JButton("Exit");
		exit_BTN.setBackground(new Color(242, 119, 119));
		exit_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		exit_BTN.setIcon(null);
		exit_BTN.setBounds(227, 300, 169, 43);
		exit_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(exit_BTN, "Confirm if you want to exit","Tic Tac Toe",JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_NO_OPTION )
					System.exit(0);
			}
		});
		
		frmTicTacToe.getContentPane().add(exit_BTN);
		
		JLabel welcome_LBL = new JLabel("Welcome To Tic Tac Toe Game");
		welcome_LBL.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_LBL.setForeground(new Color(255, 255, 255));
		welcome_LBL.setBackground(new Color(255, 255, 255));
		welcome_LBL.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		welcome_LBL.setBounds(10, 33, 578, 62);
		frmTicTacToe.getContentPane().add(welcome_LBL);
		
		JButton settings_BTN = new JButton("Settings");
		settings_BTN.setBackground(new Color(138, 198, 197));
		settings_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings toSettings = new Settings();
				toSettings.main(null);
			}
		});
		
		settings_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		settings_BTN.setBounds(227, 171, 169, 43);
		frmTicTacToe.getContentPane().add(settings_BTN);
		
		JLabel backGround_LBL = new JLabel("");
		backGround_LBL.setIcon(new ImageIcon("wallpeper.jpg"));
		backGround_LBL.setBounds(0, 0, 612, 391);
		frmTicTacToe.getContentPane().add(backGround_LBL);
	}

	public void setVisible(boolean visible) {
		frmTicTacToe.setVisible(visible);
	}
}