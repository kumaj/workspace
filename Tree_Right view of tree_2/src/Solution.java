/**
 * Driver class to test the code
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		RightView r = new RightView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		
/*		TreeNode root = new TreeNode(1);
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
		root.right.right.right.left.right = new TreeNode(10);*/
		
/*		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.left = new TreeNode(30);
		root.left.left.right = new TreeNode(35);
		root.left.left.left = new TreeNode(20);
		root.left.left.left.right = new TreeNode(90);
		root.right = new TreeNode(60);
		root.right.right = new TreeNode(70);
		root.right.right.left = new TreeNode(100);
		root.right.right.left.left = new TreeNode(110);
		root.right.right.left.left.right = new TreeNode(120);
		root.right.right.right = new TreeNode(80);*/
		
		
		System.out.println(r.getRightView(root));
		System.out.println(r.getRightView_02(root));
		
	}
}
