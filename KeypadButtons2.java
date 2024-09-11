import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class KeypadButtons2 extends JFrame {
	private static int FRAME_WIDTH = 150;
	private static int FRAME_HEIGHT = 160;

	private boolean dpSeen = false;

	JFrame frame;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonDP;
	JTextField digitField;

	public KeypadButtons2() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Keypad");

		digitField = new JTextField("");
		digitField.setHorizontalAlignment(JTextField.RIGHT);
		digitField.setEditable(false);

		JButton button0 = new JButton("0");
		button0.addActionListener(new buttonListener('0'));

		JButton button1 = new JButton("1");
		button1.addActionListener(new buttonListener('1'));

		JButton button2 = new JButton("2");
		button2.addActionListener(new buttonListener('2'));

		JButton button3 = new JButton("3");
		button3.addActionListener(new buttonListener('3'));

		JButton button4 = new JButton("4");
		button4.addActionListener(new buttonListener('4'));

		JButton button5 = new JButton("5");
		button5.addActionListener(new buttonListener('5'));

		JButton button6 = new JButton("6");
		button6.addActionListener(new buttonListener('6'));

		JButton button7 = new JButton("7");
		button7.addActionListener(new buttonListener('7'));

		JButton button8 = new JButton("8");
		button8.addActionListener(new buttonListener('8'));

		JButton button9 = new JButton("9");
		button9.addActionListener(new buttonListener('9'));

		JButton buttonDP = new JButton(".");
		buttonDP.addActionListener(new buttonListener('.'));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel numbersPanel = new JPanel();
		numbersPanel.setLayout(new BorderLayout());

		JPanel rightButtonsPanel = new JPanel();
		rightButtonsPanel.setLayout(new GridLayout(4, 1));

		JPanel leftButtonsPanel = new JPanel();
		leftButtonsPanel.setLayout(new BorderLayout());

		JPanel sixButtonPanel = new JPanel();
		sixButtonPanel.setLayout(new GridLayout(3, 2));

		panel.add(digitField, BorderLayout.NORTH);
		panel.add(numbersPanel, BorderLayout.CENTER);

		numbersPanel.add(leftButtonsPanel, BorderLayout.CENTER);
		numbersPanel.add(rightButtonsPanel, BorderLayout.EAST);

		leftButtonsPanel.add(sixButtonPanel, BorderLayout.CENTER);
		leftButtonsPanel.add(button0, BorderLayout.SOUTH);

		rightButtonsPanel.add(button3);
		rightButtonsPanel.add(button6);
		rightButtonsPanel.add(button9);
		rightButtonsPanel.add(buttonDP);

		sixButtonPanel.add(button1);
		sixButtonPanel.add(button2);
		sixButtonPanel.add(button4);
		sixButtonPanel.add(button5);
		sixButtonPanel.add(button7);
		sixButtonPanel.add(button8);

		add(panel);
	}

	class buttonListener implements ActionListener {
		private char c;

		public buttonListener(char c) {
			this.c = c;
		}

		public void actionPerformed(ActionEvent event) {
			if (dpSeen && c != '.' || !dpSeen) {
				digitField.setText(digitField.getText() + c);
			}
			
			if (c == '.') {
				dpSeen = true;
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new KeypadButtons2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
