import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Tree {
	
	public TreeNode constructTreeForSortedArray(TreeNode root, List<Integer> arr2) {
		if(arr2.size() == 0)
			return null;
		else
			return createTreeForSortedArray(root, arr2, 0, arr2.size()-1);
	}
	
	
	private TreeNode createTreeForSortedArray(TreeNode root, List<Integer> arr2, int start, int end) {
		if((start > end) || (end < 0 ))
			return root;
		int mid = (start+end)/2;
		TreeNode newNode = new TreeNode(arr2.get(mid));
		if(root == null) {
			root = newNode;
		} else {
			//Search the valid node where the new node has to be hooked.
			TreeNode curr = root;
			TreeNode prev = null;
			//Go to the leaf node 
			while(curr != null) {
				if(newNode.val < curr.val) {
					prev = curr;
					curr = curr.left;
				} else {
					prev = curr;
					curr = curr.right;
				}
			}
			
			if(newNode.val < prev.val)
				prev.left = newNode; 
			else
				prev.right = newNode;	
		}
		createTreeForSortedArray(root, arr2, start, mid-1);
		return createTreeForSortedArray(root, arr2, mid+1, end);
	}


	public TreeNode constructTree(TreeNode root, int[] arr) {
		if(arr.length == 0) 
			return null;
		else
			return createTree(root, arr, 0, arr.length-1);
	}
	
	private TreeNode createTree(TreeNode root, int[] arr, int start, int end) {
		if(start > end)
			return root;
		//create a new Node first with the starting element
		TreeNode newNode = new TreeNode(arr[start]);
		// If this is the fisrt time node is created
		if(root == null)
			root = newNode;
		else {
			//Search the valid node where the new node has to be hooked.
			TreeNode curr = root;
			TreeNode prev = null;
			//Go to the leaf node 
			while(curr != null) {
				if(newNode.val < curr.val) {
					prev = curr;
					curr = curr.left;
				} else {
					prev = curr;
					curr = curr.right;
				}
			}
			
			if(newNode.val < prev.val)
				prev.left = newNode; 
			else
				prev.right = newNode;
				
		}
		return createTree(root, arr, ++start, end);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
}


class Solution {
	public static void main(String[] args) {
		//Create a bst 
		Tree t = new Tree();
		int[] arr = {2,1,3,4};
		TreeNode root = null;
		root = t.constructTree(root, arr);
		//Do an inorder traversal to print the nodes
		//t.inOrder(root);
		
		List<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(1); arr2.add(2); arr2.add(3); arr2.add(4); arr2.add(5);
		TreeNode root2 = null;
		root2 = t.constructTreeForSortedArray(root2, arr2);
		t.inOrder(root2);
	}
}
