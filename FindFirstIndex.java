public class FindFirstIndex {

   public static void main(String[] args) {
      int[] nums = {0, 1, 1, 2, 3, 4, 4, 4};
      System.out.println(GetFirstIndex(nums, 2, 0, nums.length - 1));
   }

   // notice we define a same header as a normal binary search
   public static int GetFirstIndex(int[] nums, int a, int start, int end) {
      
      if (end < start)  return -1;
      if (nums[start] > a) return -1;
      if (nums[end] < a)   return -1;
      
      if (nums[start] == a)   return start;
      
      int mid = (start + end) / 2;
      if (nums[mid] == a) {
         // we have two choices, either mid position is candidate, or the index we find in the left half can be
         int leftIndex = GetFirstIndex(nums, a, start, mid - 1); // recursive call
         if (leftIndex != -1) return leftIndex;
         else return mid;  
      } else if (nums[mid] > a) {
         return GetFirstIndex(nums, a, start, mid - 1);
      } else {
         return GetFirstIndex(nums, a, mid + 1, end);
      }
   }

}