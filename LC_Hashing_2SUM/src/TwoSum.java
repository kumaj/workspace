import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/* Hashing: Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //insert all the elements in the hashtable
    	int len = nums.length;
    	int[] res = new int[2];
    	HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
    	for(int i = 0; i < len; i++) {
    		int diff = target-nums[i];
    		if(h.containsKey(diff)) {
    			int index1 = h.get(diff);
    			res[0] = index1 + 1;
    			res[1] = i + 1;
    			break;
    		} else	
    			h.put(nums[i], i); //store the no and its corresponding no.
    	}
    	return res;
    }
    
    
	 //This is the InterviewBit question
    /*
     * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
     */
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		//use the hashing technique
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int len = a.size();
		Integer min_index1 = Integer.MAX_VALUE;
		Integer min_index2 = Integer.MAX_VALUE;
		
		for(int i = 0; i < len; i++) {
			int diff = b - a.get(i);
			if(h.containsKey(diff)) {
				int index1 = h.get(diff) + 1;
				int index2 = i + 1;
				if(index2 < min_index2) {
					min_index2 = index2;
					min_index1 = index1;
				} 
				else if((index2 == min_index2) && (index1 < min_index1)) {
					min_index2 = index2;
					min_index1 = index1;
				}
			} else {
				if(!h.containsKey(a.get(i)))
					h.put(a.get(i), i);
			}
		}
		if((!min_index1.equals(Integer.MAX_VALUE)) && (!min_index2.equals(Integer.MAX_VALUE))) {
			arr.add(min_index1);
			arr.add(min_index2);
		}
		return arr;
	}
}

class Solution {
	public static void main(String[] args) {
		
		TwoSum s = new TwoSum();
		
		Integer[] A = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(A));
		int b = -3;
		
		Integer[] AA = { -10, -10, -10 };
		int bb = -5;
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(AA));
		
		System.out.println(s.twoSum(arr2, b));
	}
}
