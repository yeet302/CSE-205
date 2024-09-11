import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentFrame2 extends JFrame {
	private JPanel panel;
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton addButton;
	private JLabel resultLabel;

	private double balance;

	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 100;
	private static final double INTEREST_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	private static final int FIELD_WIDTH = 10;

	public InvestmentFrame2() {
		balance = INITIAL_BALANCE;

		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	class AddInterestListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			resultLabel.setText(String.format("Balance: $%.2f", balance));
		}
	}

	private void createComponents() {
		panel = new JPanel();

		rateLabel = new JLabel("Interest Rate");
		panel.add(rateLabel);

		rateField = new JTextField("5.0", FIELD_WIDTH);
		panel.add(rateField);

		addButton = new JButton("Add Interest");
		addButton.addActionListener(new AddInterestListener());
		panel.add(addButton);

		resultLabel = new JLabel(String.format("Balance: $%.2f", balance));
		panel.add(resultLabel);

		add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new InvestmentFrame2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Investment Frame II");
		frame.setVisible(true);
	}
}
