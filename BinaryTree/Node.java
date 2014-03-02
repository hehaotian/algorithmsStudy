public class Node {
   int key;
   String name;
   
   Node left;
   Node right;
   
   Node(int key, String name) {
      this.key = key;
      this.name = name;
   }

   public String toString() {
      return key + " has a value " + name;
   }
}