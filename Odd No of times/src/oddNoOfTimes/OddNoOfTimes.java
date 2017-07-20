// Given an array of positive integers. All numbers occur even number
//of times except one number which occurs odd number of times. Find the number in O(n) time & constant space

// The main intention of solving this problem is the usage of XOR gate which has a lot of usage in later problems
package oddNoOfTimes;

public class OddNoOfTimes {
	
	public int oddNoOfElement(int[] arr)
	{
		//One way of doing the problem is by using 2 loops
		//Another way of doing it through the XOR logic.
		int result = 0;
		for(int i = 0; i< arr.length; i++)
		{
			result = result ^ arr[i];
		}
		return result;
	}

}

class Solution
{
	public static void main(String[] args)
	{
		OddNoOfTimes odd = new OddNoOfTimes();
		
		//int[] arr =  {1, 2, 3, 2, 3, 1, 3};
		//int[] arr = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		int[] arr = { 9, 6, 5, 3, 5, 6, 7, 5, 1, 3, 5, 8, 2, 5, 6, 4};
		System.out.println("Odd No of times Element is : " + odd.oddNoOfElement(arr));
	}
}


//Some of the problem which can be solved using XOR gate are listed below
// 1. Find the missing Number
//You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. 
//One of the integers is missing in the list. Write an efficient code to find the missing integer
//I/P    [1, 2, 4, ,6, 3, 7, 8]
//O/P    5