import javax.swing.JComponent;
import javax.swing.JFrame;

public class AbstractArtViewer {
   public static void main(String[] args) {
      JFrame frame = new JFrame();

      frame.setSize(400, 200);
      frame.setTitle("Abstract Art");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JComponent component = new AbstractArt();
      frame.add(component);

      frame.setVisible(true);
   }
}