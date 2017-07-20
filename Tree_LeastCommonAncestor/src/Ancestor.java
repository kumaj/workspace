


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Ancestor {
	//Interview bit
	public int LeastCommonAncestor(TreeNode root, int a, int b) {
		if(root == null)
			return -1;
		
		if(a < root.val && b < root.val) //move to left subtree
			return LeastCommonAncestor(root.left, a, b);
		
		else if(a > root.val && b > root.val) //move to right subtree
			return LeastCommonAncestor(root.right, a, b);
		else
			return root.val;
	}
	
	//Leetcode
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
			return null;
		
        int ret = LeastCommonAncestor(root, p.val, q.val);
        System.out.println("ret : "+ ret);
        return new TreeNode(ret);
    }
}

class Solution {
	public static void main(String[] args) {
		Ancestor a = new Ancestor();
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.left = new TreeNode(30);
		root.left.left.right = new TreeNode(35);
		root.left.left.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.right.right = new TreeNode(70);
		root.right.right.right = new TreeNode(80);
		
		System.out.println(a.LeastCommonAncestor(root, 80, 35));
		
		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(2);
		root2.right.right = new TreeNode(3);		
		System.out.println(a.lowestCommonAncestor(root2, root2.right, root2.right.right));
	}
}
