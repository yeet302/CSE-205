import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

public class SpellCheck {
	public static void main(String[] args) throws FileNotFoundException {

		Set<String> dictionaryWords = readWords("words.txt");
		Set<String> documentWords = readWords("alice30.txt");
		List<String> misspelled = new ArrayList<>();

		for (String word : documentWords) {
			if (!dictionaryWords.contains(word)) {
				misspelled.add(word);
			}
		}

		Collections.sort(misspelled);

		for (String w : misspelled)
			System.out.println(w);
	}

	private static Set<String> readWords(String filename) {
		Set<String> s = new HashSet<String>();

		try {
			File f = new File(filename);
			Scanner in = new Scanner(f);
			in.useDelimiter("[^A-Za-z]");

			while (in.hasNext())
				s.add(in.next().toLowerCase());
		} catch (IOException e) {
			System.out.printf("Something went wrong opening \"%s\".\n", filename);
			System.exit(1);
		}

		return s;
	}
}