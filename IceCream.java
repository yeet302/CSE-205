import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class IceCream {
	public static void main(String[] args) {
		List<String> all = flavors();

		Set<String> joe = chooseRandomSet(15, "Joe likes ", all);
		Set<String> maria = chooseRandomSet(15, "Maria likes ", all);
		Set<String> anil = chooseRandomSet(15, "Anil likes ", all);
		Set<String> bob = chooseRandomSet(5, "Bob hates ", all);

		Set<String> inCommon = copy(joe);
		inCommon.retainAll(maria);
		inCommon.retainAll(anil);
		inCommon.removeAll(bob);

		if (inCommon.size() == 0)
			System.out.println("\nThere is no qualifying ice cream flavor :(");
		else
			System.out.println("\nChoose 1 of: " + inCommon);
	}

	private static Set<String> copy(Set<String> a) {
		Set<String> b = new HashSet<String>();
		for (String s : a)
			b.add(s);
		return b;
	}

	private static List<String> flavors() {
		List<String> ice = new ArrayList<String>();

		try {
			File f = new File("IceCreamFlavors.txt");
			Scanner in = new Scanner(f);

			while (in.hasNextLine())
				ice.add(in.nextLine());
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}

		return ice;
	}

	private static String chooseRandom(List<String> l) {
		return l.get((int) (Math.random() * l.size()));
	}

	private static Set<String> chooseRandomSet(int n, String name, List<String> l) {
		Set<String> result = new HashSet<String>();
		for (int i = 1; i <= n; i++) {
			result.add(chooseRandom(l));
		}
		System.out.println(name + result);
		return result;
	}
}
