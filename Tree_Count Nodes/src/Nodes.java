
/*
 * Count no of nodes in the binary tree
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Nodes {
	
	//Working --> Precise way of getting the count
	 public int countNodes(TreeNode root) {
		if(root == null) 
			return 0;
		
		return countNodes(root.left) + 1 + countNodes(root.right);
	 }
	 
	 //Wrong approach
	 //In recursion get the result for n = 0 and 1 and then try to generalize it
	 public int count(TreeNode root) {
		 if(root == null)
			 return 0;
		 getCount(root, 0);
		 return 0;
	 }
	 
	 // Can you judge the value of count
	private void getCount(TreeNode root, int count) {
		if(root == null)
			return;
		count = count + 1;
		System.out.println("count : " + count + " Root : " + root.val);
		getCount(root.left, count);
		getCount(root.right, count);
	}
	
	//Correct Approach
	public int count_02(TreeNode root) {
		if(root == null)
			return 0;
		int count = 1;
		count = count + count_02(root.left);
		count = count + count_02(root.right);
		return count;
	}
	
	public int count_03(TreeNode root) {
		if(root == null)
			return 0;
		
		int count = 0;
		int lcount = count_03(root.left);
		int rcount = count_03(root.right);
		
		if(lcount == 0 && rcount == 0)
			count = 1;
		else
			count = lcount + rcount;
		
		return count;
		
	}
}

class solution {
	public static void main(String[] args) {
		Nodes n = new Nodes();
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.left = new TreeNode(30);
		root.left.left.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.right.right = new TreeNode(70);
		root.right.right.right = new TreeNode(80);
		
		System.out.println(n.countNodes(root));
		
		System.out.println(n.count(root));
		
		System.out.println(n.count_02(root));
		
		System.out.println(n.count_03(root));
	}
}
