import java.awt.Graphics;
import javax.swing.JComponent;

public class BounceBallComponent extends JComponent {
	private int xLeft;
	private int yTop;
	private int diameter;

	public BounceBallComponent(int d) {
		diameter = d;
		xLeft = 1;
		yTop = 1;
	}

	public void paintComponent(Graphics g) {
		g.fillOval(xLeft, yTop, diameter, diameter);
	}

	public void moveRectangleBy(int dx, int dy) {
		xLeft = xLeft + dx;
		yTop = yTop + dy;
		repaint();
	}

	public int getXposition() {
		return xLeft;
	}

	public int getYposition() {
		return yTop;
	}
}