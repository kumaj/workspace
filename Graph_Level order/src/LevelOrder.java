import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
   return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 * @author kumaj04
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
		ArrayList<ArrayList<Integer>> mainArr = new ArrayList<ArrayList<Integer>>();
		if(a == null)
			return mainArr;
		//Now take a queue and store the elements inside it.
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(a);
		
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(temp.val);
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			mainArr.add(arr);
		}
		return mainArr;
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
