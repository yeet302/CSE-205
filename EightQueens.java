public class EightQueens {
   public static void main(String[] args) {
      solve(new PartialSolution(0));
   }

   public static void solve(PartialSolution sol) {
      int exam = sol.examine();
      if (exam == PartialSolution.ACCEPT) { 
         System.out.println(sol); 
      }
      else if (exam == PartialSolution.CONTINUE) {
         for (PartialSolution p : sol.extend()) {
            solve(p);
         }
      }
   }
}