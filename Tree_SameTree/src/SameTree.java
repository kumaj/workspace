
/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class SameTree {
	
	public int isSameTree(TreeNode a, TreeNode b) {
		if(IsSame(a, b) == true)
			return 1;
		else
			return 0;
	}
	private boolean IsSame(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null && root2!= null)
			return false;
		if(root1 != null && root2 == null)
			return false;
		
		if(root1.val == root2.val && IsSame(root1.left, root2.left) && IsSame(root1.right, root2.right))
			return true;
		else
			return false;
	}
	
	public int isIdenticalTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return 1;
		
		if(root1 == null && root2!= null)
			return 0;
		if(root1 != null && root2 == null)
			return 0;
		
		if(root1.val == root2.val && IsSame(root1.left, root2.left) && IsSame(root1.right, root2.right))
			return 1;
		else
			return 0;
	}
}

class Solution {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.left.left = new TreeNode(4);
		root1.right = new TreeNode(5);
		root1.right.right = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		root2.left.left.left = new TreeNode(4);
		root2.right = new TreeNode(5);
		root2.right.right = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		
		SameTree s = new SameTree();
		System.out.println(s.isSameTree(root1, root2));
		
		System.out.println(s.isIdenticalTree(root1, root2));
	}
}
