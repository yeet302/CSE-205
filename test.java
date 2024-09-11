import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();
		
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFileName);
		
		while(in.hasNext()) {
			String studentName = in.nextLine();
			String major = in.nextLine();
			double GPA = in.nextDouble();
			System.out.println(studentName+major+GPA);
			in.nextLiner();		
			
		}
		in.close();
		out.close();
		console.close();
	}

}
