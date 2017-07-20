import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Traversal {
	//PreOrder traversal using recursion
	public void PreOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val);
		PreOrder(root.left);
		PreOrder(root.right);
	}
	
	//PreOrder traversal without recursion
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(a);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			arr.add(node.val);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		return arr;
	}
	
	//Inoreder traversal using recursion
	public void InOrder(TreeNode root) {
		if(root == null)
			return;
		InOrder(root.left);
		System.out.print(root.val);
		InOrder(root.right);
	}
	
	//InOrder traversal without recursion.
	public ArrayList<Integer> preorderTraversal_2(TreeNode a) {
		return null;
		
	}
	public void PostOrder(TreeNode root) {
		if(root == null)
			return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.val);
	}
}

class Solution {
	public static void main(String[] args) {
		Traversal t = new Traversal();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		
		t.PreOrder(root);
		System.out.println();
		t.InOrder(root);
		System.out.println();
		t.PostOrder(root);
	}
}
