import java.util.HashSet;
/*
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes 
- Your solution should run in linear time and not take memory more than O(height of T).
- Assume all values in BST are distinct.

Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T2Sum {
    public int t2Sum(TreeNode A, int B) {
    	if(A == null)
    		return 0;
    	
    	HashSet<Integer> set = new HashSet<Integer>();
    	if(IsSum(A, B, set) == true)
    		return 1;
    	else
    		return 0;    		
    }

	private boolean IsSum(TreeNode root, int sum, HashSet<Integer> set) {
		if(root == null)
			return false;
		
		if(set.contains(sum-root.val))
			return true;
		else
			set.add(root.val);
		return IsSum(root.left, sum, set) || IsSum(root.right, sum, set);
	}
}

class Solution {
	public static void main(String[] args) {
		T2Sum t = new T2Sum();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		
		System.out.println(t.t2Sum(root, 4));
	}
}
