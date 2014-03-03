public class ParenthesisPrint {

   public static void main(String[] args) {
      PrintParenthesis(2, 2, "");
   }

   public static void PrintParenthesis(int leftRemain, int rightRemain, String currentString) {
      if (rightRemain == 0) { // all print out
         System.out.println(currentString);
         return;
      }
      if (leftRemain > 0) { // more left parenthesis
         // choice 1, print another left parenthesis
         PrintParenthesis(leftRemain - 1, rightRemain, currentString + "(");
         // choice 2, print right parenthesis if valid
         if (leftRemain < rightRemain) // which means more left parenthesis have been used
            PrintParenthesis(leftRemain, rightRemain - 1, currentString + ")");
      } else {
         PrintParenthesis(leftRemain, rightRemain - 1, currentString + ")");
      }
   }

}