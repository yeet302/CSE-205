import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

public class PopularAlice {
	public static void main(String[] args) throws FileNotFoundException {

		List<String> documentWords = readWords("alice30.txt");
		Map<String, Integer> freq = new HashMap<String, Integer>();
		List<WordCount> tuples = new ArrayList<>();

		for (String word : documentWords) {
			Integer count = freq.get(word);
			if (count == null)
				count = 0;
			freq.put(word, count + 1);
		}

		Set<String> keys = freq.keySet();
		for (String s : keys) {
			tuples.add(new WordCount(s, freq.get(s)));
		}

		Collections.sort(tuples);

		int i = 1;
		for (WordCount w : tuples) {
			System.out.printf("%3d) %s\n", i, w);
			if (i == 100)
				break;
			i++;
		}
	}

	private static List<String> readWords(String filename) {
		List<String> s = new ArrayList<String>();

		try {
			File f = new File(filename);
			Scanner in = new Scanner(f);
			in.useDelimiter("[^A-Za-z]");

			while (in.hasNext()) {
				String word = in.next().toLowerCase();
				if (word.length() > 0)
					s.add(word);
			}

		} catch (IOException e) {
			System.out.printf("Something went wrong opening \"%s\".\n", filename);
			System.exit(1);
		}

		return s;
	}

	private static class WordCount implements Comparable<WordCount> {
		String word;
		int count;

		WordCount(String s, int n) {
			word = s;
			count = n;
		}

		public int compareTo(WordCount other) {
			return other.count - count;
		}

		public String toString() {
			return word + ":" + count;
		}
	}
}