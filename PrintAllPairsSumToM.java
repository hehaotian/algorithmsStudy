public class PrintAllPairsSumToM {

   public static void main(String[] args) {
      int[] arr = {1,2,3,4,9,9,10};
      PrintAllPairs(arr, 12);
   }

   public static void PrintAllPairs(int[] sorted, int m) {
      int left = 0;
      int right = sorted.length - 1;
      
      while (left < right) {
         int tempSum = sorted[left] + sorted[right];
         if (tempSum == m) {
            System.out.println("Sum of (" + sorted[left] + ", " + sorted[right] + ") = " + m);
            left ++;
            right --;
         } else if (tempSum > m) {
            right --;
         } else {
            left ++;
         }
      }
   }
}