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

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mohamed sabry\\Desktop\\27783897.jpg"));
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("About Team");
		setBounds(100, 100, 417, 279);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						About.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				buttonPane.add(contentPanel);
				contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPanel.setLayout(null);
			}
		}
		
		JLabel lblNewLabel = new JLabel("write any thing about team");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}
}
