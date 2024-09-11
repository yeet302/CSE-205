import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class ChartComponent2 extends JComponent {  
   public void paintComponent(Graphics g) {  
      g.fillRect(0, 10, 200, 10);
      g.fillRect(0, 30, 300, 10);
      g.fillRect(0, 50, 100, 10);
      
      g.drawLine(350, 35, 305, 35);
      g.drawLine(305, 35, 310, 30);
      g.drawLine(305, 35, 310, 40);

      g.setColor(Color.YELLOW);     
      g.fillOval(350, 25, 35, 20);
      g.setColor(Color.BLACK);
      g.drawString("Best", 355, 40);
   }
}

