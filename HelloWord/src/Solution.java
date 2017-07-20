
import java.util.Arrays;

// Definition for binary tree
 class TreeNode {
	int val;
    TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
}
 
public class Solution
{
	static void treeDiameter(int[] values)
	{
		//sort the array and create the BST
		Arrays.sort(values);
		TreeNode rootNode = sortedArrayToBST(values);
		
		//once you get the root node get the diameter of the tree.
		int diameter = getDiameter(rootNode);
		System.out.println(diameter);
		
	}
	
	public static int getDiameter(TreeNode root) {        
	    if (root == null)
	        return 0;

	    int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
	    int leftDiameter = getDiameter(root.left);
	    int rightDiameter = getDiameter(root.right);

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static int getHeight(TreeNode root) {
	    if (root == null)
	        return 0;

	    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
	
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return createBST(num, 0, num.length - 1);
	}
 
	public static TreeNode createBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = createBST(num, start, mid - 1);
		root.right = createBST(num, mid + 1, end);
 
		return root;
	}	
}

class Test
{
	public static void main(String[] args)
	{
		int[] array = { 4,2,3,1};
		Solution.treeDiameter(array);
	}
}
