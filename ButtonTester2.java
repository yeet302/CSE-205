import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonTester2 extends JFrame {
	private JButton button;
	private JLabel countClick;
	private int numOfClick=0;
	private static final int FRAME_WIDTH  = 300;
	private static final int FRAME_HEIGHT = 400;

	private class ClickListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Frame size is " + FRAME_WIDTH + " by " + FRAME_HEIGHT);
			System.out.println("Button is clicked");
			numOfClick++;
			countClick.setText(String.format("Button Clicked: %d", numOfClick));
			
		}
	}

	public ButtonTester2() {
		button = new JButton("Click me!");
		button.addActionListener(new ClickListener());
		countClick = new JLabel("");
		JPanel panel = new JPanel();		
		panel.add(button);
		panel.add(countClick);
		add(panel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public static void main(String[] args) {
		JFrame frame = new ButtonTester2();
		frame.setTitle("Button Tester 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible (true);
	}
}
