package tic_tac1;

import java.awt.EventQueue;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class JFrame3 extends JFrame {
	private JPanel contentPane;

	static String p1 = "First Player", p2 = "Second Player";
	
	public static void main(String[] args) {
		String pp1 = p1, pp2 = p2;
					JFrame3 frame = new JFrame3();
					frame.setVisible(true);
				
	}
	public JFrame3() {
		setTitle("Tic Tac Toe");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohamed sabry\\Desktop\\27783897.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 491);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(95, 158, 140));
		contentPane.setBackground(new Color(95, 158, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(96, 170, 140));
		panel.setForeground(new Color(95, 185, 140));
		panel.setBounds(0, 60, 526, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttons1 = new JButton("");
		buttons1.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons1.setBounds(10, 11, 155, 103);
		panel.add(buttons1);
		
		JButton buttons2 = new JButton("");
		buttons2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons2.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons2.setBounds(185, 11, 155, 103);
		panel.add(buttons2);
		
		JButton buttons4 = new JButton("");
		buttons4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons4.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons4.setBounds(10, 137, 155, 103);
		panel.add(buttons4);
		
		JButton buttons7 = new JButton("");
		buttons7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons7.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons7.setBounds(10, 268, 155, 103);
		panel.add(buttons7);
		
		JButton buttons3 = new JButton("");
		buttons3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttons3.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons3.setBounds(361, 11, 155, 103);
		panel.add(buttons3);
		
		JButton buttons5 = new JButton("");
		buttons5.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons5.setBounds(185, 137, 155, 103);
		panel.add(buttons5);
		
		JButton buttons8 = new JButton("");
		buttons8.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons8.setBounds(185, 268, 155, 103);
		panel.add(buttons8);
		
		JButton buttons6 = new JButton("");
		buttons6.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons6.setBounds(361, 137, 155, 103);
		panel.add(buttons6);
		
		JButton buttons9 = new JButton("");
		buttons9.setFont(new Font("Tahoma", Font.BOLD, 90));
		buttons9.setBounds(361, 268, 155, 103);
		panel.add(buttons9);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(95, 185, 140));
		panel_1.setBackground(new Color(96, 170, 140));
		panel_1.setBounds(543, 60, 338, 207);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(p2 + " : (O)");
		lblNewLabel_1.setBounds(10, 143, 209, 42);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		
		JLabel lblNewLabel_1_2 = new JLabel("VS");
		lblNewLabel_1_2.setBounds(44, 108, 61, 35);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Showcard Gothic", Font.BOLD, 23));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(212, 153, 116, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(212, 58, 116, 29);
		panel_1.add(lblNewLabel_2_1);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBounds(75, 10, 196, 42);
		panel_1.add(panel_1_3);
		panel_1_3.setForeground(new Color(95, 185, 140));
		panel_1_3.setBackground(new Color(100, 180, 150));
		panel_1_3.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("SCORE");
		panel_1_3.add(lblNewLabel_1_1_2, "name_224104478005600");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		
		JLabel lblNewLabel_1_1 = new JLabel(p1 + " : (X)");
		lblNewLabel_1_1.setBounds(10, 45, 196, 52);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(new Color(95, 185, 140));
		panel_1_1.setBackground(new Color(96, 170, 140));
		panel_1_1.setBounds(543, 286, 338, 156);
		contentPane.add(panel_1_1);
		
		JButton btnExit = new JButton("Re-Set");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // تغير قيم كل ال buttons=" "
		        buttons1.setText("");
		        buttons1.setEnabled(true);
		        buttons2.setText("");
		        buttons2.setEnabled(true);
		        buttons3.setText("");
		        buttons3.setEnabled(true);
		        buttons4.setText("");
		        buttons4.setEnabled(true);
		        buttons5.setText("");
		        buttons5.setEnabled(true);
		        buttons6.setText("");
		        buttons6.setEnabled(true);
		        buttons7.setText("");
		        buttons7.setEnabled(true);
		        buttons8.setText("");
		        buttons8.setEnabled(true);
		        buttons9.setText("");
		        buttons9.setEnabled(true);
		        //تغير قيم lables =0
		        lblNewLabel.setText("0");
		        lblNewLabel_2.setText("0");
		        JOptionPane.showMessageDialog(btnExit, "reset succes");
			}
		});
		btnExit.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnExit.setBounds(25, 96, 141, 49);
		panel_1_1.add(btnExit);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnNewButton.setBounds(187, 96, 141, 49);
		panel_1_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login newGame = new Login();
				newGame.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		btnNewButton_1.setBounds(45, 21, 238, 52);
		panel_1_1.add(btnNewButton_1);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBounds(10, 10, 869, 34);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		panel_1_2.setForeground(new Color(95, 185, 140));
		panel_1_2.setBackground(new Color(96, 170, 140));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TIC TAC TOE GAME");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(324, 0, 335, 34);
		panel_1_2.add(lblNewLabel_1_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        tictac tictac1 = new tictac();
		        tictac1.main(null);
		        dispose();
			}
		});
		
		
	}
}

