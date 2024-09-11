import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class ListDemo {

	public static void main(String[] args) {
		List<String> fruitBasket = new LinkedList<String>();
//		List<String> fruitBasket = new ArrayList<String>();

		fruitBasket.add("Tomatoes");
		fruitBasket.add("Bananas");
		fruitBasket.add("Watermelons");
		fruitBasket.add("Apples");
		fruitBasket.add("Grapes");
		fruitBasket.add("Oranges");
		fruitBasket.add("Plantains");
		fruitBasket.add("Tangerines, Mandarins and Clementines");
		fruitBasket.add("Pineapples");
		fruitBasket.add("Melons");
		fruitBasket.add("Peaches and Nectarines");
		fruitBasket.add("Pears");
		fruitBasket.add("Lemons and Limes");
		fruitBasket.add("Papayas");
		fruitBasket.add("Plums and Sloes");
		fruitBasket.add("Grapefruit");
		fruitBasket.add("Dates");
		fruitBasket.add("Strawberries");
		fruitBasket.add("Avocados");
		fruitBasket.add("Persimmons");

		System.out.println("World's Most Popular Fruit, in order of decreasing popularity:");
		int count = 1;
		for (String fruit : fruitBasket) {
			System.out.printf("   %2d) %s\n", count++, fruit);
		}

		Collections.sort(fruitBasket);

		System.out.println("\nWorld's Most Popular Fruit, from A to Z:");
		count = 1;
		for (String fruit : fruitBasket) {
			System.out.printf("   %2d) %s\n", count++, fruit);
		}

		System.out.println("\nEating lunches:");
		for (int i = 1; i <= 5; i++) {
			int randomPick = (int) (Math.random() * fruitBasket.size());
			String lunch = fruitBasket.remove(randomPick);
			System.out.printf("   Having %s for lunch today.\n", lunch);		
		}

		System.out.println("\nWhat's left in the basket?");
		count = 1;
		for (String fruit : fruitBasket) {
			System.out.printf("   %2d) %s\n", count++, fruit);
		}
	}
}
