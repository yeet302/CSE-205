import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class GuessWord {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> words = readWords();
		String word = pickWord(words);
		String guesses = "";

		Scanner in = new Scanner(System.in);

		System.out.println("\nGuess-a-Word - E. Eckert");

		do {
			printWord(word, guesses);
			guesses += getUniqueGuess(in, guesses);
		} while (!wordGuessed(word, guesses));

		printWord(word, guesses);

		System.out.println("\nYou guessed it in " + guesses.length() + " tries.");

		in.close();
	}

	private static ArrayList<String> readWords() throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();

		File inputFile = new File("words.txt");
		Scanner in = new Scanner(inputFile);
		while (in.hasNext()) {
			words.add(in.next());
		}
		System.out.println("I know " + words.size() + " words.");

		in.close();

		return words;
	}

	static String pickWord(ArrayList<String> list) {
		return list.get((int) (Math.random() * list.size())).toUpperCase();
	}

	static void printWord(String word, String guesses) {
		System.out.println("");

		for (int i = 0; i < word.length(); i++) {
			if (guesses.indexOf(word.charAt(i)) >= 0) {
				System.out.print(word.charAt(i) + " ");
			} else {
				System.out.print("_ ");
			}
		}

		System.out.println("   Used letters: {" + guesses + "}");
	}

	private static char getUniqueGuess(Scanner k, String guesses) {
		char letter;

		do {
			System.out.print("\nEnter a letter: ");
			letter = k.nextLine().toUpperCase().charAt(0);
		} while (guesses.indexOf(letter) >= 0);

		return letter;
	}

	static boolean wordGuessed(String word, String guesses) {
		for (int i = 0; i < word.length(); i++) {
			if (guesses.indexOf(word.charAt(i)) < 0)
				return false;
		}
		return true;
	}
}
