import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * 
 * @author kumaj04
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that 
 * nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class Duplicates {
	
	// It can be solved using O(n^2).
	// But use hash map to solve it in O(n).
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(table.containsKey(nums[i])) {
        		//get its index and check if the existing index and this index diff <= k
        		int index = table.get(nums[i]);
        		if(Math.abs(index - i) <= k)
        			return true;
        		else
        			table.put(nums[i], i);
        	} else {
        		table.put(nums[i], i);
        	}
        }
        return false;
    }
}

class Solution {
	public static void main(String[] args) {
		Duplicates d = new Duplicates();
		int[] nums = {3,2,1,0,4,2};
		int[] nums2 = {1,0,1,1};
		System.out.println(d.containsNearbyDuplicate(nums, 4));
		System.out.println(d.containsNearbyDuplicate(nums2, 1));
	}
}
