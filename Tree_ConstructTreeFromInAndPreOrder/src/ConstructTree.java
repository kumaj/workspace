import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class ConstructTree {
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
    	//conevrt the arraylist into array
    	Integer [] pre = new Integer[preorder.size()];
    	preorder.toArray(pre);
    	
    	Integer[] in = new Integer[inorder.size()];
    	inorder.toArray(in);
    	int preStart = 0;
    	int preEnd = preorder.size() - 1;
    	return constructTree(pre, in, 0, preorder.size()-1, preStart, preEnd);
	}

	private TreeNode constructTree(Integer[] preArr, Integer[] inArr, int start, int end, int preStart, int preEnd) {
		
		if(end - start < 0) return null;
		if(end - start == 0) return new TreeNode(inArr[start]);
		
		int index = findIndex(inArr, preArr[preStart], start, end);
		TreeNode root = new TreeNode(inArr[index]);
		root.left = constructTree(preArr, inArr, start, index -1, preStart+1, preStart+(index-start));
		root.right = constructTree(preArr, inArr, index + 1, end, preStart+(index-start)+1, preEnd);
		return root;
	}

	private int findIndex(Integer[] inArr, Integer preOrderElem, int start, int end) {
		int res = start;
		for(int i = start; i <= end; i++) {
			if(inArr[i] == preOrderElem)
				res = i;
		}
		return res;
		
	}
	
	public void inOrderTrav(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTrav(root.left);
		System.out.print(root.val + " ");
		inOrderTrav(root.right);
	}
	
	public void postOrderTrav(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTrav(root.left);
		inOrderTrav(root.right);
		System.out.print(root.val + " ");
	}
}

class Solution {
	public static void main(String[] args) {
		ConstructTree ct = new ConstructTree();
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		inOrder.add(6);
		inOrder.add(8);
		inOrder.add(10);
		inOrder.add(13);
		inOrder.add(15);
		inOrder.add(17);
		inOrder.add(20);
		inOrder.add(25);
		
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		preOrder.add(15);
		preOrder.add(10);
		preOrder.add(8);
		preOrder.add(6);
		preOrder.add(13);
		preOrder.add(20);
		preOrder.add(17);
		preOrder.add(25);
		
		TreeNode root = ct.buildTree(preOrder, inOrder );
		ct.inOrderTrav(root);
		System.out.println();
		ct.postOrderTrav(root);
	}
	
}