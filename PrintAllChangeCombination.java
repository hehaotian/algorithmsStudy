public class PrintAllChangeCombination {

   public static void main(String[] args) {
      int[] coins = {25, 10, 5, 1};
      int[] counts = new int[coins.length];
      System.out.print("All possible coin combinations of 25 cents are: ");
      PrintCombination(coins, counts, 0, 25);
   }
   
   // define the recursive method header
   // notice we have 4 arguments in this method 
   // coins are the sorted coins in descending order, larger positioned more front
   // counts record the number of coins at certain location
   // start index is keep tracking of from which coin we start processing after choosing one larger coin amount
   // total amount keep track of remaining amount left processing
   public static void PrintCombination(int[] coins, int[] counts, int startIndex, int totalAmount) {
      // firstly decide if we should proceed or not by tracking startIndex
      
      if (startIndex >= coins.length) {
         // format the print out as "amount=?*25 + ?*10 + ..."
         for (int i = 0; i < coins.length; i ++) {
            System.out.print("" + counts[i] + "*" + coins[i]);
            if (i != coins.length - 1) System.out.print("+");
         }
         System.out.println("\n");
         return;
      }
      
      // otherwise we need proceed
      // but notice if startIndex is the last one, we need check if it can be dividable by the smallest coin
      // if so, this is a good combination, otherwise, this is not possible combination thus discarded
      if (startIndex == coins.length - 1) {
         if (totalAmount % coins[startIndex] == 0) {
            counts[startIndex] = totalAmount / coins[startIndex];
            PrintCombination(coins, counts, startIndex+1, 0);
         }
      } else { // we still have option to choose 0-N larger coins
         for (int i = 0; i <= totalAmount / coins[startIndex]; i ++) {
            // for every cycle in a loop, we choose an arbitary number of larger coins and proceed next
            counts[startIndex] = 1;
            PrintCombination(coins, counts, startIndex+1, totalAmount-coins[startIndex]*i);
            // notice we need update the remaining amount
         }
      }
   }
}