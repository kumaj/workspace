
/**
 *  Convert Sorted Array to Binary Search Tree
 *  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class ArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        
    	if(nums.length == 0)
    		return null;
    	
    	if(nums.length == 1)
    		return new TreeNode(nums[0]);
    	
    	int start = 0;
    	int end = nums.length-1;
    	TreeNode root = null;
    	root = sortedArrayToBST2(root, nums, start, end);
    	return root;
    }
	
	private TreeNode sortedArrayToBST2(TreeNode root, int[] nums, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end)/2;

		TreeNode treeRoot = InsertNode(root, nums[mid]);
		sortedArrayToBST2(treeRoot, nums, start, mid-1); //first half
		sortedArrayToBST2(treeRoot, nums, mid+1, end);
		return treeRoot;
	}
	
	//Working fine...just another version of above. here root always remain null.
	//It will not work if we pass root as an argument to sortedArrayToBST2(treeRoot, nums, start, mid-1);
/*	private TreeNode sortedArrayToBST2(TreeNode root, int[] nums, int start, int end) {
		if(start > end)
			return root;
		int mid = (start + end)/2;

		TreeNode treeRoot = InsertNode(root, nums[mid]);
		sortedArrayToBST2(treeRoot, nums, start, mid-1); //first half
		sortedArrayToBST2(treeRoot, nums, mid+1, end);
		return treeRoot;
	}*/
	
    
	//Working fine...just another version of above
/*	private TreeNode sortedArrayToBST2(TreeNode root, int[] nums, int start, int end) {
		if(start > end)
			return root;
		int mid = (start + end)/2;

		TreeNode treeRoot = InsertNode(root, nums[mid]);
		sortedArrayToBST2(treeRoot, nums, start, mid-1); //first half
		return sortedArrayToBST2(treeRoot, nums, mid+1, end);
	}*/
	
	/* Not working as root is always null
	private TreeNode sortedArrayToBST2(TreeNode root, int[] nums, int start, int end) {
	if(start > end)
		return root;
	int mid = (start + end)/2;

	InsertNode(root, nums[mid]);
	sortedArrayToBST2(root, nums, start, mid-1); //first half
	sortedArrayToBST2(root, nums, mid+1, end);
	return root;
}*/
	
	//Can we print the mid element using recursion
	public void midElement(TreeNode root, int[] nums, int start, int end) {
		if(start > end)
			return;
		int mid = (start + end)/2;
		System.out.println(nums[mid]);
		//TreeNode treeRoot = InsertNode(root, nums[mid]);
		midElement(root, nums, start, mid-1); //first half
		midElement(root, nums, mid+1, end); // 2nd half
	}
	
	private TreeNode InsertNode(TreeNode root, int data) {
		TreeNode newNode = new TreeNode(data);
		if(root == null) {
			root = newNode;
		} else {
			TreeNode prev = null;
			TreeNode curr = root;
			
			//Find the ideal node to insert
			while(curr != null) {
				if(curr.val < data) {
					prev = curr;
					curr = curr.right;
				}
				else {
					prev = curr;
					curr = curr.left;
				}
			}
			
			//Insert the node here
			if(prev.val < data)
				prev.right = newNode;
			else
				prev.left = newNode;
		} //else
		return root;
	}
}

class Solution {
	public static void main(String[] args) {
		ArrayToBinaryTree a = new ArrayToBinaryTree();
		int[] nums = {0,1,2,3,4,5,6,7,8,9};
		int start = 0;
		int end = 9;
		TreeNode root = null;
		//a.midElement(root, nums, start, end);
		
		a.sortedArrayToBST(nums);
		
	}
	
}
