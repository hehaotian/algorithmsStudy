public class BinaryTree {

	Node root;

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman");

		theTree.preOrderTraverseTree(theTree.root);
		System.out.println("Search for 30");
		System.out.println(theTree.findNode(30));
	}

	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return null;
			}
		}
		return focusNode;
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
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					} 
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		boolean isItALeftChild = true;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return false;
			}
		}

		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root) {
				root = null;
			} else if (isItALeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (focusNode.rightChild == null) {
			if (focusNode == root) {
				root = focusNode.leftChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.leftChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}
		}

		if (focusNode.leftChild == null) {
			if (focusNode == root) {
				root = focusNode.rightChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.rightChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}
		} else {
			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root) {
				
			}
		}
	}


	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

}



class Node {
	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return name + " has a key " + key;
	}
}