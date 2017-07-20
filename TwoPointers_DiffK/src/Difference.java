import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * A : [1 3 5] 
    k : 4
    Output : 1
 */
public class Difference {
	public int diffPossible(ArrayList<Integer> a, int b) {
		int i = 0;
		int j = a.size() -1;
		
		while(i < j) {
			int n1 = a.get(i);
			int n2 = a.get(j);
			int diff = n2-n1;
			if(diff == b )
				return 1;
			else if(diff < b)
				i++;
			else
				j--;
		}
		return 0;
	}
}

class Solution {
	public static void main(String[] args) {
		Difference d = new Difference();
		Integer[] a = {1, 2, 3};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
		
		int b = 0;
		
		System.out.println(d.diffPossible(arr, b));
	}
}
