import java.util.Stack;
import java.util.Scanner;

// -{ [b * b - (4 * a * c)] / (2 * a) }

public class Balanced {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Balanced Expression Checker\n");
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			boolean b = isBalanced(line, true);
			System.out.printf("The string \"%s\" is %sbalanced.\n", line, b ? "" : "not ");
		}
		
		in.close();
	}

	private static boolean isBalanced(String l, boolean verbose) {
		String opening = "({[<";
		String closing = ")}]>";
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < l.length(); i++) {
			char c = l.charAt(i);
			if (verbose) { System.out.printf("@'%c': %s\n", c, s); }
			if (opening.indexOf(c) >= 0) {
				s.push(c);
				if (verbose) { System.out.printf("      Pushed '%c'\n", c); }
			} 
			else if (closing.indexOf(c) >= 0) {
				if (s.size() == 0) return false;
				char x = s.pop();
				if (verbose) { System.out.printf("      Popped '%c'\n", x); }
				if (opening.indexOf(x) != closing.indexOf(c))
					return false;
			}
		}
		return s.size() == 0;
	}
}
