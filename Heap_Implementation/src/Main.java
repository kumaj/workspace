/**
 * Driver class to test the heapification
 * @author kumaj04
 *
 */
public class Main {
	public static void main(String[] args) {
		
		//Tree is already get constructed and do the heapification of the tree.
		// The tree should ne almost complete tree.
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		
		HeapTree h = new HeapTree();
		System.out.println("Before max heapification");
		h.preOrderTraversal(root);
		h.trickleUp(root, -1, null); // Max heap
		System.out.println("\nAfter max heapification");
		h.preOrderTraversal(root);
		
		// test case 2
		TreeNode root2 = new TreeNode(50);
		root2.left = new TreeNode(40);
		root2.left.left = new TreeNode(30);
		root2.left.left.left = new TreeNode(20);
		root2.right = new TreeNode(60);
		root2.right.right = new TreeNode(70);
		root2.right.right.right = new TreeNode(80);
		System.out.println("\nBefore max heapification");
		h.preOrderTraversal(root2);
		h.trickleUp(root2, -1, null); // Max heap
		System.out.println("\nAfter max heapification");
		h.preOrderTraversal(root2);
	}
}
