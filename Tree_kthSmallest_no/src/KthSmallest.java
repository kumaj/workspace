 
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
public class KthSmallest {
	private static int counter;
	public int KthSmallest(TreeNode root, int k) {
		//PrintNo(k--); //Can you guess what would be the result here ? What would happen if pre increment is used instead of post increment
		if(root == null)
			return -1;
		if(k == 0)
			return root.val;
		KthSmallest(root.left, k--);
		return KthSmallest(root.right, k--);
	}
	

	
	//Can you guess the value of k ?
/*	private void getKthElement_02(TreeNode root, int k, int result) {
		if(root == null)
			return;
		
		if(k == 0)
			result = root.val;
		
		getKthElement(root.left, k--, result);
		getKthElement(root.right, k--, result);
	}*/
	
	
	public int getKthSmallestNo(TreeNode root, int k) {
		if(root == null)
			return -1;
		TreeNode res = findKthSmallestItem(root, k);
		if(res == null)
			return -1;
		return res.val;
	}
	
	private TreeNode findKthSmallestItem(TreeNode rootNode, int k) {
		  if(rootNode==null){
			  return null;
		  }
		 
		  TreeNode node = findKthSmallestItem(rootNode.left, k);
		   
		  //If counter is not equal to K, then only increment the counter. 
		  //Once counter is equal to K, it means we have found the desired smallest element and no need to increment further, 
		  //Take the back up of the current node as it might be the Kth smallest element we are looking for.  
		  if(counter != k){
			   counter++;
			   node = rootNode;
		  }
		   
		  //This is the place where actual check is going to happen between counter and K, 
		  //If counter matched K, it means we found the node and no need to find further so simply return the found node.
		  if(counter == k){ 
			  return node;
		  }else{
			  return findKthSmallestItem(rootNode.right, k);
		  }
	}
	
	//This is wrong logic. Identify what's wrong with it
	int getKthSmallestElement(TreeNode root, int k) {
		if(root == null)
			return 0;
		getKthSmallestElement(root.left, k);
		k--;
		if(k == 0)
			return root.val;
		return getKthSmallestElement(root.right, k);
	}
}

class Solution {
	public static void main(String[] args) {
		KthSmallest s = new KthSmallest();
		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(3);
		//root2.right = new TreeNode(150);
		root2.left.right = new TreeNode(4);
		//root2.left.right = new TreeNode(75);
		//root2.right.left = new TreeNode(125);
		//root2.right.right = new TreeNode(175);
		
		int k = 1;
		System.out.println(s.getKthSmallestNo(root2, 1));
	}
}