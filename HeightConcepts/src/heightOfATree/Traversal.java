//This class deals with different traversal of the tree
package heightOfATree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
	
	//let's start with the inorder traversal
	public void inOrder(TreeNode root)
	{
		if(root == null)
			return;
		else
		{
			inOrder(root.lChild);
			System.out.print(root.data + " ");
			inOrder(root.rChild);
		}
	}
	
	//Level order traversal of the tree
	public void levelOrderTraversal(TreeNode root)
	{
		//push the root element in the stack
		if(root == null)
			System.out.println("Sorry there is no element in the tree !!");
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		//add the root to the queue
		que.add(root);
		
		while(!que.isEmpty())
		{
			TreeNode tempNode = que.remove();
			System.out.print(tempNode.data + " ");
			
			//get its left and right child and put it in queue
			if(tempNode.lChild != null)
				que.add(tempNode.lChild);
			
			if(tempNode.rChild != null)
				que.add(tempNode.rChild);
		}
		
	}

}
