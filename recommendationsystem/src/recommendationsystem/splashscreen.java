package recommendationsystem;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
public class splashscreen extends JFrame {
	public static JProgressBar progressBar;
	public splashscreen() {
		getContentPane().setBackground(Color.BLACK);
		
		getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(37, 391, 515, 28);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Loading");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ariel", Font.BOLD, 40));
		lblNewLabel.setBounds(217, 146, 243, 98);
		getContentPane().add(lblNewLabel);
		setSize(600,500);
	}
}
