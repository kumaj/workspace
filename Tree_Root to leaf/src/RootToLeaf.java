
/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class RootToLeaf {

	/**
	 * Method to get the total sum from root to a specific leaf
	 * @param root
	 * @param leafElement
	 * @return
	 */
	public int rootToLeafSum(TreeNode root, int leafElement) {
		// Here we are getting the height of the tree. Can we optimize it here?
		int ht = getTreeHeight(root);
		int[] arr = new int[ht];
		int[] sumArr = new int[1];
		getRootToLeafSum(root, arr, leafElement, 0, sumArr);
		return sumArr[0];
	}
	
	private void getRootToLeafSum(TreeNode root, int[] arr, int leafElement, int index, int[] sumArr) {
		if(root == null)
			return;
		
		arr[index++] = root.val;
		//Reached the leaf node
		if(root.val == leafElement) {
			//traverse the array and calculate the sum
			int totalSum = 0;
			for (int i : arr) {
				totalSum = totalSum + i;
			}
			sumArr[0] = totalSum;
		}
		getRootToLeafSum(root.left, arr, leafElement, index, sumArr);
		getRootToLeafSum(root.right, arr, leafElement, index, sumArr);
	}
	
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * Example :
		Given the below binary tree and sum = 22, == 5->4->11->2
		      5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
	 * @param a
	 * @param b
	 * @return
	 */
	public int hasPathSum(TreeNode a, int b) {
		int ht = getTreeHeight(a);
		int[] arr = new int[ht];
		int[] resultArr = {0};
		getPathSum(a, arr, b, 0, resultArr);
		return resultArr[0];
	}
	
	private void getPathSum(TreeNode root, int[] arr, int b, int index, int[] resultArr) {
		if(root == null)
			return;
		
		arr[index++] = root.val;
		//Reached the leaf node
		if(root.left == null && root.right == null) {
			//traverse the array and calculate the sum
			int totalSum = 0;
			for (int i : arr) {
				totalSum = totalSum + i;
			}
			if(totalSum == b)
				resultArr[0] = 1; 
			
		}
		getRootToLeafSum(root.left, arr, b, index, resultArr);
		getRootToLeafSum(root.right, arr, b, index, resultArr);
	}
	
	/**
	 * Optimized version of version_1. Earlier we are using an array and then getting the 
	 * height of tree. Can we get rid of it and come up with a solution?
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum_2(TreeNode root, int sum) {
		if(root == null)
			return false;
		return hasPathSum_22(root, sum, 0);
	}

	private boolean hasPathSum_22(TreeNode root, int sum, int total) {
		if(root == null)
			return false;
		boolean result = false;
		total = total + root.val;
		if(root.left == null && root.right == null && total == sum )
			result = true;
		result = result || hasPathSum_22(root.left, sum, total);
		result = result || hasPathSum_22(root.right, sum, total);
		return result;
	}
	
	/**
	 * Can we return int instead of returning boolean.
	 * Then checkout what are the changes which are being made.
	 * @param root
	 * @param sum
	 * @return
	 */
	public int hasPathSum_3(TreeNode root, int sum) {
		return hasPathSum_33(root, sum, 0, 0);
	}

	private int hasPathSum_33(TreeNode root, int sum, int total, int val) {
		if(root == null)
			return 0;
		total = total + root.val;
		if(root.left == null && root.right == null && total == sum)
			val = 1;
		int lval = hasPathSum_33(root.left, sum, total, val);
		int rval = hasPathSum_33(root.right, sum, total, val);
		return val;
	}

	private int getTreeHeight(TreeNode root) {
		if(root == null)
			return 0;
		int lh = getTreeHeight(root.left);
		int rh = getTreeHeight(root.right);
		if(lh>rh)
			return lh+1;
		else
			return rh+1;
	}
}

class Solution {
	public static void main(String[] args) {
		RootToLeaf r = new RootToLeaf();
		
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
		
		System.out.println(r.rootToLeafSum(root, 4));
		System.out.println(r.hasPathSum(root, 32));
		System.out.println(r.hasPathSum_2(root, 50));
		System.out.println(r.hasPathSum_3(root, 50));
	}
}
