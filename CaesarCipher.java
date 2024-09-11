import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) throws FileNotFoundException {
		final int DEFAULT_KEY = 3;
		int key = DEFAULT_KEY;
		
		String inFile = "";
		String outFile = "";
		int files = 0;
		
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (arg.charAt(0) == '-') {
				char option = arg.charAt(1);
				if (option == 'd') { key = -key; }
				else { usage(); return; }
			} else {
				files++;
				if (files == 1) { inFile = arg; }
				else if (files == 2) { outFile = arg; }
			}
		}
		if (files != 2) {
			usage();
			return;
		}
		
		Scanner in = new Scanner(new File(inFile));
		in.useDelimiter("");
		PrintWriter out = new PrintWriter(outFile);
		
		while (in.hasNext()) {
			char from = in.next().charAt(0);
			char to = encrypt(from, key);
			out.print(to);
		}
		in.close();
		out.close();
	}
	
	static char encrypt(char from, int key) {
		String lowers = "abcdefghijklmnopqrstuvwxyz";
		String uppers = lowers.toUpperCase();
		
		if (Character.isLowerCase(from)) {
			return lowers.charAt((lowers.indexOf(from) + lowers.length() + key) % lowers.length());
		}
		
		if (Character.isUpperCase(from)) {
			return uppers.charAt((uppers.indexOf(from) + uppers.length() + key) % uppers.length());
		}
		
		return from;
	}

	public static void usage() {
		System.out.println("Usage: java CaesarCipher [-d] infile outfile");
	}
}
