import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class ScrabbleScores {
	public static void main(String[] args) {

		ArrayList<Integer> letterScores = loadLetterScores();
		Queue<String> words = readWords();
		Stack<String> best = new Stack<String>();

		System.out.println("Scrabble Scores - Jongyoun Woo");

		Scanner in = new Scanner(System.in);
		System.out.print("How many rotations? ");
		int numRotate = in.nextInt();
		in.close();

		rotate(words, numRotate);
		
		// Go through all of the words in the Queue and score it.
		// Each time a new high score is found, push it onto the stack.
		int highScore = 0;
		for (String s : words) {
			score(s, letterScores);
			if(score(s,letterScores) >= highScore) {
				highScore = score(s,letterScores);
				best.push(s);
			}
		}

		// Go through the stack from the top to the bottom displaying the scores from highest to lowest
		while (!best.isEmpty()) {
			System.out.printf("%2d - %s\n",score(best.peek(),letterScores),best.pop());
		}
	}

	private static int score(String s, ArrayList<Integer> l) {
		int total = 0;
		for(int j=0 ; j<s.length(); j++) {
			int position = s.charAt(j)-'a';
			total += l.get(position);
		}
		// Calculate the Scrabble score for the given word by adding score for each letter.
		// Note: if you subtract 'a' from a character, you will get its position in the ArrayList.
		// For example, 'c' - 'a' is 2 (a=0, b=1, c=2, ...)
		
		return total;
	}

	private static void rotate(Queue<String> q, int n) {
		// Rotate the Queue n times.
		// Rotating involves removing an item from the front
		// of the Queue and adding it to the rear of the Queue.
		String temp;
		for(int i=0; i<n; i++) {
			temp = q.remove();
			q.add(temp);
		}
		
	}

	private static ArrayList<Integer> loadLetterScores() {
		ArrayList<Integer> l = new ArrayList<>();
		// The score for an 'A' will be at position 0, 'B' will be at position 1 ... 'Z' will be at position 25 
		
		int[] letterScores = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		
		for (int score : letterScores) {
			l.add(score);
		}
		
		return l;
	}

	private static Queue<String> readWords() {
		Queue<String> words = new LinkedList<String>();

		try {
			File inputFile = new File("words.txt");
			Scanner in = new Scanner(inputFile);
			while (in.hasNext()) {
				words.add(in.next().toLowerCase());
			}

			in.close();
		}
		catch (FileNotFoundException f) {
			System.out.println("Cannot file file 'words.txt' in the project directory.");
			System.exit(1);
		}

		return words;
	}
}
