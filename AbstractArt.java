import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Color;

public class AbstractArt extends JComponent {
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 20; i++) {
			int x = rand(0,350);
			int y = rand(0,160);
			int width = rand(10,50);
			int height = rand(10,40);
			g.setColor(new Color(rand(0,255), rand(0,255), rand(0,255)));
			g.fillRect(x, y, width, height);
		}

		for (int i = 0; i < 20; i++) {
			int x = rand(0,350);
			int y = rand(0,160);
			int width = rand(10,50);
			int height = rand(10,40);
			g.setColor(new Color(rand(0,255), rand(0,255), rand(0,255)));
			g.drawOval(x, y, width, height);
		}

		for (int i = 0; i < 20; i++) {
			int x1 = rand(0,399);
			int y1 = rand(0,199);
			int x2 = rand(0,399);
			int y2 = rand(0,199);
			g.setColor(new Color(rand(0,255), rand(0,255), rand(0,255)));
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	private int rand(int min, int max) {
		return (int) (Math.random() * (max-min) + min);
	}
}