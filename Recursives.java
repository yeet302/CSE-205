import java.util.ArrayList;
import java.lang.Math;

public class Recursives {
	
	public static void main(String[] args) {
		System.out.println("Recursives - Jongyoun Woo\n");

		System.out.println("Factors:"); // E13.3
		System.out.printf("   %7d: %s%n", 24, factors(24));
		System.out.printf("   %7d: %s%n", 105, factors(105));
		System.out.printf("   %7d: %s%n%n", 3783780, factors(3783780));

		System.out.println("Binary:"); // E13.4
		System.out.printf("   %7d: %s%n", 24, toBinary(24));
		System.out.printf("   %7d: %s%n", 105, toBinary(105));
		System.out.printf("   %7d: %s%n%n", 3783780, toBinary(3783780));

		System.out.println("Reverse:"); // E13.5
		System.out.printf("   %s: %s%n", "Hello!", reverse("Hello!"));
		System.out.printf("   %s: %s%n", "Madam, I'm Adam", reverse("Madam, I'm Adam"));
		System.out.printf("   %s: %s%n", "amanaplanacanalpanama", reverse("amanaplanacanalpanama"));
		System.out.printf("   %s: %s%n%n", "This is a test of Double Reverse!!",
				reverse(reverse("This is a test of Double Reverse!!")));

		System.out.println("Polygon:"); // E13.12
		ArrayList<Double> points = new ArrayList<Double>();
		points.add(1.0);
		points.add(3.0);
		points.add(1.0);
		points.add(7.0);
		points.add(3.0);
		points.add(9.0);
		points.add(8.0);
		points.add(8.0);
		points.add(9.0);
		points.add(4.0);
		points.add(8.0);
		points.add(1.0);
		points.add(4.0);
		points.add(1.0);
		System.out.printf("   %f%n", polygon(points));
	}

	private static ArrayList<Integer> factors(int f) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		factors(f,list);		
		return list;
	}

	private static void factors(int f, ArrayList<Integer> l) { 
		int number = f;
		int factor;
		ArrayList<Integer> factorList = l;
		for(factor=2; factor<=number; factor++) {
			if(number % factor == 0 ) {
				factorList.add(factor);
				factors(number/factor, factorList);	
				return;
			}			
		}		
	}

	private static String toBinary(int n) {
		if(n<2) {
			return " "+n;
		}
		else {
			return 
			toBinary(n/2)+(n%2);
		}
	}

	private static String reverse(String s) {	
//		if(s.length()==2) {
//			String baseString = s.substring(1)+s.substring(0,1);
//			return baseString;
//		}
//		else if(s.length() == 3) {
//			String baseString = s.substring(2,3)+s.substring(1,2)+s.substring(0,1);
//			return baseString;
//		}	
		
		if(s.isBlank()) {
			return s;
		}
		
		String removedString = s.substring(1);
		String finalString = "";
		finalString = reverse(removedString) + s.charAt(0);  //s.substring(0,1);
		return finalString;		
	}

	private static double polygon(ArrayList<Double> p) {
		
		double x1,x2,x3,y1,y2,y3;
		double polygonArea = 0;
		ArrayList<Double> list = p;	
	
		if(list.size() == 6) {
			return getPolygonArea(list);
		}		

			polygonArea = getPolygonArea(list);
			list.remove(2);
			list.remove(2);
			return polygonArea + polygon(list);
		
	}
	private static double getPolygonArea(ArrayList<Double> k) {
		double x1,x2,x3,y1,y2,y3;
		x1 = k.get(0);
		y1 = k.get(1);
		x2 = k.get(2);
		y2 = k.get(3);
		x3 = k.get(4);
		y3 = k.get(5);
		
		double triangleArea = Math.abs(x1*y2+x2*y3+x3*y1-y1*x2-y2*x3-y3*x1)/2;			
		return triangleArea;
	}
}