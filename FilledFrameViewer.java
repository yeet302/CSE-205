import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrameViewer {

	public static void main(String[] args) {
		final int FRAME_WIDTH  = 300;
		final int FRAME_HEIGHT = 400;
		
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Click me!");
		JLabel label = new JLabel("Hello, World!");
		
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("A Frame with Two Components");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		frame.setVisible (true);
	}
}
