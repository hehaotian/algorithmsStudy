class reverseList {

   public static void main(String[] args) {
      List myList = new List(1);
      myList.next = new List(2);
      myList.next.next = new List(3);
      myList.next.next.next = new List(4);
      System.out.println("Original List: " + myList.toString());
      myList = Reverse(myList);
      System.out.println("Reversed List: " + myList.toString());
   }

   static List Reverse(List L) {
      if (L == null || L.next == null) {
         return L;
      }
      List remainingReverse = Reverse(L.next);
      L.next.next = L;
      L.next = null;
      return remainingReverse;
   }
}

class List {
   int value;
   List next;
   public List(int k) {
      value = k;
   }
   public String toString() {
      List current = this;
      String output = "";
      while (current != null) {
         output += current.value + "->";
         current = current.next;
      }
      return output + "NULL";
   }
}