import java.util.Scanner;

public class ExpressionCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression: ");
		String input = in.nextLine();
		in.close();

		Evaluator e = new Evaluator(input);
		int value = e.getExpressionValue();
		System.out.println(input + "=" + value);
	}
}