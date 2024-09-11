import java.util.Scanner;

public class SortComparison {  
   public static void main(String[] args) {  
      Scanner in = new Scanner(System.in);
      System.out.print("First array length: ");
      int firstLength = in.nextInt();
      System.out.print("Number of arrays: ");
      int numberOfArrays = in.nextInt();

      StopWatch timer = new StopWatch();      
      
      for (int k = 1; k <= numberOfArrays; k++) {
         int n = k * firstLength;

         int[] a = ArrayUtil.randomIntArray(n, 100);
         int[] b = a.clone();
      
         timer.start();
         SelectionSorter.sort(a);
         timer.stop();
         long selectionTime = timer.getElapsedTime();
         timer.reset();
      
         timer.start();
         MergeSorter.sort(b);
         timer.stop();
         long mergeTime = timer.getElapsedTime();
         timer.reset();
         
         System.out.printf("Length:%8d Selection:%8d Merge:%8d%n",n, selectionTime, mergeTime);
         timer.reset();
      }
   }
}