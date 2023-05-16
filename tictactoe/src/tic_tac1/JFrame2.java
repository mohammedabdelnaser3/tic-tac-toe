package tic_tac1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class JFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtEee;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame2() {
		setTitle("Tic Tac Toe");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohamed sabry\\Desktop\\566294.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 314);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" PLAYER1");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(87, 78, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEee = new JTextField();
		txtEee.setBounds(87, 103, 86, 20);
		contentPane.add(txtEee);
		txtEee.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 103, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLAYER2");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(263, 78, 109, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmTicTacToe JFr=new frmTicTacToe();
				JFr.setVisible(true);
				JFrame2.this.dispose();*/
				//هنا المشكلة
			}
		});
		btnNewButton.setBounds(177, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("ENTER YOUR NAME");
		lblNewLabel_1_2.setFont(new Font("Showcard Gothic", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(154, 27, 159, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNext = new JButton("PLAY");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame3 JFr=new JFrame3();
				JFr.setVisible(true);
				JFrame2.this.dispose();
			}
		});
		btnNext.setBounds(177, 168, 89, 23);
		contentPane.add(btnNext);
	}
}
