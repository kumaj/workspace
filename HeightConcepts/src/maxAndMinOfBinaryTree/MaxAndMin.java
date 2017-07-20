//find the maximum and minimum in a binary tree

package maxAndMinOfBinaryTree;

import heightOfATree.TreeNode;

public class MaxAndMin {
	
	public int findMax(TreeNode root)
	{
		// if we any traversal then we can find the max in a binary tree
		//let's do the preOrder traversal 
		
		if(root == null)
			return -1;
		int max = root.data;
		findMaxUtil(root, max);
		return max;
		
	}
	
	public int findMin(TreeNode root)
	{
		// if we do any traversal then we can find the max in a binary tree
		//let's do the InOrder traversal 
		
		if(root == null)
			return -1;
		int min = root.data;
		findMinUtil(root, min);
		return min;
		
	}
	
	private void findMaxUtil(TreeNode root,int max)
	{
		if(root == null)
			return;
		
		findMaxUtil(root.lChild, max);
		//check the max
		if(root.data > max)
			max = root.data;
		findMaxUtil(root.rChild, max);	
	}
	
	private void findMinUtil(TreeNode root,int min)
	{
		if(root == null)
			return;
		
		findMinUtil(root.lChild, min);
		//check the min
		if(root.data < min)
			min = root.data;
		findMinUtil(root.rChild,min);	
	}
}
