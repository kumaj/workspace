import java.util.Arrays;

/*
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class BalancedTree {
	private static boolean isBalanced = true;
	
	// One way of solving this problem is to use the class level variable 
	// and update its status once height diff is greater than 1.
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }
    
    private int getHeight(TreeNode root) {
    	//find the height of the tree and check if the diff between left and right height is greater than +-1,
    	// then return false(-1)
    	
    	if(root == null)
    		return 0;
    	
    	int lh = getHeight(root.left) + 1;
    	int rh = getHeight(root.right) + 1;
    	
    	if(Math.abs(lh-rh) > 1)
    		isBalanced = false;
    	 return (lh > rh) ? lh: rh;
    }
    
    // Can we solve the same question without class level variable
    public boolean isBalancedTree(TreeNode root) {
    	
    	boolean[] flag = new boolean[1];
    	Arrays.fill(flag, true);
    	IsBalance(new IsBalanceParameter(root, flag));
    	return flag[0];
    }

	private int IsBalance(IsBalanceParameter parameterObject) {
		if (parameterObject.root == null)
			return 0;

		int lh = IsBalance(new IsBalanceParameter(parameterObject.root.left, parameterObject.flags)) + 1;
		int rh = IsBalance(new IsBalanceParameter(parameterObject.root.right, parameterObject.flags)) + 1;

		if (Math.abs(lh - rh) > 1)
			parameterObject.flags[0] = false;
		return (lh > rh) ? lh : rh;
	} 
	
	Boolean isBalancedTree_03(TreeNode root) {
		Boolean isBalancedTree = true;
		getHeightOfTree(root, isBalancedTree);
		if(isBalancedTree)
			return true;
		else 
			return false;
	}
	
	private int getHeightOfTree(TreeNode root, Boolean isBalanced) {
		if(root == null)
			return 0;
		int lh = getHeightOfTree(root.left, true);
		int rh = getHeightOfTree(root.right, true);
		
		if(Math.abs(lh-rh) > 1)
			isBalanced = false;
		return Math.max(lh, rh) + 1;
	}
}

class Solution {
	public static void main(String[] args) {
		BalancedTree b = new BalancedTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4); 
		 root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		/* root.right.right = new TreeNode(7); */

		// System.out.println(b.isBalanced(root));

		System.out.println(b.isBalancedTree_03(root));

	}
}
