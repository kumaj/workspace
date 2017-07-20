import java.util.ArrayList;


/**
 * Longest Increasing Subsequence
 * @author kumaj04
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class IncreasingSequence {
	public int lengthOfLIS(int[] nums) {
		
		int n = nums.length;
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		int count = 0;
		int max_count = 0;
		int[] temp = new int[n];
		temp[0] = 1;
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(nums[j] < nums[i]) {
					//get the count
					if(temp[j] > count)
						count = temp[j];
				} //outer if 
			} // inner for
			temp[i] = count + 1;
			if(count > max_count)
				max_count = count;
			count = 0;
		} // outer for
		return max_count+1;
    }
	
	
	public int lengthOfLIS(ArrayList<Integer> a) {
		
		int n = a.size();
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		int count = 0;
		int max_count = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(a.get(j) < a.get(i)) {
					//get the count
					if(temp.get(j) > count)
						count = temp.get(j);
				} //outer if 
			} // inner for
			temp.add(count + 1);
			if(count > max_count)
				max_count = count;
			count = 0;
		} // outer for
		return max_count+1;
    }
}

class Solution {
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		IncreasingSequence in = new IncreasingSequence();
		System.out.println(in.lengthOfLIS(nums));
		
		int[] nums2 = {1,3,6,7,9,4,10,5,6};
		System.out.println(in.lengthOfLIS(nums2));
	}
}
