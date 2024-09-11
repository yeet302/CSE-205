import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EnhancedFoodBillFrame extends JFrame {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 800;
	private final double AZTAXRATE = 5.6;
	private final double CATAXRATE = 7.25;
	private final double COTAXRATE = 2.9;
	private final double NMTAXRATE = 5.125;
	private final double NVTAXRATE = 6.85;
	
	private JLabel taxRateLabel;
	private JRadioButton AZButton;
	private JRadioButton CAButton;
	private JRadioButton COButton;
	private JRadioButton NMButton;
	private JRadioButton NVButton;
	private JTextField taxRateField;
	private JTextField tipRateField;
	private JSlider tipSlider;
	private JLabel percent;
	private JLabel tipLabel;
	
	private int tipRate = 15;
	private double taxRate;
	private double totalTax = 0.0;
	private double totalTip = 0.0;
	private double totalWTax = 0.0;
	private double totalWTipnTax = 0.0;	
	private double balance = 0.0;
	private boolean doneTotal = false; 
	
	private JLabel appetizer;
	private JLabel mainDish;
	private JLabel desert;
	private JButton CS;
	private JButton bacon;
	private JButton chCake;
	private JButton pickles;
	private JButton soup;
	private JButton iceCream;
	private JButton eggRoll;
	private JButton ribs;
	private JButton choCake;
	private JButton threeDip;
	private JButton ribeye;
	private JButton cookie;
	private JButton queso;
	private JButton pasta;
	private JButton trio;
	private final double CSPRICE = 3.50;
	private final double BACONPRICE = 2.50;
	private final double CHCAKEPRICE = 7.25;
	private final double PICKLESPRICE = 1.75;
	private final double SOUPPRICE = 5.50;
	private final double ICECREAMPRICE = 6.80;
	private final double EGGROLLPRICE = 7.20;
	private final double RIBSPRICE = 16.20;
	private final double CHOCAKEPRICE = 7.80;
	private final double THREEDIPPRICE = 1.50;
	private final double RIBEYEPRICE = 22.50;
	private final double COOKIEPRICE = 3.75;
	private final double QUESOPRICE = 2.75;
	private final double PASTAPRICE = 12.20;
	private final double TRIOPRICE = 6.90;
	private JTextArea resultArea;
	private JScrollPane scrollPane;
		
	private JLabel currentTotal;
	private JLabel currentTotalwTax;
	private JLabel currentTotalwTip;
	private JButton totalButton;
	private String currentServer;
	
	public EnhancedFoodBillFrame() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createServerMenu());		
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2,1));
		topPanel.add(taxRatePanel());
		topPanel.add(tipRatePanel());
		JPanel leftAlignPanel = new JPanel();
		leftAlignPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		leftAlignPanel.add(topPanel);
		
		controlPanel.add(leftAlignPanel,BorderLayout.NORTH);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,2));
		middlePanel.add(addFoodButtons());
		middlePanel.add(addTextArea());
		controlPanel.add(middlePanel,BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(4,1));
		addLabels();
		bottomPanel.add(currentTotal);
		bottomPanel.add(currentTotalwTax);
		bottomPanel.add(currentTotalwTip);
		totalButton = new JButton("Total");
		totalButton.addActionListener(new TotalListener());
		bottomPanel.add(totalButton);
		controlPanel.add(bottomPanel,BorderLayout.SOUTH);
		
		add(controlPanel);
	}
	public JPanel tipRatePanel() {
		ChangeListener listener = new TipListener();
		tipLabel = new JLabel("Tip");
		percent = new JLabel("%");
		tipSlider = new JSlider(0,35,15);	
		tipRateField = new JTextField(String.format("%2d", tipRate));
		tipRateField.setEditable(false);
		tipSlider.addChangeListener(listener);
		JPanel controlPanel = new JPanel();
		controlPanel.add(tipLabel);
		controlPanel.add(tipSlider);
		controlPanel.add(tipRateField);
		controlPanel.add(percent);
		return controlPanel;
	}
	class TipListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			setTipRate();
		}
	}

	public void setTipRate() {
		tipRate = tipSlider.getValue();
		tipRateField.setText(String.format("%2d", tipRate));
		if(doneTotal != true) {
			updateTotal();
		}
	}
	public JPanel taxRatePanel() {			
		taxRateLabel = new JLabel("Tax Rate");
		taxRateField = new JTextField(String.format("%8.3f", AZTAXRATE));
		taxRate = AZTAXRATE;
		taxRateField.setEditable(false);
		percent = new JLabel("%");
		JPanel controlPanel = new JPanel();		
		controlPanel.add(createRadioButtons());
		controlPanel.add(taxRateField);
		controlPanel.add(percent);
		add(controlPanel);		
		return controlPanel;
	}

	public JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem clearItem = new JMenuItem("Clear");
		ActionListener listener = new ExitItemListener();
		exitItem.addActionListener(listener);
		ActionListener cleaner = new ClearItemListener();
		clearItem.addActionListener(cleaner);
		menu.add(exitItem);
		menu.add(clearItem);
		return menu;
	}
	
	class ExitItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		System.exit(0);
		}
	}
	class ClearItemListener implements ActionListener {		
		public void actionPerformed(ActionEvent event) {
			resultArea.setText("");
			balance = 0.0;
			totalTax = 0.0;		
			totalWTax = 0.0;
			totalWTipnTax = 0.0;
			totalTip = 0.0;
			doneTotal = false;
			updateTotal();
		}
	}
	class AddFoodListener implements ActionListener {
		private String food;
		public AddFoodListener(String food) {
			this.food = food;
		}
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				if(food == "C&S") {
					balance += CSPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,CSPRICE));
				}
				else if(food == "Bacon") {
					balance += BACONPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,BACONPRICE));
				}
				else if(food =="Cheese Cake") {
					balance += CHCAKEPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,CHCAKEPRICE));
				}
				else if(food == "Pickles") {
					balance += PICKLESPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,PICKLESPRICE));
				}
				else if(food == "Soup") {
					balance += SOUPPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,SOUPPRICE));
				}
				else if(food == "Ice Cream") {
					balance += ICECREAMPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,ICECREAMPRICE));
				}
				else if(food == "Egg Roll") {
					balance += EGGROLLPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,EGGROLLPRICE));
				}
				else if(food == "Ribs") {
					balance +=RIBSPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,RIBSPRICE));
				}
				else if(food == "Chocolate Cake") {
					balance += CHOCAKEPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,CHOCAKEPRICE));
				}
				else if(food == "3Dip") {
					balance += THREEDIPPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,THREEDIPPRICE));
				}
				else if(food == "Ribeye") {
					balance += RIBEYEPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,RIBEYEPRICE));
				}
				else if(food == "Cookie") {
					balance += COOKIEPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,COOKIEPRICE));
				}
				else if(food == "Queso") {
					balance += QUESOPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,QUESOPRICE));
				}
				else if(food == "Pasta") {
					balance += PASTAPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,PASTAPRICE));
				}
				else if(food == "Trio") {
					balance += TRIOPRICE;
					resultArea.append(String.format("%-25s"+"$%11.2f\n",food,TRIOPRICE));
				}
				updateTotal();
			}
		}
	}
	public void updateTotal() {
		totalTax = balance * taxRate/100;
		totalWTax = balance + totalTax;
		totalTip = balance * tipRate/100;
		totalWTipnTax = totalWTax + totalTip;
		currentTotal.setText(String.format("Current Total:$%6.2f",balance));
		currentTotalwTax.setText(String.format("Current Total w/Tax:$%6.2f",totalWTax));
		currentTotalwTip.setText(String.format("Current Total w/Tip:$%6.2f",totalWTipnTax));
	}
	
	class SetServerListener implements ActionListener {
		private String name;
		public SetServerListener(String name){
			this.name = name;
		}
		public void actionPerformed(ActionEvent event) {
			currentServer = name;
		}
	}
	public JMenu createServerMenu() {
		JMenu menu = new JMenu("Server");
		JMenuItem server1 = new JMenuItem("Jongyoun W.");
		server1.addActionListener(new SetServerListener("Jongyoun W."));
		menu.add(server1);
		JMenuItem server2 = new JMenuItem("Christian T.");
		server2.addActionListener(new SetServerListener("Christian T."));
		menu.add(server2);
		JMenuItem server3 = new JMenuItem("Adrian M.");
		server3.addActionListener(new SetServerListener("Adrian M."));
		menu.add(server3);
		JMenuItem server4 = new JMenuItem("Marcos R.");
		server4.addActionListener(new SetServerListener("Marcos R."));
		menu.add(server4);
		
		currentServer = "Jongyoun W.";
		return menu;
	}
	
	public JPanel createRadioButtons() {	
		
		AZButton = new JRadioButton("AZ");		
		AZButton.addActionListener(new SetTaxListener("AZ"));
		AZButton.setSelected(true);
		
		CAButton = new JRadioButton("CA");
		CAButton.addActionListener(new SetTaxListener("CA"));
		
		COButton = new JRadioButton("CO");
		COButton.addActionListener(new SetTaxListener("CO"));

		NMButton = new JRadioButton("NM");
		NMButton.addActionListener(new SetTaxListener("NM"));

		NVButton = new JRadioButton("NV");		
		NVButton.addActionListener(new SetTaxListener("NV"));

		ButtonGroup group = new ButtonGroup();
		group.add(AZButton);
		group.add(CAButton);
		group.add(COButton);
		group.add(NMButton);
		group.add(NVButton);
		
		JPanel panel = new JPanel();
		panel.add(AZButton);
		panel.add(CAButton);
		panel.add(COButton);
		panel.add(NMButton);
		panel.add(NVButton);	
		return panel;
	}
	class SetTaxListener implements ActionListener {
		private String stateCode;
		public SetTaxListener(String stateCode) {
			this.stateCode = stateCode;
		}
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				if(stateCode == "AZ") {
					taxRate = AZTAXRATE;
					taxRateField.setText(String.format("%8.3f",AZTAXRATE));

				}
				else if(stateCode == "CA") {
					taxRate = CATAXRATE;
					taxRateField.setText(String.format("%8.3f",CATAXRATE));

				}
				else if(stateCode == "CO") {
					taxRate = COTAXRATE;
					taxRateField.setText(String.format("%8.3f",COTAXRATE));

				}
				else if(stateCode == "NM") {
					taxRate = NMTAXRATE;
					taxRateField.setText(String.format("%8.3f",NMTAXRATE));

				}
				else if(stateCode == "NV") {
					taxRate = NVTAXRATE;
					taxRateField.setText(String.format("%8.3f",NVTAXRATE));
				}
				updateTotal();
			}
		}
	}
	public JPanel addFoodButtons() {
		JPanel panel = new JPanel();		
		GridLayout layout = new GridLayout(6,2);
		layout.setVgap(18);
		layout.setHgap(10);
		panel.setLayout(layout);
		

		appetizer = new JLabel("App.",JLabel.CENTER);
		mainDish = new JLabel("Main",JLabel.CENTER);
		desert = new JLabel("Desert",JLabel.CENTER);
	
		CS = new JButton("C&S");
		CS.addActionListener(new AddFoodListener("C&S"));

		bacon = new JButton("Bacon");
		bacon.addActionListener(new AddFoodListener("Bacon"));

		chCake = new JButton("Cheese Cake");
		chCake.addActionListener(new AddFoodListener("Cheese Cake"));

		pickles = new JButton("Pickles");
		pickles.addActionListener(new AddFoodListener("Pickles"));

		soup = new JButton("Soup");
		soup.addActionListener(new AddFoodListener("Soup"));

		iceCream = new JButton("Ice Cream");
		iceCream.addActionListener(new AddFoodListener("Ice Cream"));

		eggRoll = new JButton("Egg Roll");
		eggRoll.addActionListener(new AddFoodListener("Egg Roll"));

		ribs = new JButton("Ribs");
		ribs.addActionListener(new AddFoodListener("Ribs"));

		choCake = new JButton("Chocolate Cake");
		choCake.addActionListener(new AddFoodListener("Chocolate Cake"));

		threeDip = new JButton("3Dip");
		threeDip.addActionListener(new AddFoodListener("3Dip"));

		ribeye = new JButton("Ribeye");
		ribeye.addActionListener(new AddFoodListener("Ribeye"));

		cookie = new JButton("Cookie");
		cookie.addActionListener(new AddFoodListener("Cookie"));

		queso = new JButton("Queso");
		queso.addActionListener(new AddFoodListener("Queso"));

		pasta = new JButton("Pasta");
		pasta.addActionListener(new AddFoodListener("Pasta"));

		trio = new JButton("Trio");
		trio.addActionListener(new AddFoodListener("Trio"));
		
		panel.add(appetizer);
		panel.add(mainDish);
		panel.add(desert);
		panel.add(CS);
		panel.add(bacon);
		panel.add(chCake);
		panel.add(pickles);
		panel.add(soup);
		panel.add(iceCream);
		panel.add(eggRoll);
		panel.add(ribs);
		panel.add(choCake);
		panel.add(threeDip);
		panel.add(ribeye);
		panel.add(cookie);
		panel.add(queso);
		panel.add(pasta);
		panel.add(trio);
		
		return panel;
	}
	public JPanel addTextArea() {
		JPanel panel = new JPanel();
		resultArea = new JTextArea(28,45);
		resultArea.setEditable(false);
		resultArea.setText("");
		Font font = new Font("Monospaced",Font.BOLD,12);
		resultArea.setFont(font);
		panel.add(resultArea);
		scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);
		return panel;
	}
	public void addLabels() {		
		currentTotal = new JLabel(String.format("Current Total:$%6.2f", balance));
		currentTotalwTax = new JLabel(String.format("Current Total w/Tax:$%6.2f",totalWTax));
		currentTotalwTip = new JLabel(String.format("Current Total w/Tip:$%6.2f", totalWTipnTax));
	}
	class TotalListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(doneTotal != true) {
				tipRate = tipSlider.getValue();	
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
				resultArea.append("\nIt was a pleasure serving you!\n");
				resultArea.append(String.format("    -%s\n\n\n\n\n\n",currentServer));
				doneTotal = true;
			}
		}	
	}
}
