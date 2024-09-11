import java.util.Scanner;

public class Factorial {

	public static int factorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException(); // argument must be nonnegative
		else if (n == 0)
			return 1; // base case
		else
			return n * factorial(n - 1); // recursive case
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Factorial\nn? ");
		int n = in.nextInt();
		try {
			System.out.println("factorial(" + n + ") = " + factorial(n));
		} catch (IllegalArgumentException e) {
			System.out.println("Error: the factorial function is undefined for negative integers");
		}
		in.close();
	}
}
