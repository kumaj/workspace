import java.util.ArrayList;
import java.util.Arrays;


/* IB :: Two pointers--> Merge Two Sorted Lists II
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
 */
public class Merge {
	//IB
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int m = a.size();
		int n = b.size();
    	int i = m - 1;
    	int j = n - 1;
    	int k = m + n - 1;
     
    	while (k >= 0) {
    		if (j < 0 || (i >= 0 && a.get(i) <= b.get(j)))
    			a.set(k--, a.get(i--));
    		else
    			a.set(k--, b.get(j--));
    	}
	}
}

class Solution {
	public static void main(String[] args) {
		
		Merge m = new Merge();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(-4);
		a.add(3);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(-2);
		b.add(-2);
		
		m.merge(a, b);
	}
}