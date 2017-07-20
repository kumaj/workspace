import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        int val = 0;
        int i = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(root == null)
    		return list;
    	
        Integer[] temp = new Integer[50];
        getPath(root, sum, val, list, temp, i);
        return list;
    }

	private void getPath(TreeNode root, int sum, int val, List<List<Integer>> list, Integer[] temp, int i) {
		if(root == null)
			return;
		val = val + root.val;
		temp[i++] = root.val;
		if(val == sum && root.left == null && root.right == null) {
			int index = 0;
			Integer[] arr = new Integer[i];
			while(index < i) {
				arr[index] = temp[index];
				index++;
			}
			list.add(Arrays.asList(arr));
		}
		getPath(root.left, sum, val, list, temp, i);
		getPath(root.right, sum, val, list, temp, i);
		
	}
	
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		
		return lh > rh ?lh+1 : rh+1;
	}
	
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		return getminDepth(root, root.val) + 1;
	}
	
	private int getminDepth(TreeNode root, int rootVal) {
		if(root == null)
			return 0;
		
		int lh = getminDepth(root.left, rootVal);
		int rh = getminDepth(root.right, rootVal);
		
		if(root != null && root.val == rootVal)
			return Math.min(lh, rh);
		
		return lh > rh ? lh+1 : rh+1;
	}
	
	public int minimumDepth(TreeNode root) {
	     // Corner case. Should never be hit unless the code is 
	    // called on root = NULL
	    if (root == null)
	        return 0;
	  
	    // Base case : Leaf Node. This accounts for height = 1.
	    if (root.left == null && root.right == null)
	       return 1;
	  
	    // If left subtree is NULL, recur for right subtree
	    if (root.left != null)
	       return minimumDepth(root.right) + 1;
	  
	    // If right subtree is NULL, recur for right subtree
	    if (root.right != null)
	       return minimumDepth(root.left) + 1;
	  
	    return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;
	}
	
	public int minDepth_02(TreeNode root) {
        if(root == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){
                return count;
            }
        }
 
        return 0;
    }
}

class Solution {
	public static void main(String[] args) {
		PathSum p = new PathSum();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(4);
		
/*		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);*/
		
		System.out.println(p.pathSum(root, 10));
		
		System.out.println(p.maxDepth(root));
		
		System.out.println(p.minDepth(root));
		System.out.println(p.minDepth_02(root));
	}
}
