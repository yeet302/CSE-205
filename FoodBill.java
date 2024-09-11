import java.util.Formatter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FoodBill extends JFrame {
	
	private final int FRAME_WIDTH = 400;
	private final int FRAME_HEIGHT = 700;
		
	private JPanel panel;
	private JFrame frame;
	private JScrollPane scrollPane;
	
	private double taxRate = 5.6;
	private double tipRate = 15;
	private double totalTax = 0.0;
	private double totalTip = 0.0;
	private double totalWTax = 0.0;
	private double totalWTipnTax = 0.0;
	
	private JLabel taxLabel;
	private JTextField taxField;
	private JLabel tipLabel;
	private JTextField tipField;
	private JButton chipButton;
	private JButton picklesButton;
	private JButton baconButton;
	private JButton soupButton;
	private JButton cakeButton;
	private JButton totalButton;
	private JButton clearButton;
	private JTextArea resultArea;
	private final double chipPrice = 10.0;
	private final double picklesPrice = 3.0;
	private final double baconPrice = 7.0;
	private final double soupPrice = 6.0;
	private final double cakePrice = 12.0;
	private final int rows = 30;
	private final int columns = 48	;
	private double balance = 0.0;
	private boolean doneTotal = false; 
	
	public FoodBill() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Restaurant Bill");
		
		taxLabel = new JLabel("Tax Rate");
		panel.add(taxLabel);
		
		taxField = new JTextField("5.6");
		panel.add(taxField);
		
		JLabel percent = new JLabel("%");	
		panel.add(percent);
		
		tipLabel = new JLabel("Tip");
		panel.add(tipLabel);
		
		tipField = new JTextField("15");
		panel.add(tipField);		
		
		JLabel percent2 = new JLabel("%");
		panel.add(percent2);
		
		chipButton = new JButton("C&S");
		chipButton.addActionListener(new CSListener());
		panel.add(chipButton);
		
		picklesButton = new JButton("Pickles");
		picklesButton.addActionListener(new PickleListener());
		panel.add(picklesButton);
		
		baconButton = new JButton("Bacon");
		baconButton.addActionListener(new BaconListener());
		panel.add(baconButton);
		
		soupButton = new JButton("Soup");
		soupButton.addActionListener(new SoupListener());
		panel.add(soupButton);
		
		cakeButton = new JButton("Cake");
		cakeButton.addActionListener(new CakeListener());
		panel.add(cakeButton);
		
		totalButton = new JButton("Total");
		totalButton.addActionListener(new TotalListener());
		panel.add(totalButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearListener());
		panel.add(clearButton);		
		
		resultArea = new JTextArea(rows,columns);
		resultArea.setEditable(false);
		resultArea.setBorder(BorderFactory.createLineBorder(Color.black));
		resultArea.setText("");
		Font font = new Font("Monospaced",Font.BOLD,12);
		resultArea.setFont(font);
		panel.add(resultArea);
		scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);	
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	class PickleListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				balance += picklesPrice;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Pickles",picklesPrice));
			}
		}	
	}	
	class CSListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				balance += chipPrice;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Chips & Salsa",chipPrice));

			}
		}	
	}
	class BaconListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				balance += baconPrice;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Bacons",baconPrice));
			}
		}	
	}
	class SoupListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				balance += soupPrice;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Broccoli & Mushroom Soup",soupPrice));
			}
		}	
	}
	class CakeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				balance += cakePrice;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Chocolate Lava Cake",cakePrice));			
			}
		}	
	}
	class TotalListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				taxRate = Double.parseDouble(taxField.getText());					
				tipRate = Double.parseDouble(tipField.getText());	
				resultArea.append(String.format("%-24s"+"%14s\n","------------------------","-------------"));
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Pretax Total", balance));
				totalTax = balance * taxRate/100;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Tax", totalTax));
				resultArea.append(String.format("%-24s"+"%14s\n","------------------------","-------------"));
				totalWTax = balance + totalTax;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Total w/Tax", totalWTax));
				totalTip = balance * tipRate/100;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Tip",totalTip));
				resultArea.append(String.format("%-24s"+"%14s\n","------------------------","-------------"));
				totalWTipnTax = totalWTax + totalTip;
				resultArea.append(String.format("%-25s"+"$%11.2f\n","Total",totalWTipnTax));
				doneTotal = true;
			}
		}	
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			resultArea.setText("");
			balance = 0.0;
			totalTax = 0.0;		
			totalWTax = 0.0;
			totalWTipnTax = 0.0;
			totalTip = 0.0;
			doneTotal = false;
		}	
	}
	
	public static void main(String[] args) {
		new FoodBill();
	}
}
