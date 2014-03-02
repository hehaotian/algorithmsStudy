// BinaryTree.java
// author: Haotian He
// created by March 1, 2014

import java.io.*;
import java.util.*;

public class BinaryTree {

   Node root;
   
   public static void main(String[] args) {
      BinaryTree theTree = new BinaryTree();
      theTree.addNode(50, "Boss");
      theTree.addNode(25, "Pres");
      theTree.addNode(15, "Offi");
      theTree.addNode(30, "Secr");
      theTree.addNode(75, "Sale");
      theTree.addNode(85, "Medi");
      
      // theTree.remove(25);
      theTree.inOrderTraverseTree(theTree.root);
   }
   
   public void inOrderTraverseTree(Node focusNode) {
      if (focusNode != null) {
         inOrderTraverseTree(focusNode.left);
         System.out.println(focusNode);
         inOrderTraverseTree(focusNode.right);
      }
   }
   
   public void preOrderTraverseTree(Node focusNode) {
      if (focusNode != null) {
         System.out.println(focusNode);
         preOrderTraverseTree(focusNode.left);
         preOrderTraverseTree(focusNode.right);
      }
   }
   
   public void postOrderTraverseTree(Node focusNode) {
      if (focusNode != null) {
         postOrderTraverseTree(focusNode.left);
         postOrderTraverseTree(focusNode.right);
         System.out.println(focusNode);
      }
   }
   
   public void addNode(int key, String name) {
      Node newNode = new Node(key, name);
      if (root == null) {
         root = newNode;
      } else {
         Node focusNode = root;
         Node parent;
         while (true) {
            parent = focusNode;
            if (key < focusNode.key) {
               focusNode = focusNode.left;
               if (focusNode == null) {
                  parent.left = newNode;
                  return;
               }
            } else {
               focusNode = focusNode.right;
               if (focusNode == null) {
                  parent.right = newNode;
                  return;
               }
            }
         }
      }
   }
   
   public Node findNode(int key) {
      Node focusNode = root;
      while (focusNode.key != key) {
         if (key < focusNode.key) {
            focusNode = focusNode.left;
         } else {
            focusNode = focusNode.right;
         }
         if (focusNode == null) return null; 
      }
      return focusNode;
   }
   
   public boolean remove(int key) {
      Node focusNode = root;
      Node parent = root;
      boolean isItALeftChild = true;
      while (focusNode.key != key) {
         parent = focusNode;
         if (key < focusNode.key) {
            isItALeftChild = true;
            focusNode = focusNode.left;
         } else {
            isItALeftChild = false;
            focusNode = focusNode.right;
         }
         if (focusNode == null) return false;
      }
      if (focusNode.left == null && focusNode.right == null) {
         if (focusNode == root) {
            root = null;
         } else if (isItALeftChild) {
            parent.left = null;
         } else {
            parent.right = null;
         }
      } else if (focusNode.right == null) {
         if (focusNode == root) {
            root = focusNode.left;
         } else if (isItALeftChild) {
            parent.left = focusNode.left;
         } else {
            parent.right = focusNode.right;
         }
      } else if (focusNode.left == null) {
         if (focusNode == root) {
            root = focusNode.right;
         } else if (isItALeftChild) {
            parent.left = focusNode.right;
         } else {
            parent.right = focusNode.left;
         }
      } else {
         Node replacement = getReplacementNode(focusNode);
         if (focusNode == root) {
            root = replacement;
         } else if (isItALeftChild) {
            parent.left = replacement;
         } else {
            parent.right = replacement;
         }
         replacement.left = focusNode.left;
      }
      return true;
   }
   
   public Node getReplacementNode(Node replacedNode) {
      Node replacementParent = replacedNode;
      Node replacement = replacedNode;
      Node focusNode = replacedNode.right;
      while (focusNode != null) {
         replacementParent = replacement;
         replacement = focusNode;
         focusNode = focusNode.left;
      }
      if (replacement != replacedNode.right) {
         replacementParent.left = replacement.right;
         replacement.right = replacedNode.right;
      }
      return replacement;
   }
}

class Node {
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

class IntNode {
   int key;
   
   IntNode left;
   IntNode right;
   
   IntNode(int key) {
      this.key = key;
   }
}