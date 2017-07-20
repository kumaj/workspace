import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TotalSum {
    public int sumNumbers(TreeNode root) {
        int i = 0;
        int sum = 0;
        List<Integer> ll = new ArrayList<Integer>();
    	if(root == null)
    		return 0;
    	
        Integer[] temp = new Integer[50];
        getSum(root, sum, temp, i, ll);
        int total = 0;
        for (Integer no : ll) {
			total = total + no;
		}
        return total;
    }
    
    private void getSum(TreeNode root, int sum, Integer[] temp, int i, List<Integer> ll) {
    	if(root == null)
    		return;
    	temp[i++] = root.val; //store it in array
    	if(root.left == null && root.right == null) { // if it is a leaf node
    		int index = i-1;
    		int multiplier = 1;
    		while(index >= 0) {
    			sum = sum + multiplier*temp[index];
    			multiplier = multiplier*10;
    			index--;
    		}
    		ll.add(sum);
    	}
    	getSum(root.left, sum, temp, i, ll);
    	getSum(root.right, sum, temp, i, ll);   	
    }
    
    //Another thought process using the string process
    //But it's not working as per the expectation. Find out why?
    public int sumNumbers_02(TreeNode root) {
        int i = 0;
        int sum = 0;
        List<StringBuilder> ll = new ArrayList<StringBuilder>();
    	if(root == null)
    		return 0;
    	
        StringBuilder str = new StringBuilder();
        getSum_02(root, sum, str, i, ll);
        int total = 0;
        for (StringBuilder strr: ll) {
			total = total + Integer.valueOf(strr.toString());
		}
        return total;
    }
    
    private void getSum_02(TreeNode root, int sum, StringBuilder str, int i, List<StringBuilder> ll) {
    	if(root == null)
    		return;
    	str = str.append(root.val);
    	if(root.left == null && root.right == null) { // if it is a leaf node
    		ll.add(str);
    	}
    	getSum_02(root.left, sum, str, i, ll);
    	getSum_02(root.right, sum, str, i, ll);   	
    }
    
    //Best Approach to solve the problem
    public int sumNumbers_03(TreeNode root) {
    	return getSum_03(root, 0)%1003;
    }

	private int getSum_03(TreeNode root, int val) {
		if(root == null)
			return 0;
		val = (val*10 + root.val);
		
		if(root.left == null && root.right == null)
			return val;
		
		return (getSum_03(root.left, val) + getSum_03(root.right, val))%1003;
	}
}

class Solution {
	public static void main(String[] args) {
		TotalSum t = new TotalSum();
		
		TreeNode root = new TreeNode(1123);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		
		System.out.println(t.sumNumbers_03(root));
	}
}
