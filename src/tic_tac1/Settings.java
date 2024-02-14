package tic_tac1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.sound.sampled.FloatControl;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;

public class Settings extends JFrame implements ActionListener {

	private JFrame frmSettings;
	
	static String audioState = "";
	static JComboBox volumeSlider;

	
	public static void main(String []args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frmSettings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSettings = new JFrame();
		frmSettings.getContentPane().setBackground(new Color(17, 33, 58));
		frmSettings.setIconImage(Toolkit.getDefaultToolkit().getImage("setting icon.png"));
		frmSettings.setTitle("Settings");
		frmSettings.setBounds(100, 100, 450, 300);
		frmSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSettings.getContentPane().setLayout(null);
		
		JLabel stateOfAudio = new JLabel("Audio");
		stateOfAudio.setForeground(new Color(255, 255, 255));
		stateOfAudio.setBackground(new Color(255, 255, 255));
		stateOfAudio.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		stateOfAudio.setBounds(48, 69, 99, 36);
		frmSettings.getContentPane().add(stateOfAudio);
		
		JLabel Volume = new JLabel("Volume");
		Volume.setForeground(new Color(255, 255, 255));
		Volume.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		Volume.setBounds(48, 131, 135, 42);
		frmSettings.getContentPane().add(Volume);
		
		JButton audio_BTN = new JButton((audioState.equals("") ? "ON" : audioState));
		audio_BTN.setBackground(new Color(225, 222, 83));
		audio_BTN.setForeground(new Color(0, 0, 0));
		audio_BTN.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		audio_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (audio_BTN.getText().equals("ON")) {
					tictac.Music.stop();
					audioState = "OFF";
				} else {
					tictac.Music.start();
					tictac.Music.loop(tictac.Music.LOOP_CONTINUOUSLY); // Repeated music.
					audioState = "ON";
				}
				
				audio_BTN.setText(audioState);
			}
		});
		
		audio_BTN.setBounds(231, 70, 107, 35);
		frmSettings.getContentPane().add(audio_BTN);
		
		volumeSlider = new JComboBox();
		volumeSlider.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
		volumeSlider.setModel(new DefaultComboBoxModel(new String[] {"1.0", "0.9", "0.8", "0.7", "0.6", "0.5", "0.4", "0.3", "0.2", "0.1", "0.0"}));
		volumeSlider.setBounds(253, 146, 58, 22);
		frmSettings.getContentPane().add(volumeSlider);
		
		volumeSlider.addActionListener(this);
		
		tictac.volume = (FloatControl) tictac.Music.getControl(FloatControl.Type.MASTER_GAIN);
	}

	public void actionPerformed(ActionEvent e) {
		String choosen = (String) volumeSlider.getSelectedItem();
		tictac.percent = Float.parseFloat(choosen);
		
		tictac.dB = (float) (Math.log(tictac.percent) / Math.log(10.0) * 20.0);
	    tictac.volume.setValue(tictac.dB);
	}
}
