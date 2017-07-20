// Given two sorted arrays such the arrays may have some common elements. Find the sum of the
//maximum sum path to reach from beginning of any array to end of any of the two arrays. We can switch
//from one array to another array only at common elements.
// Input: ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8}
//Output: 35
//35 is sum of 1 + 5 + 7 + 10 + 12.
package maxSum;

public class MaximumSum {

	public int maxSumIn2Arrays(int[] arr1, int[] arr2)
	{
		//maintain two sum variables
		int sum1 = 0;
		int sum2 = 0;
		
		//get the size of each array
		int size1 = arr1.length;
		int size2 = arr2.length;
		int maxSum = 0;
		
		int i = 0;
		int j = 0;
		while(i < size1 && j < size2)
		{
			  // {1, 3, 7, 10, 12, 13} --> sum1
			  // {2, 4, 5, 7, 8, 10}   --> sum2
			
			if(arr1[i] < arr2[j])
			{
				sum1 = sum1 + arr1[i];
				i++;
			}
			else
			{
				sum2 = sum2 + arr2[j];
				j++;
			}
			
			// got the common element
			if(arr1[i] == arr2[j])
			{
				if(sum1 > sum2)
				{
					maxSum = maxSum + sum1 + arr1[i];
				}
				else
				{
					maxSum = maxSum + sum2 + arr1[j];					
				}
				
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		return maxSum;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		MaximumSum mxSum = new MaximumSum();
		
		int[] arr1 = {1, 3, 7, 10, 12, 13};
		int[] arr2 = {2, 4, 5, 7, 8, 10};
		System.out.println("Max Sum is  : " + mxSum.maxSumIn2Arrays(arr1, arr2));
	}
}
