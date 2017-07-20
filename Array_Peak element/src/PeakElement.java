
/* 162. Find Peak Element --> Leet Code
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
    	//compare the ith element with i-1 and i+1 element
    	int len = nums.length;
    	if(len <= 1)
    		return -1;
    	for(int i = 0; i<len; i++) {    		
    		if(i == 0 && nums[i] > nums[i+1]) //first element is greater than 2nd element
    			return i;
    		else if(i == (len-1) && nums[i] > nums[i-1])
    			return i;
    		else if(nums[i] > nums[i+1] && nums[i] > nums[i-1]) // last element is greater than 2nd last element
    			return i;	
    	}
		return -1;
    }
}

class Solution {
	public static void main(String[] args) {
		PeakElement p = new PeakElement();
		//int[] nums = {1, 2, 3, 1};
		//int[] nums = {1, 2, 9,7,4,3,1};
		int[] nums = {9,2,4,7,8,18,12};
		
		System.out.println(p.findPeakElement(nums));
	}
}
