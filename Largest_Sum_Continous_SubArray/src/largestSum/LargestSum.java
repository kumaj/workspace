//find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
// {-2, -3, 4, -1, -2, 1, 5, -3}
// Ans: 7

package largestSum;

import java.util.ArrayList;
import java.util.List;

public class LargestSum {

	//This approach is called as the kadane's algorithm
	//This approach doesn't handle the case if all the elements are negative
	// It simply return 0. 
	public int continousMaxSum(int[] arr)
	{
		//get teh size of the array
		int size = arr.length;
		int max_sum = 0;
		int max_so_far = 0;
		
		for(int i =0; i < size; i++)
		{
			max_so_far = max_so_far + arr[i];
			if(max_so_far < 0)
			{
				max_so_far = 0;
			}
			else if( max_so_far > max_sum)
			{
				max_sum = max_so_far;
			}
		}
		return max_sum;
	}
	
	//Let's handle the case when all the elements are negative
	// {-2, -3, -4, -1, -2, -1, -5, -3};
	// {-2, -3, 4, -1, -2, 1, 5, -3}
	public int continousMaxSum_02(int[] arr)
	{
		//get the size of the array
		int size = arr.length;
		int max_sum = Integer.MIN_VALUE;
		int max_sum_so_far = 0;
		
		for(int i = 0; i <  size; i++)
		{
			max_sum_so_far = max_sum_so_far + arr[i];
			
			if(max_sum_so_far < 0)
			{
				if(arr[i] > max_sum)
				{
					max_sum = arr[i];
				}
				max_sum_so_far = 0;
			}
			else if(max_sum_so_far > max_sum)
				max_sum = max_sum_so_far;
		}
		return max_sum;
	}
	
	//This method return the sub array which has the maximum sum
	public ArrayList<Integer> continousMaxSum_03(int[] arr)
	{
		//get the size of the array
		int size = arr.length;
		int max_sum = Integer.MIN_VALUE;
		int max_sum_so_far = 0;
		
		int start_index = 0;
		int end_index = 0;
		int max_start_index = -1;
		int max_end_index = -1;
		
		for(int i = 0; i <  size; i++)
		{
			max_sum_so_far = max_sum_so_far + arr[i];
			
			if(max_sum_so_far < 0)
			{
				if(arr[i] > max_sum)
				{
					max_sum = arr[i];
					max_start_index = i;
					max_end_index = i;
				}
				max_sum_so_far = 0;
				start_index = end_index + 1;
				end_index = i;
			}
			else if(max_sum_so_far > max_sum)
			{
				max_sum = max_sum_so_far;
				
				max_start_index = start_index;
				max_end_index = end_index;
			}			
			end_index++;
		}
		
		//Now store the elements into the ArrayList
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		for(int i = max_start_index; i<= max_end_index ; i++ )
			maxArray.add(arr[i]);
		
		return maxArray;
	}
	
	//Another way of solving the problem
	public int maxSubArray(final List<Integer> A) 
	{
		//get the size of list
		int size = A.size();
		
		int maxSum = Integer.MIN_VALUE;
		int max_sum_so_far = 0;
		
		for(int i = 0; i < size; i++)
		{
			int temp = A.get(i);
			max_sum_so_far = max_sum_so_far + temp;  //  [−2,1,−3,4,−1,2,1,−5,4]
			
			if(max_sum_so_far < 0)
			{
				if(A.get(i) > maxSum)
				{
					maxSum = A.get(i);
				}
				max_sum_so_far = 0;
			}
			else if(max_sum_so_far > maxSum)
				maxSum = max_sum_so_far;
		}
		return maxSum;
	}
	
}

class Solution
{
	public static void main(String[] args)
	{
		//int arr[] = {-2, -3, -4, 1, -2, -1, -5, -3};
		 //int arr[] = {4,2,2,1,-3,1,5,1,2};

		//int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		
		//int arr[] = {-3,-1,-2};
		
		//int arr[] = {-1,1,-1,-2};
		
		//int arr[] = {0, 0, -1, 0};
		
		//int arr[] = {2, 3, -1, -5};
		
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(-2); lst.add(1); lst.add(-3); lst.add(4); lst.add(-1); lst.add(2); lst.add(1); lst.add(2); lst.add(1); lst.add(-5); lst.add(4);
		
		LargestSum lsum = new LargestSum();
		
		System.out.println("Max contionous sum is : " + lsum.continousMaxSum(arr));
		
		System.out.println("Max contionous sum is : " + lsum.continousMaxSum_02(arr));
		
		System.out.println("Max contionous subArray is  : " + lsum.continousMaxSum_03(arr));
		
		System.out.println("max continous sum is : " + lsum.maxSubArray(lst));
	}
}
