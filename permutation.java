public class permutation {

   public static void main(String[] args) {
      PrintPermutation("123".toCharArray(), 0);
   }

   public static void PrintPermutation(char[] inputs, int currentFocus) {
      if (currentFocus == inputs.length - 1) {
         System.out.println(new String(inputs));
         return;
      }
   
      PrintPermutation(inputs, currentFocus + 1);
      
      for (int i = currentFocus + 1; i < inputs.length; i ++) {
         char temp = inputs[currentFocus];
         inputs[currentFocus] = inputs[i];
         inputs[i] = temp;
         
         PrintPermutation(inputs, currentFocus + 1);
      }
   }

}