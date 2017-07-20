/*
 * 
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Invert {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            helper(root);
        }
     
        return root;
    }
    
    private void helper(TreeNode p){
    	 
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;
     
        if(p.left!=null)
            helper(p.left);
     
        if(p.right!=null)
            helper(p.right);
    }
    
    // This my practice method to invert a tree
    public TreeNode invertTree02(TreeNode root) {
    	if(root == null)
    		return null;
    	
    	TreeNode root1 = new TreeNode(root.val);
    	root1.left = invertTree02(root1.right);
    	root1.right = invertTree02(root1.left);
    	return root1;				
    }
    
    public void PreOrder(TreeNode root) {
    	if(root == null)
    		return;
    	
    	System.out.print(root.val + " ");
    	PreOrder(root.left);
    	PreOrder(root.right);
    				
    }
}

class Solution {
	public static void main(String[] args) {
		Invert i = new Invert();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		
		System.out.println("Before Invert");
		i.PreOrder(root);
		TreeNode root1 = i.invertTree02(root);
		System.out.println("\nAfter Invert");
		i.PreOrder(root1);
	}
}
