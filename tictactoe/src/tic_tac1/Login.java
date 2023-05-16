package tic_tac1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String PlayerOne, PlayerTwo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		frame.getContentPane().setBackground(new Color(95, 158, 140));
		frame.getContentPane().setForeground(new Color(95, 158, 140));
		
		JLabel lblNewLabel = new JLabel("Enter player1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 47, 122, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPlayer = new JLabel("Enter player2");
		lblEnterPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterPlayer.setBounds(36, 115, 122, 25);
		frame.getContentPane().add(lblEnterPlayer);
		
		textField = new JTextField();
		textField.setBounds(168, 51, 158, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(168, 115, 158, 25);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(155, 193, 98, 31);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	    			JFrame3 newFrame = new JFrame3();
	    			if(textField.getText() != "")
	    				newFrame.p1 = textField.getText();
	    			if(textField_1.getText() != "")
	    				newFrame.p2 = textField_1.getText();
	    			newFrame.main(null);				 
	    			frame.dispose();
	            }
	        });
	}
}
