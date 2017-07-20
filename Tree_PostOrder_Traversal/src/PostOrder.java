import java.util.ArrayList;
import java.util.Stack;


/**
 * 
 * @author kumaj04
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class PostOrder {
	//Post order traversal will use 2 stacks 
	public ArrayList<Integer> postOrderTraversal(TreeNode a) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(a == null)
			return ret;
		
		//push the root element into s1
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(a);
		
		while(!s1.isEmpty()) {
			TreeNode node = s1.pop();
			//push it into 2nd stack
			s2.push(node);
			
			//push the left and right node into the s1
			if(node.left != null)
				s1.push(node.left);
			if(node.right != null)
				s1.push(node.right);
		} //while loop
		
		//The resiult is stored in s2
		while (!s2.isEmpty()) {
			ret.add(s2.pop().val);
		} //while loop
		return ret;
	} //function
} // class

class Solution {
	public static void main(String[] args) {
		
		PostOrder ps = new PostOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		//System.out.println(ps.postOrderTraversal(root));
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		System.out.println(ps.postOrderTraversal(root2));
	}
}
