public class NumberOccurrence {


   // we define start and end indexes for recursive calls in future invokation
   public static int GetOccurrence(int k, int[] numbers, int startIndex, int endIndex) {
      // firstly check if we need proceed by comparing start/end index
      // this is usually the first step for writing a recursive method to determine when to stop
      if (endIndex < startIndex) {
         return 0;
      }
      // now before we use binary search similar strategy, we check the sub-array if we need do so
      if (numbers[startIndex] > k) {
         return 0;
      }
      if (numbers[endIndex] < k) {
         return 0;
      }
      if (numbers[startIndex] == k && numbers[endIndex] == k) {
         return endIndex - startIndex + 1;
      }
      // now we have a sub-array which may possibily contain some ks
      int midInd = (startIndex + endIndex) / 2;
      if (numbers[midInd] == k) {
         return 1 + GetOccurrence(k, numbers, startIndex, midInd - 1) + GetOccurrence(k, numbers, midInd + 1; endIndex);
      } else if (numbers[midInd] > k) {
         return GetOccurrence(k, numbers, startIndex, midInd - 1);
      } else {
         return GetOccurrence(k, numbers, midInd + 1, endIndex);
      }
   }
}