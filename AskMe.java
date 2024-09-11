import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AskMe {
	private static JLabel resultText;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 100);
		frame.setTitle("Ask me a Question");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton askQuestionButton = new JButton("Get New Value");
		askQuestionButton.addActionListener(new QuestionListener());
		panel.add(askQuestionButton);
		resultText = new JLabel("** No value **");
		panel.add(resultText);
		frame.add(panel);	
		frame.setVisible(true);
	}
	
	static private class QuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String newValue = JOptionPane.showInputDialog("Whats the value?");
			if (newValue != null) 
				resultText.setText(newValue);
		}
	}
}
