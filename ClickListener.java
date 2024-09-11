import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClickListener implements ActionListener {
	private int countClick = 0;
	public void actionPerformed(ActionEvent event) {
		System.out.println("I was clicked!");
		countClick++;
	}
}
