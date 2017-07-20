//revision date :
	//date : 19th June 15
	// date : 20th June 15
package heightOfATree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {
	
	//Get the height of the tree
	public int getHeight(TreeNode root)
	{
		if(root == null)
			return 0;
		int lHeight = getHeight(root.lChild);
		int rHeight = getHeight(root.rChild);
		
		if(lHeight > rHeight)
			return lHeight + 1;
		else
			return rHeight + 1;
	}
	
	
	//let's use the level order traversal to get the height of the tree
	public int getHeightUsingLevelOrder(TreeNode root)
	{
      if(root == null)
    	  return 0;
		//create a queue and add the root element into it
	   // Basically null marker is used to count
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);
		
		int height = 0;
		while(!que.isEmpty())
		{
			TreeNode tempNode = que.remove();
			if(tempNode == null)
			{
				height++;
				if(!que.isEmpty()) que.add(null);
			}
			else
			{
				if(tempNode.lChild != null)
					que.add(tempNode.lChild);
				
				if(tempNode.rChild != null)
					que.add(tempNode.rChild);
			}
		}
		return height;
	}
	
	//Method to get the height of a node recursively
	//Non-recursive way is easy as we can use the level order traversal.
//	public int getHeightOfNode(TreeNode root, int value)
//	{
//		//If data is found in the tree then get's its height
//		//otherwise return -1
//       int ht =  heightOfNodeHelper(root, value, 0);
//	   return ht;	
//	}
	
	//This program is wrong. I have to think on that later 
//	private int heightOfNodeHelper(TreeNode root, int value, int count)
//	{
//		if(root == null)
//			return 0;
//		
//		count++;
//		if(root.data == value)
//			return count+1;
//		else
//		{
//			int lH = heightOfNodeHelper(root.lChild, value, count);
//			int rH = heightOfNodeHelper(root.rChild, value, count);
//		}
//	}
	
	public void printRootToLeaf(TreeNode root, int[] arr, int count)
	{
		if(root == null)
			return;
		
		//store the elements in the array and increment the count
		arr[count++] = root.data;
		
		//if the node is leaf then print the array
		if(root.lChild == null && root.rChild == null)
		{
			for(int i : arr)
				System.out.println(arr[i] + " ");
		}
			
		printRootToLeaf(root.lChild, arr, count);
		printRootToLeaf(root.rChild, arr, count);
	}
}
