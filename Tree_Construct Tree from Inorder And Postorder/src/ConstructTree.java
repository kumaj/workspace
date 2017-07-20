import java.util.ArrayList;


/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class ConstructTree {

	public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder) {
		if(postorder.size() == 0 || inorder.size() == 0)
			return null;
		TreeNode root = null;
		root = constructTree(root, postorder, inorder, 0, inorder.size()-1, postorder.size()-1);
		return root;
	}
	
	private TreeNode constructTree(TreeNode root, ArrayList<Integer> postorder, ArrayList<Integer> inorder, int start, int end, int postEnd) {
		if((start > end) || (end < 0))
			return null;
		int postorderElem = postorder.remove(postorder.size()-1);
		//Get the position of this element in inorder
		int inorderPos = getPosition(inorder, postorderElem, start, end);
		TreeNode newNode = new TreeNode(postorderElem);
		
		//Add the right and left subtree
		newNode.right = constructTree(root, postorder, inorder, inorderPos+1, end, postEnd-1);
		newNode.left = constructTree(root, postorder, inorder, start, inorderPos-1, postEnd-1);
		root = newNode;
		return root;
	}

	private int getPosition(ArrayList<Integer> inorder, int postOrderElem, int start, int end) {
		for(int i = start; i<=end; i++) {
			if(inorder.get(i) == postOrderElem)
				return i;
		}
		return -1;
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		inOrder(root.right);
		System.out.print(root.val + " ");
	}
}



class Solution {
	public static void main(String[] args) {
		ConstructTree t = new ConstructTree();
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		//preOrder.add(10); preOrder.add(5); preOrder.add(20); preOrder.add(15); preOrder.add(25);
		//inOrder.add(5); inOrder.add(10);inOrder.add(15); inOrder.add(20); inOrder.add(25);
		postOrder.add(2); postOrder.add(3); postOrder.add(1);
		inOrder.add(2); inOrder.add(1); inOrder.add(3);
		
		TreeNode root = null;
		root = t.buildTree(postOrder, inOrder);
		System.out.print("Inorder   : ");
		t.inOrder(root);
		System.out.println();
		System.out.print("Postorder : ");
		t.postOrder(root);
		System.out.println();
		System.out.print("Preorder  : ");
		t.preOrder(root);
	}
}