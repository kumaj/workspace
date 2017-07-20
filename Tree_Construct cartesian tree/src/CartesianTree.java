import java.util.ArrayList;


/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 * http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 * Input: inorder[] = {1, 5, 10, 40, 30, 
                    15, 28, 20}
Output: root of following tree
          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20
 * @author kumaj04
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
 
public class CartesianTree {
	 public TreeNode buildTree(ArrayList<Integer> a) {
		if(a.size() == 0)
			return null;
		TreeNode root = null;
		root = createTree(root, a, 0, a.size()-1);
		return root;
	 }
	 
	 
	 
	private TreeNode createTree(TreeNode root, ArrayList<Integer> arr, int start, int end) {
		if((start > end) || (end < 0))
			return root;
		//Find the max element from the array. max element will become the root element
		int maxElementPosition = getMaxElementPosition(arr, start, end);
		TreeNode newNode = new TreeNode(arr.get(maxElementPosition));
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
		createTree(root, arr, start, maxElementPosition-1);
		return createTree(root, arr, maxElementPosition+1, end);
	}

	/**
	 * Method to return the maximum element from the arraylist
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int getMaxElementPosition(ArrayList<Integer> arr, int start, int end) {
		int max = Integer.MIN_VALUE;
		int position = -1;
		for(int i=start; i<=end; i++ ) {
			if(arr.get(i) > max) {
				max = arr.get(i);
				position = i;
			}
		}
		return position;
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
		CartesianTree t = new CartesianTree();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1); arr.add(5); arr.add(10); arr.add(40); arr.add(30); arr.add(15); arr.add(28); arr.add(20);
		TreeNode root = t.buildTree(arr);
		t.inOrder(root);
		
	}
}
