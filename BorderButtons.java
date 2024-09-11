import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import java.util.Scanner;

public class BorderButtons {
	public static void main(String[] args) {
		int FRAME_WIDTH = 300;
		int FRAME_HEIGHT = 200;

		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Border Buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("North"), BorderLayout.NORTH);
		panel.add(new JButton("East"), BorderLayout.EAST);
		panel.add(new JButton("West"), BorderLayout.WEST);
		panel.add(new JButton("Center"), BorderLayout.CENTER);
		panel.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
