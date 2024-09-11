import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.util.Scanner;

public class FrameBuilder {
	public static void main(String[] args) {
		int FRAME_WIDTH = 300;
		int FRAME_HEIGHT = 400;

		Scanner in = new Scanner(System.in);
		char c;
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Add Components");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		do {
			System.out.print("Select\n   1) JLabel\n   2) JButton\n   3) JTextField\n   4) JPasswordField\n   5) JTextArea\n   D) Done\n");
			c = in.next().toUpperCase().charAt(0);
			switch (c) {
			case '1' : panel.add(new JLabel("JLabel"));					break;
			case '2' : panel.add(new JButton("JButton"));				break;
			case '3' : panel.add(new JTextField("JTextField"));			break;
			case '4' : panel.add(new JPasswordField("JPasswordField"));	break;
			case '5' : panel.add(new JTextArea("JTextArea"));			break;
			}
//			frame.add(panel);
			frame.setVisible(true);
		} while (c != 'D');
		
		frame.setVisible(false);
		in.close();
	}
}
