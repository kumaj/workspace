import java.util.ArrayList;

/**
 * Print all the nodes on which the light of a torch falls.
 * The torch has been placed at the right side of the tree
 * @author kumaj04
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		this.val = x;
	}
}

public class RightView {
	int height2 = 0;
	//Working solution
	public ArrayList<Integer> getRightView(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if(root == null)
			return arr;
		ArrayList<Integer> height = new ArrayList<Integer>();
		getRightNodes(root, arr, 0, height);
		return arr;
	}
	private void getRightNodes(TreeNode root, ArrayList<Integer> arr, int i, ArrayList<Integer> height) {
		if(root == null)
			return;
		if(height.size() > 0 && i > height.get(0)) {
			arr.add(root.val);
			height.remove(0);
			height.add(i);
		} else if(height.size() == 0) { // first time
			arr.add(root.val);
			height.add(i);
		}
		i++;
		getRightNodes(root.right, arr, i, height);
		getRightNodes(root.left, arr, i, height);
	}
	
	// Not working
	public ArrayList<Integer> getRightView_02(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if(root == null)
			return arr;
		getRightNodes_02(root, arr, 0, height2);
		return arr;
	}
	
	private void getRightNodes_02(TreeNode root, ArrayList<Integer> arr, int i, int height) {
		if(root == null)
			return;
		if(i >= height) {
			arr.add(root.val);
			height = i;
		}
		i++;
		getRightNodes_02(root.right, arr, i, height);
		getRightNodes_02(root.left, arr, i, height);
	}
}
