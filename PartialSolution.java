import java.util.Arrays;

public class PartialSolution {
   private Queen[] queens;
   private static final int NQUEENS = 8;

   public static final int ACCEPT = 1;
   public static final int ABANDON = 2;
   public static final int CONTINUE = 3;
   
   public PartialSolution(int size) {
      queens = new Queen[size];
   }

   public int examine() {
      for (int i = 0; i < queens.length; i++) {
         for (int j = i + 1; j < queens.length; j++) {
            if (queens[i].attacks(queens[j])) { return ABANDON; }
         }
      }
      if (queens.length == NQUEENS) { return ACCEPT; }
      else { return CONTINUE; }
   }

   public PartialSolution[] extend() {
      PartialSolution[] result = new PartialSolution[NQUEENS];
      for (int i = 0; i < result.length; i++) {
         int size = queens.length;

         result[i] = new PartialSolution(size + 1);

         for (int j = 0; j < size; j++) {
            result[i].queens[j] = queens[j];
         }

         result[i].queens[size] = new Queen(size, i);
      }
      return result;
   }

   public String toString() { return Arrays.toString(queens); }
}