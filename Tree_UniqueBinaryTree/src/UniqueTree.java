
/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
 */
public class UniqueTree {
    public int numTrees(int n) {
        int sum = 0;
        int res = CountTree(n, sum);
        return res;
    }
    
    private int CountTree(int n, int sum) {
    	if(n <= 1)
    		return 1;
    	//there will be n no of roots from 1 to n
    	for(int i = 1; i<= n; i++) {
    		int left = CountTree(i, sum);
    		int right = CountTree(n-i, sum);
    		sum += left*right;
    	}
    	return sum;
    }
}

class Solution {
	public static void main(String[] args) {
		UniqueTree u = new UniqueTree();
		int n = 3;
		System.out.println(u.numTrees(n));
	}
}
