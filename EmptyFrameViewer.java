import javax.swing.*;

public class EmptyFrameViewer {

	public static void main(String[] args) {
		final int FRAME_WIDTH  = 300;
		final int FRAME_HEIGHT = 400;
		
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("An Empty Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		frame.setVisible (true);
	}
}
