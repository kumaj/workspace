
/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * Definition for a binary tree node.
 *  */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        int val = 0;
        if(hasSum(root, sum ,val) == true)
        	return true;
        else
        	return false;
    }

	private boolean hasSum(TreeNode root, int sum, int val) {
		if(root == null)
			return false; //change the return value as false
		val = val + root.val;
		
		if(val == sum && root.left == null && root.right == null)
			return true;
		return hasSum(root.left, sum, val) || hasSum(root.right, sum, val); //What will happpen when && is used. Please check its very interesting case.
	}
}

class Solution {
	public static void main(String[] args) {
		PathSum p = new PathSum();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		//root.right.right = new TreeNode(7);
		
		System.out.println(p.hasPathSum(root, 13));
	}
}
