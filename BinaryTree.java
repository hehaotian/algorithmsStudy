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