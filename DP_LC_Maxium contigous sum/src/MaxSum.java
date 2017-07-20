/**
 * 53. Maximum Subarray
 * @author kumaj04
 *Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6
 */
public class MaxSum {
	
	//This version Exceed time limit
    public int maxSubArray(int[] nums) {
    	
       int size = nums.length;
	   int max_so_far = 0, max_ending_here = 0;
	   
	   //if all the nos are negative, then return the max out of it
	   int neg_max = Integer.MIN_VALUE;
	   boolean flag = true;
	   for (int i = 0; i < size; i++)
	   {
		   if(nums[i] < 0) {
			   if(nums[i] > neg_max)
				   neg_max = nums[i];
		   }
		   else {
			   flag = false;
			   break;
		   }
	   }
	   if(flag == true)
		   return neg_max;
	   
	   for (int i = 0; i < size; i++)
	   {
	       max_ending_here = max_ending_here + nums[i];
	       if (max_ending_here < 0)
	           max_ending_here = 0;
	 
	       /* Do not compare for all elements. Compare only   
	          when  max_ending_here > 0 */
	       else if (max_so_far < max_ending_here)
	           max_so_far = max_ending_here;
	   }
	   return max_so_far;
    }
}

class Solution {
	public static void main(String[] args) {
		
	}
}
