import java.util.Arrays;

public class ArrayReverse {
	public static void reverseArray(int[] data, int low, int high) {
		if (low < high) { 
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArray(data, low + 1, high - 1);
		}
	}

	public static void iterativeReverseArray(int[] data, int low, int high) {
		while (low < high) {
			int temp = data[low]; 
			data[low] = data[high];
			data[high] = temp;
			low++;
			high--;
		}
		return;
	}

	public static void reverseArray(int[] data) {
		reverseArray(data, 0, data.length - 1);
	}

	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		System.out.println("Before: " + Arrays.toString(data));
		reverseArray(data);
		System.out.println("After : " + Arrays.toString(data));
	}
}