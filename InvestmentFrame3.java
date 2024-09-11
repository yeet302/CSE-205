import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class InvestmentFrame3 extends JFrame {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton addButton;
	private JTextArea resultArea;

	private double balance;

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 250;
	private static final double INTEREST_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;

	public InvestmentFrame3() {
		balance = INITIAL_BALANCE;

		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	class AddInterestListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			resultArea.append(String.format("Balance: $%8.2f\n", balance));
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

		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		resultArea.setEditable(false);
		scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);
		
		add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new InvestmentFrame3();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Investment Frame III");
		frame.setVisible(true);
	}
}
