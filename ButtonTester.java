import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonTester extends JFrame {
	private JButton button;
	private static final int FRAME_WIDTH  = 300;
	private static final int FRAME_HEIGHT = 400;
	
	public ButtonTester() {
		button = new JButton("Click me!");
		button.addActionListener(new ClickListener());
		JPanel panel = new JPanel();		
		panel.add(button);
		add(panel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public static void main(String[] args) {
		JFrame frame = new ButtonTester();
		frame.setTitle("Button Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible (true);
	}
}
