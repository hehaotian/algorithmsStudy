public class VerifyRotatePalindrome {
   
   public static void main(String[] args) {
      String input1 = "1234321";
      System.out.println(input1 + "\t A rotated palindrome? " + IsRotatePalindrome(input1));
      
      String input2 = "3432112";
      System.out.println(input2 + "\t A rotated palindrome? " + IsRotatePalindrome(input2));
      
      String input3 = "234321";
      System.out.println(input3 + "\t A rotated palindrome? " + IsRotatePalindrome(input3));
   }
   

   // firstly, define a palindrome method
   public static boolean IsPalindrome(String in) {
      // the idea to verify is a string is a palindrome is to check each pair of chars at position (i, length-1-i);
      // if a mismatch is found return false, otherwise, return true
      char[] ins = in.toCharArray();
      for (int i = 0; i < ins.length / 2; i ++) {
         // verify each position pair of (i, length-1-i)
         if (ins[i] != ins[ins.length - 1 - i])
            return false;
      }
      return true;
   }
   
   // now we start implement our rotate palindrome algorithm
   public static boolean IsRotatePalindrome(String in) {
      for (int i = 0; i < in.length(); i ++) {
         String left = in.substring(0, i); // first substring method accepts 2 values, 1st is index, 2nd is length
         String right = in.substring(i); // the overloaded substring method accepts the starting index as the only argument
         // now use our palindrome method to check right + left
         if (IsPalindrome(right + left))
            return true;
      }
      return false;
   }
}