import java.util.Scanner;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RocketCountdown {
	private static int count;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the countdown start, in seconds: ");
		count = in.nextInt();		
		in.close();

		CountListener listener = new CountListener();
		Timer t = new Timer(1000, listener);
		t.start();

		while (true);
	}

	static class CountListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (count > 0) {
				System.out.println(count);
				count--;
			} else {
				System.out.println("*** Blast Off! ***");
				System.exit(0);
			}
		}
	}
}
