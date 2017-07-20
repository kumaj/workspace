
/**
 * Find the no of unique BST for an user input a.
 * @author kumaj04
 *
 */
public class Tree {
	public int numTrees(int a) {
		if(a==1)
			return 1;
		if(a==2)
			return 2;
		int[] arr = new int[a];
		arr[0] = 1;
		arr[1] = 2;
		int sum = 0;
		for(int i=3; i<=a; i++) {
			for(int j = 1; j <= i; j++) {
				int left = j-1;
				int right = i-j;
				if(left == 0)
					sum = sum + 1*arr[right-1];
				else if(right == 0)
					sum = sum + arr[left-1]*1;
				else
					sum = sum + arr[left-1]*arr[right-1];
			}
			arr[i-1] = sum;
			sum = 0;
		}
		return arr[a-1];
	}
} 

class Solution {
	public static void main(String[] args) {
		Tree t = new Tree();
		System.out.println(t.numTrees(4));
	}
}
