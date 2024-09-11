public class Palindromes {
   public static void main(String[] args) {
      String sentence1 = "Madam, I'm Adam!";      
      System.out.println(sentence1);
      System.out.println("Palindrome: " + isPalindrome(sentence1));
      
      String sentence2 = "Sir, I'm Eve!";      
      System.out.println(sentence2);
      System.out.println("Palindrome: " + isPalindrome(sentence2));
   }

   public static boolean isPalindrome(String text) {
      return isPalindrome(text, 0, text.length() - 1);      
   }

   private static boolean isPalindrome(String text, int start, int end) {
      if (start >= end) { return true; }
      else {
         char first = Character.toLowerCase(text.charAt(start));
         char last = Character.toLowerCase(text.charAt(end));
         if (Character.isLetter(first) && Character.isLetter(last)) {
            if (first == last) {
               return isPalindrome(text, start + 1, end - 1);
            } else {
               return false;
            }
         } else if (!Character.isLetter(last)) {
            return isPalindrome(text, start, end - 1);
         } else {
            return isPalindrome(text, start + 1, end);
         }
      }
   }   
}