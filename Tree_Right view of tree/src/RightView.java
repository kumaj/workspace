import java.util.ArrayList;
import java.util.Arrays;



/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class RightView {
	 ArrayList<Integer> rightView(TreeNode root) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 if( root == null)
			 return result;
		 
		 // Get the height of the tree
		 int height = Height(root);
		 // create a boolean array.
		 Boolean[] flag = new Boolean[height];
		 Arrays.fill(flag, Boolean.FALSE); // initialize the boolean with false value
		 int levelPos = 0; // indicate at which level the current root is>();
		 getRightView(root, flag, levelPos, result);

		 return result;
	 }
	 
	 private void getRightView(TreeNode root, Boolean[] flag, int levelPos,  ArrayList<Integer> result) {
		 if(root == null)
			 return;
		 // check if the node at this level is not visited, then add it into the result and set the flag as true
		 // it means no other nodes at this level can now be a part of the result.
		 if(flag[levelPos] == false) {
			 result.add(root.val);
			 flag[levelPos] = true;
		 }
		 getRightView(root.right, flag, levelPos + 1, result);
		 getRightView(root.left, flag, levelPos + 1, result);
	}

	private int Height(TreeNode root) {
		 if( root == null)
			 return 0;
		 
		 int left = Height(root.left);
		 int right = Height(root.right);
		 
		 if(left > right)
			 return left + 1;
		 else
			 return right + 1;
	 }
}

class Solution {
	public static void main(String[] args) {
		RightView r = new RightView();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(22);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.right = new TreeNode(44);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.left = new TreeNode(8);
		root.right.right.right.left.left = new TreeNode(9);
		root.right.right.right.left.right = new TreeNode(10);
		
		System.out.println(r.rightView(root));
	}
}
