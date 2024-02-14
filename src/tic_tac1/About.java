package tic_tac1;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class About extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		getContentPane().setBackground(new Color(17, 33, 58));
		setTitle("About Team");
		setBounds(100, 100, 429, 295);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("A Tic Tac Toe game created by:  M TEAM");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 401, 79);
		getContentPane().add(lblNewLabel);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(242, 119, 119));
		cancelButton.setBounds(320, 222, 83, 23);
		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.this.dispose();
			}
		});
		
		cancelButton.setActionCommand("Cancel");
	}
}