import java.util.ArrayList;
import java.util.Stack;


/**
 * 
 * @author kumaj04
 * Inorder traversal without recursion
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class InorderTraversal {
	//Inorder traversal without recursion
	//First put all the left nodes inside the stack
	//Then pop an element and check if it has any right element 
	//If yes then put it inside the stack and again check if it has left nodes or not
	public ArrayList<Integer> inOrderTraversal(TreeNode a) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		//Put all the left nodes inside the stack
		TreeNode node = a;
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
		
		//Now check if the popped element has any right child or not
		// if yes then put it inside the stack and loop to its left childs
		while(!stack.isEmpty()) {
			TreeNode poppedElem = stack.pop();
			ret.add(poppedElem.val);
			
			//check if the popped element has any right child
			if(poppedElem.right != null) {
				TreeNode temp = poppedElem.right;
				
				//Now check if it has the left child
				//if it has then put it inside the stack
				while(temp != null) {
					stack.push(temp);
					temp = temp.left;
				} 
			} //if
		} // while
		return ret;	
	}
}

class Solution {
	public static void main(String[] args) {
		
		InorderTraversal in = new InorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		
		System.out.println(in.inOrderTraversal(root));
	}
}
