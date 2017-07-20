
/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
     
public class Symmetry {
	public int IsSymmetry(TreeNode a) {
		if(isSym(a, a) == true)
			return 1;
		else
			return 0;
	}
	
	private boolean isSym(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null && root2 != null)
			return false;
		
		if(root1 != null && root2 == null)
			return false;
		
		if(root1.val == root2.val && isSym(root1.left, root2.right) && isSym(root1.right, root2.left))
			return true;
		else
			return false;
	}
}

class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		Symmetry s = new Symmetry();
		System.out.println(s.IsSymmetry(root));
	}
}
