import java.util.*;

public class TheStack {
   private String[] stackArray;
   private int stackSize;
   private int topOfStack = -1;
   
   TheStack(int size) {
      stackSize = size;
      stackArray = new String[size];
   }
   
   public void push(String input) {
      if (topOfStack + 1 < stackSize) {
         topOfStack ++;
         stackArray[topOfStack] = input;
      } else System.out.println("Sorry but the Stack is full.");
      System.out.println("PUSH " + input + " Was Added to the Stack.");
   }
   
   public String pop() {
      if (topOfStack >= 0) {
         System.out.println("POP " + stackArray[topOfStack] + " Was Removed from the Stack.");
         stackArray[topOfStack] = "-1";
         return stackArray[topOfStack --];
      } else {
         System.out.println("Sorry but the Stack is Empty.");
      }
      return null;
   }
   
   public String peek() {
      System.out.println("PEEK " + stackArray[topOfStack]);
      return stackArray[topOfStack];
   }
   
   public static void main(String[] args) {
      TheStack theStack = new TheStack(10);
      theStack.push("haotian");
      theStack.push("feifei");
      theStack.push("yaohua");
      theStack.push("jonggun");
      
      
   }
}