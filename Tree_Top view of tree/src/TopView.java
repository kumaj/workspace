import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Print Nodes in Top View of Binary Tree
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. 
Given a binary tree, print the top view of it. The output nodes can be printed in any order. 
Expected time complexity is O(n)
 */

/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class TopView {
	public ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		
		int position = 0; // this position denotes the root position left--> pos -1
		// right--> pos + 1;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // store the position and its corresponding root node value
		getTopViewElements(root, position, map);
		// Iterate through map and store into result 
		for(Entry<Integer, Integer> entry : map.entrySet())
			result.add(entry.getValue());
		return result;
	}

	private void getTopViewElements(TreeNode root, int position, Map<Integer, Integer> map) {
		if(root == null)
			return;
		
		//insert into the tree map if it's not present
		if(!map.containsKey(position))
			map.put(position, root.val);
		getTopViewElements(root.left, position - 1, map);
		getTopViewElements(root.right, position + 1, map);
	}
}

class Solution {
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		//root.left.right = new TreeNode(22);
		root.left.left = new TreeNode(3);
		//root.left.left.right = new TreeNode(33);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		
		TopView t = new TopView();
		System.out.println(t.topView(root));
	}
}
