package ClosestSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.
Example: 
given array S = {-1 2 1 -4}, 
and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2) */

public class ClosestSum {

	public int threeSumClosest(ArrayList<Integer> a, int b)
	{
		Collections.sort(a);
		int len = a.size();
		int j = 0;
		int k = 0;
		int sum = 0;
		int minVal = Integer.MAX_VALUE;
		int diff = 0;
		int target = 0;
		for(int i = 0; i < len-2; i++) //loop till n-2th element as j will point to n-1 and k = n
		{
			j = i + 1;
			k = len-1;
			while(j < k)
			{
				sum = a.get(i) + a.get(j) + a.get(k);
				if(sum == b)
					return sum;
				else if(sum < b)
				{
					//calculate the diff
					diff = b - sum;
					if(diff < minVal)
					{
						minVal = diff; target = sum;
					}
					j++;
				}
				else if(sum > b)
				{
					//calculate the diff
					diff = sum - b;
					if(diff < minVal)
					{
						minVal = diff; target = sum;
					}
					k--;
				}
			}
		}
		return target;
	}
	
}

class Solution
{
	public static void main(String[] args)
	{
		ClosestSum cs = new ClosestSum();
		//Integer[] A = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		//int B = -1;
		
		//A : [ 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 ]
		int B = -1;
 		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(2); arr.add(1); arr.add(-9);arr.add(-7);arr.add(-8);arr.add(2);arr.add(-8);arr.add(2); arr.add(-8);arr.add(3);
 		System.out.println(cs.threeSumClosest(arr, B));
	}
}
