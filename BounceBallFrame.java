import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class BounceBallFrame extends JFrame {
   private static final int FRAME_WIDTH = 100;
   private static final int FRAME_HEIGHT = 200;
   private static final int DIAMETER = 20;


   private BounceBallComponent scene;
   private int xDirection = 7;
   private int yDirection = 7;

   class TimerListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
    	  if (scene.getXposition() + 1.5 * DIAMETER >= getWidth() || scene.getXposition() <= 0)
    		  xDirection = -1 * xDirection;
    	  if (scene.getYposition() + 2.75 * DIAMETER >= getHeight() || scene.getYposition() <= 0)
    		  yDirection = -1 * yDirection;
         scene.moveRectangleBy(xDirection, yDirection);
      }
   }
   
   public BounceBallFrame() {
      scene = new BounceBallComponent(DIAMETER);
      add(scene);
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      ActionListener listener = new TimerListener();
      final int DELAY = 50; // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, listener);
      t.start();
   }
}