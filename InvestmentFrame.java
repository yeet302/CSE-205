import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvestmentFrame extends JFrame {
   private JButton button;
   private JLabel resultLabel;
   private double balance;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 100;

   private static final double INTEREST_RATE = 5;
   private static final double INITIAL_BALANCE = 1000;   

   public InvestmentFrame() {
      balance = INITIAL_BALANCE;

      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
   
   class AddInterestListener implements ActionListener {
      public void actionPerformed(ActionEvent event)
      {
         double interest = balance * INTEREST_RATE / 100;
         balance = balance + interest;
         resultLabel.setText(String.format("Balance: $%.2f", balance));
      }            
   }

   private void createComponents() {
      button = new JButton("Add Interest");
      ActionListener listener = new AddInterestListener();
      button.addActionListener(listener);

      resultLabel = new JLabel(String.format("Balance: $%.2f", balance));

      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(resultLabel);
      add(panel);
   }

   public static void main(String[] args) {  
      JFrame frame = new InvestmentFrame();
      frame.setTitle("Investments I");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

