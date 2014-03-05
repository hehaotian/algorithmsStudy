public class PrintAllSubsets {

   public static void main(String[] args) {
      int[] nums = {1, 2, 3};
      PrintSubset(nums);
   }
   
   // step 1. decide how many elements in a sub-array to be printed
   public static void PrintSubset(int[] nums) {
      // now we process the first step
      for (int i = 0; i <= nums.length; i ++) {
         boolean[] ifPrint = new boolean[nums.length];
         PrintSubsets(nums, ifPrint, 0, i);
      }
   }

   // step 2. this method processed the action to print out all possible combination of elements with fixed size
   // as we discussed, we need three additional variables to keep track of status
   // boolean array to know whether printed out or not
   // start is the start index to be printed to prevent duplicates
   // remain is keeping track of how many remaining elements to be processed for the subset action
   public static void PrintSubsets(int[] nums, boolean[] ifPrint, int start, int remain) {
      if (remain == 0) {
         System.out.print("{");
         for (int i = 0; i < ifPrint.length; i ++) {
            if (ifPrint[i])
               System.out.print(nums[i] + ",");
         }
         System.out.print("}\n");
      } else {
         // now is the key recursive part, we need process char by char from the start position until end
         // before that, we need determine whether we proceed or not to check if start + remain > nums.length
         if (start + remain > nums.length) // not possible even if all remaining elements to be used
            ;
         else { 
            for (int i = start; i < nums.length; i ++) {
               // now before we come to the recursive part we have to make sure this position is not used
               if (!ifPrint[i]) {
                  ifPrint[i] = true;
                  PrintSubsets(nums, ifPrint, i + 1, remain - 1);
                  ifPrint[i] = false;
               }
            }   
         }
      }
   }
   
}