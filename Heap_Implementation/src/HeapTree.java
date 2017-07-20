/**
 * Class to do the heapification of the tree.
 * Min heap means the root element will have the value less than its left and right child.
 * Max heap means the root node value is less than its left and right child.
 * @author kumaj04
 *
 */
public class HeapTree {

	/**
	 * Method for max heapification
	 * @param root
	 * @param max
	 */
	public void trickleUp(TreeNode root, int max, String str) {
		if(root == null)
			return;
		
		if(root.left != null && root.left.val > root.val) {
			max = root.left.val;
			str = "left";
		}
		if(root.right != null && root.right.val > max) {
			max = root.right.val;
			str = "right";
		}
		//swap the root element with max element
		if(str != null) {
			int temp = root.val;
			root.val = max;
			if("left".equals(str))
				root.left.val = temp;
			else
				root.right.val = temp;
		}
		
		trickleUp(root.left, max, null);
		trickleUp(root.right, max, null);
	}

	/**
	 * Method for min heap heapification
	 * @param root
	 */
	public void trickleDown(TreeNode root) {
		
	}
	
	/**
	 * Inorder traversal of the tree
	 * @param root
	 */
	public void preOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

}
