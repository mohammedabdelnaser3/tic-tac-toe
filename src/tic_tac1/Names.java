package tic_tac1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Names {
	private JFrame frmPlayersNames;
	private JTextField One_TXTFLD;
	private JTextField Two_TXTFLD;
	protected String PlayerOne, PlayerTwo;
	protected int P1_Score, P2_Score;
	static tictac use = new tictac();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Names window = new Names();
					window.frmPlayersNames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Names() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmPlayersNames = new JFrame();
		frmPlayersNames.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frmPlayersNames.setTitle("Players Names");
		frmPlayersNames.setBounds(100, 100, 450, 300);
		frmPlayersNames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayersNames.getContentPane().setLayout(null);
		
	
		frmPlayersNames.getContentPane().setBackground(new Color(17, 33, 58));
		frmPlayersNames.getContentPane().setForeground(new Color(95, 158, 140));
		
		JLabel lblNewLabel = new JLabel("First Player's Name: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 47, 177, 25);
		frmPlayersNames.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPlayer = new JLabel("Second Player's Name:");
		lblEnterPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPlayer.setForeground(new Color(255, 255, 255));
		lblEnterPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterPlayer.setBounds(10, 115, 177, 25);
		frmPlayersNames.getContentPane().add(lblEnterPlayer);
		
		One_TXTFLD = new JTextField();
		One_TXTFLD.setBounds(198, 49, 158, 25);
		frmPlayersNames.getContentPane().add(One_TXTFLD);
		One_TXTFLD.setColumns(10);
		
		Two_TXTFLD = new JTextField();
		Two_TXTFLD.setColumns(10);
		Two_TXTFLD.setBounds(198, 117, 158, 25);
		frmPlayersNames.getContentPane().add(Two_TXTFLD);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBackground(new Color(225, 222, 83));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(155, 193, 98, 31);
		frmPlayersNames.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(17, 33, 58));
		lblNewLabel_1.setForeground(new Color(17, 33, 58));
		lblNewLabel_1.setIcon(new ImageIcon("wallpeper.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frmPlayersNames.getContentPane().add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					String check1 = One_TXTFLD.getText();
					String check2 = Two_TXTFLD.getText();
					
					if (check1.length() > 0 && check1.length() <= 11 && check2.length() > 0 && check2.length() <= 11) {
		            	use.Music.stop();
		            	P1_Score = P2_Score = 0;
		            	frmPlayersNames.dispose();
//		            	Game board = new Game();
						Game.main(check1, check2);
					} else
					JOptionPane.showMessageDialog(null, "Name must contain at least one character and at most 11", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	    });
	}
}
