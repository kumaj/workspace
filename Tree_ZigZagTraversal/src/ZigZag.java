import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


/**
 * 
 * @author kumaj04
 *Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class ZigZag {
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		 if(a == null)
			 return ret;
		 
		 //Use a stack and queue
		 Stack<TreeNode> s1 = new Stack<TreeNode>();
		 LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		 
		 //push the root inside the stack
		 s1.push(a);
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 arr.add(a.val);
		 ret.add(arr);
		 Boolean flag = true;
		 
		 while(true) {
			 while(!s1.isEmpty()) {
				 TreeNode poppedElem = s1.pop();
				 
				 //First insert into RL mode
				 if(flag ==  true) {
					 //insert right then left
					 if(poppedElem.right != null)
						 q.addLast(poppedElem.right);
					 if(poppedElem.left != null)
						 q.addLast(poppedElem.left);
				 } else { // Insert into LR mode
					 //insert left then right
					  if(poppedElem.left != null)
						 q.addLast(poppedElem.left);
					  if(poppedElem.right != null)
							 q.addLast(poppedElem.right);
				 }
			 }
			 
				 //Get all the elements from queue and again put it into stacks
				 ArrayList<Integer> arr2 = null;
				 if(q.isEmpty() == true) 
					  break;
				 else
					 arr2 = new ArrayList<Integer>();
				 
				 while (!q.isEmpty()) {
					TreeNode temp = q.removeFirst();
					arr2.add(temp.val);
					s1.push(temp);
				} 
				 flag = (flag == true) ? false : true;
				 if(arr2 != null)
					 ret.add(arr2);
		 }
		 return ret;
	 }
}

class Solution {
	public static void main(String[] args) {
		
		ZigZag zz = new ZigZag();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);		
		System.out.println(zz.zigzagLevelOrder(root));
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		System.out.println(zz.zigzagLevelOrder(root2));
		
	}
}
