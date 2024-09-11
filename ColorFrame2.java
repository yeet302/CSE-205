import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColorFrame2 extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	private JPanel colorPanel;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;

	public ColorFrame2() {
		colorPanel = new JPanel();

		add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		createButtonPanel();
		setSampleColor();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	class ColorListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			setSampleColor();
		}
	}

	class SparkyListener implements ActionListener {
		private int red;
		private int green;
		private int blue;

		public SparkyListener(int red, int green, int blue) {
			this.red = red;
			this.blue = blue;
			this.green = green;
		}

		public void actionPerformed(ActionEvent event) {
			redSlider.setValue(red);
			greenSlider.setValue(green);
			blueSlider.setValue(blue);
		}
	}

	public void createButtonPanel() {
		ActionListener maroonListener = new SparkyListener(140, 29, 64);
		ActionListener goldListener = new SparkyListener(255, 198, 39);

		JButton maroonButton = new JButton("Maroon");
		maroonButton.addActionListener(maroonListener);

		JButton goldButton = new JButton("Gold");
		goldButton.addActionListener(goldListener);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 2));

		controlPanel.add(maroonButton);
		controlPanel.add(goldButton);

		add(controlPanel, BorderLayout.NORTH);
	}

	public void createControlPanel() {
		ChangeListener listener = new ColorListener();

		redSlider = new JSlider(0, 255, 255);
		redSlider.addChangeListener(listener);

		greenSlider = new JSlider(0, 255, 175);
		greenSlider.addChangeListener(listener);

		blueSlider = new JSlider(0, 255, 175);
		blueSlider.addChangeListener(listener);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 2));

		controlPanel.add(new JLabel("Red"));
		controlPanel.add(redSlider);

		controlPanel.add(new JLabel("Green"));
		controlPanel.add(greenSlider);

		controlPanel.add(new JLabel("Blue"));
		controlPanel.add(blueSlider);

		add(controlPanel, BorderLayout.SOUTH);
	}

	public void setSampleColor() {
		int red = redSlider.getValue();
		int green = greenSlider.getValue();
		int blue = blueSlider.getValue();

		colorPanel.setBackground(new Color(red, green, blue));
		colorPanel.repaint();
	}
}