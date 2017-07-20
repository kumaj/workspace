


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


import java.util.Arrays;
 
public class TreeNode
{
	int val;
    TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
	
	static void treeDiameter(int[] values)
	{
		//sort the array and create the BST
		Arrays.sort(values);
		TreeNode rootNode = sortedArrayToBST(values);
		
		//once you get the root node get the diameter of the tree.
		int diameter = getDiameter(rootNode);
		System.out.println("Diameter : " + diameter);
		
	}
	
	public static int getDiameter(TreeNode root) {        
	    if (root == null)
	        return 0;

	    int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
	    int leftDiameter = getDiameter(root.left);
	    int rightDiameter = getDiameter(root.right);

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static int getHeight(TreeNode root) {
	    if (root == null)
	        return 0;

	    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return createBST(num, 0, num.length - 1);
	}
	
 // Create the Binary search tree using the sorted array
	public static TreeNode createBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		//TreeNode root = TreeNode.getNewNode(num[mid]);
		root.left = createBST(num, start, mid - 1);
		root.right = createBST(num, mid + 1, end);
		return root;
	}	
	
	public static void main(String[] args)
	{
		int[] array = {3,1,6,7,5,4,2};
		treeDiameter(array);
	}
}


