public class VerboseTriangleTester {
	public static void main(String[] args) {
		VerboseTriangle t = new VerboseTriangle(10, 0);
		int area = t.getArea();
		System.out.println("\nArea: " + area);
		System.out.println("Expected: 55");
	}
}