public class VerboseTriangle {
	private int width;
	private int level;

	public VerboseTriangle(int aWidth, int l) {
		width = aWidth;
		level = l;
	}

	public int getArea() {
		int result = 0;

		for (int i = 0; i < level; i++) 
			System.out.print("|  ");
		System.out.printf("getArea(%d)\n", width);

		if (width <= 0) {
			result = 0;
		}
		else if (width == 1) {
			result = 1;
		}
		else {
			VerboseTriangle smallerTriangle = new VerboseTriangle(width - 1, level + 1);
			int smallerArea = smallerTriangle.getArea();
			result = smallerArea + width;
		}
		
		for (int i = 0; i < level; i++) 
			System.out.print("|  ");
		System.out.printf("= %d\n", result);

		return result;
	}
}