import java.util.ArrayList;

/**
 * INVERSIONSBookmark
Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3
as the 3 inversions are (2, 1), (4, 1), (4, 3).
 * @author kumaj04
 *
 */
public class Inversion {
	// This problem has to be solved in nlogn time complexity.
	public int countInversions(ArrayList<Integer> a) {
		int n = a.size();
		int count = 0;
		
		for(int i = 0; i<n-1; i++) {
			for(int j = i+1; j<n; j++){
				if(a.get(i) > a.get(j))
					count++;
			}
		}
		return count;
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
