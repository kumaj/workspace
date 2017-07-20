/**
 * 
 * @author kumaj04
 * Get all tree nodes which lie in the vertical line
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class VerticalNodes {

	public void getVerticalNodes(TreeNode root, int k) {
		int count = 0;
		printVerticalNodes(root, k, count); 
	}

	private void printVerticalNodes(TreeNode root, int k, int count) {
		if(root == null)
			return;
		if(count == k)
			System.out.println(root.val);

		if(root.left != null)
			printVerticalNodes(root.left, k, --count);
		if(root.right != null)
			printVerticalNodes(root.right, k, ++count);
	}
}

class Solution {
	public static void main(String[] args) {
		VerticalNodes vt = new VerticalNodes();
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.right = new TreeNode(90);
		root.left.right.left = new TreeNode(110);
		root.left.left = new TreeNode(30);
		/*		root.left.left.right = new TreeNode(100);
		root.left.left.right.left = new TreeNode(120);
		root.left.left.right.left.left = new TreeNode(130);
		root.left.left.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.right.left = new TreeNode(140);
		root.right.left.left = new TreeNode(150);
		root.right.left.left.left = new TreeNode(160);
		root.right.left.left.left.right = new TreeNode(170);
		root.right.right = new TreeNode(70);
		root.right.right.left = new TreeNode(180);
		root.right.right.left.left = new TreeNode(190);
		root.right.right.left.left.right = new TreeNode(200);
		root.right.right.right = new TreeNode(80);*/
		
		vt.getVerticalNodes(root, -1);
	}
}
