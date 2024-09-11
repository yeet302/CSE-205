public class Queen {
   private int row;
   private int column;

   public Queen(int r, int c) {
      row = r;
      column = c;
   }

   public boolean attacks(Queen other) {
      return row == other.row
         || column == other.column
         || Math.abs(row - other.row) == Math.abs(column - other.column);
   }

   public String toString() { 
      return "" + "abcdefgh".charAt(column) + (row + 1) ; 
   }
}