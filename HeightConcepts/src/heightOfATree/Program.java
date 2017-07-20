package heightOfATree;

import maxAndMinOfBinaryTree.MaxAndMin;

public class Program {

	public static void main(String[] args) {
		
		// insert the nodes in the tree
		TreeNode tNode = new TreeNode();
		TreeNode root = null;
		root = tNode.getNewNode(50);
		root.lChild = tNode.getNewNode(40);
		root.rChild = tNode.getNewNode(60);
//		root.lChild.lChild = tNode.getNewNode(30);
//		root.lChild.rChild = tNode.getNewNode(45);
//		root.rChild.lChild = tNode.getNewNode(55);
//		root.rChild.rChild = tNode.getNewNode(65);
//		root.lChild.lChild.lChild = tNode.getNewNode(25);
		
		//let's print the nodes of the tree
		Traversal trv = new Traversal();
		trv.inOrder(root);
		System.out.println("\n");
		
		//Print the node in level order traversal
		trv.levelOrderTraversal(root);
		System.out.println("\n");
		
		//Now print the height of the tree
		Height ht = new Height();
		System.out.println("Height of the tree : " + ht.getHeight(root));
		
		//Get the height of the tree using the level order traversal
		System.out.println("Height of the tree using level order : " + ht.getHeightUsingLevelOrder(root));
		
		//Find the max and min in a binary tree "MaxAndMin.java"
		MaxAndMin maxmin = new MaxAndMin();		
		System.out.println("Max in a Binary Tree : " + maxmin.findMax(root));
		System.out.println("Min in a Binary Tree : " + maxmin.findMin(root));
	}

}
