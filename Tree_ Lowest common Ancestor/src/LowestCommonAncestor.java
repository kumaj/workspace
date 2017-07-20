
/**
 * Find the lowest common ancestor for a binary search tree and binary tree.
 * There is a lot of difference between finding the lowest common ancestor between a 
 * binary tree and binary search tree.
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * 
 */
/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class LowestCommonAncestor {

	/**
	 * Method to find the common ancestor in binary tree.
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public int lcaForBST(TreeNode root, int n1, int n2) {
		if(root == null)
			return -1;
		if(root.val == n1 || root.val == n2 || ((n1<root.val)&&(root.val < n2)))
			return root.val;
		
		int val1 = lcaForBST(root.left, n1, n2);
		int val2 =  lcaForBST(root.right, n1, n2);
		
		if(val1 != -1)
			return val1;
		else if(val2 != -1)
			return val2;
		else
			return -1;
	}
	
	/**
	 * Method to get lca for a BINARY tree
	 * To find lca, traverse the tree from root till that node and store all the 
	 * nodes in an array and then do the same thing for other node.
	 * Now compare both the arrays and get the last common element
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public int lca(TreeNode root, int n1, int n2) {
		if(root == null)
			return -1;
		int ht = getTreeHeight(root);
		int[] arr1 = new int[ht];
		int[] arr2 = new int[ht];
	
		//Traverse the tree and get all the elemenst from root node to element
	    int[] arr11 = traverseSubtree(root, n1, arr1, 0);
		int[] arr22 = traverseSubtree(root, n2, arr2, 0);
		//Now compare the two arrays and get the last common elelemnt.
		// common element is the least common ancestor
		return getCommonElement(arr11, arr22);
	}

	/**
	 * 
	 * @param root
	 * @param n
	 * @param arr
	 * @param index
	 */
	private int[] traverseSubtree(TreeNode root, int n, int[] arr, int index) {
		if(root == null)
			return null;
		arr[index++] =  root.val;
		// if the elememt is found
		if(root.val == n) {
			return arr;
		}
		
		int[] arr1 = traverseSubtree(root.left, n, arr, index);
		int[] arr2 = traverseSubtree(root.right, n, arr, index);
		
		if(arr1 == null || arr1.length == 0)
			return null;
		else if(arr2 == null || arr2.length == 0)
			return null;
		else if(arr1.length != 0)
			return arr1;
		else if(arr2.length != 0)
			return arr2;
		else
			return null;
	}
	
	
	/**
	 * Method to get the last common element from the 2 arrays.
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private int getCommonElement(int[] arr1, int[] arr2) {
		int common = -1;
		for (int i : arr1) {
			for (int j : arr2) {
				if(i == j) {
					common = i;
				}
			}
		}
		return common;
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
	

	/**
	 * http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/
	 * This is the copied version of the solution. I failed to come up with my own solution.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
/*	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null)
	        return null;
	 
	    if(root==p || root==q)
	        return root;
	 
	    TreeNode l = lowestCommonAncestor(root.left, p, q);
	    TreeNode r = lowestCommonAncestor(root.right, p, q);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	}*/
	
	/**
	 * https://discuss.leetcode.com/topic/27479/java-python-iterative-solution
	 * https://discuss.leetcode.com/topic/18566/my-java-solution-which-is-easy-to-understand/5
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || root == p || root == q )
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
        
    }
	
	public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if( root == null || root.val == p || root.val == q )
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
        
    }
	
}

class Solution {
	public static void main(String[] args) {
		LowestCommonAncestor l = new LowestCommonAncestor();
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);

		System.out.println(l.lcaForBST(root, 10, 14));
		//System.out.println(l.lca(root, 10, 14)); // Null pointer exception
		
		TreeNode result = l.lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
		System.out.println(result.val);
		
		TreeNode res2 = l.lowestCommonAncestor(root, 10, 14);
		System.out.println(res2.val);
	}
}
