import java.util.Queue;
import java.util.LinkedList;

public class TreeLevelPrint {

   public static void main(String[] args) {
      // let's create a binary tree
      //    1
      //  2   3
      // 4 5 6 7
      Tree myTree = new Tree(1);
      myTree.left = new Tree(2);
      myTree.right = new Tree(3);
      myTree.left.left = new Tree(4);
      myTree.left.right = new Tree(5);
      myTree.right.left = new Tree(6);
      myTree.right.right = new Tree(7);
      
      System.out.print("3rd Level is ");
      QueuePrintTreeLevel(myTree, 2); 
      System.out.println("\n");
      System.out.print("2rd Level is ");
      RecursionPrintTreeLevel(myTree, 0, 1);
   }
   
   // method 1: use Queue, so need to include java.util.Queue and LinkedList
   public static void QueuePrintTreeLevel(Tree t, int lv) {
      
      // firstly, check if the level is valid
      if (lv <= 0) System.out.println("Wrong tree");
      
      // now define two queues, one to store tree nodes, the other for current levels
      Queue<Tree> trees = new LinkedList<Tree>();
      Queue<Integer> levels = new LinkedList<Integer>(); // note in java, Queue is an interface which can be inheritated by LinkedList!
      // start by pushing root node in the queue
      trees.add(t);
      levels.add(0);
      // now define a loop to continue while the queue is not empty
      while (!trees.isEmpty()) {
         Tree temp = trees.poll(); // poll method is same as the conceptual deque() method
         // System.out.println(temp.value);
         int currentLevel = levels.poll();
         if (temp == null) return;
         else if (currentLevel == lv) {
            System.out.print(temp.value + " ");
         } else {
            trees.add(temp.left);
            levels.add(currentLevel + 1);
            trees.add(temp.right);
            levels.add(currentLevel + 1);
         }
      }
   }
   
   // now we try to implement 2nd method using recursion
   public static void RecursionPrintTreeLevel(Tree t, int currentLevel, int lv) {
      // firstly, check if currentLevel or the current tree is empty, then return without going further
      if (t == null || currentLevel  > lv)   return;
      // now check if currentLevel == lv
      if (currentLevel == lv) {
         System.out.print(t.value + " ");
      } else {
         // proceed to its left and right
         RecursionPrintTreeLevel(t.left, currentLevel + 1, lv);
         RecursionPrintTreeLevel(t.right, currentLevel + 1, lv);
      }
   }
   
}