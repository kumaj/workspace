import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
 * @author kumaj04
 *
 */
/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class TreeConstruct {
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
		if(preorder.size() == 0 || inorder.size() == 0)
			return null;
		TreeNode root = null;
		root = constructTree(root, preorder, inorder, 0, preorder.size()-1);
		return root;
	}
	
	/**
	 * This method will create the binary tree. Not binary search tree.
	 * @param root
	 * @param preorder
	 * @param inorder
	 * @param start
	 * @param end
	 * @return
	 */
	private TreeNode constructTree(TreeNode root, ArrayList<Integer> preorder, ArrayList<Integer> inorder, int start, int end) {
		if((start > end) || (end < 0 ))
			return null;
		int preOrderElem = preorder.remove(0);
		int inOrderPosition = getPosition(inorder, preOrderElem, start, end);
		TreeNode newNode = new TreeNode(inorder.get(inOrderPosition));
		
		newNode.left = constructTree(root, preorder, inorder, start, inOrderPosition-1);
		newNode.right = constructTree(root, preorder, inorder, inOrderPosition+1, end);
		root = newNode;
		return root;
	}

	/**
	 * This method will create binary SEARCH tree. But we have to create a binary tree not search tree.
	 * @param root
	 * @param preorder
	 * @param inorder
	 * @param start
	 * @param end
	 * @return
	 */
	private TreeNode constructTree2(TreeNode root, ArrayList<Integer> preorder, ArrayList<Integer> inorder, int start, int end) {
		if((start > end) || (end < 0 ))
			return root;
		int preOrderElem = preorder.remove(0);
		//Find the position of this element in inorder arraylist. It will become the root element
		// left half will become the left node and right half will become right node of the tree.
		int inOrderPosition = getPosition(inorder, preOrderElem, start, end);
		TreeNode newNode = new TreeNode(inorder.get(inOrderPosition));
		if(root == null)
			root = newNode;
		else {
			//Search the valid node where the new node has to be hooked.
			TreeNode curr = root;
			TreeNode prev = null;
			//Go to the leaf node 
			while(curr != null) {
				if(newNode.val < curr.val) {
					prev = curr;
					curr = curr.left;
				} else {
					prev = curr;
					curr = curr.right;
				}
			}
			
			if(newNode.val < prev.val)
				prev.left = newNode; 
			else
				prev.right = newNode;	
		}
		constructTree2(root, preorder, inorder, start, inOrderPosition-1);
		return constructTree2(root, preorder, inorder, inOrderPosition+1, end);
	}

	private int getPosition(ArrayList<Integer> inorder, int preOrderElem, int start, int end) {
		for(int i = start; i<=end; i++) {
			if(inorder.get(i) == preOrderElem)
				return i;
		}
		return -1;
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		inOrder(root.right);
		System.out.print(root.val + " ");
	}
}

class Solution {
	public static void main(String[] args) {
		TreeConstruct t = new TreeConstruct();
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		//preOrder.add(10); preOrder.add(5); preOrder.add(20); preOrder.add(15); preOrder.add(25);
		//inOrder.add(5); inOrder.add(10);inOrder.add(15); inOrder.add(20); inOrder.add(25);
		preOrder.add(1); preOrder.add(2); preOrder.add(3);
		inOrder.add(2); inOrder.add(1); inOrder.add(3);
		
		TreeNode root = null;
		root = t.buildTree(preOrder, inOrder);
		System.out.print("Inorder   : ");
		t.inOrder(root);
		System.out.println();
		System.out.print("Postorder : ");
		t.postOrder(root);
		System.out.println();
		System.out.print("Preorder  : ");
		t.preOrder(root);
	}
}
