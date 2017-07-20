//Given an array A[] and a number x, check for pair in A[] with sum as x

package pairSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class pairSum {

	public ArrayList<Integer> finfPairForSum(int[] arr, int num)
	{
		//sort the array
		Arrays.sort(arr);
		ArrayList<Integer> pair = new ArrayList<Integer>();
		
		int i = 0;
		int j = arr.length-1; 
		while(i < j )
		{
			if(arr[i] + arr[j] < num)
				i++;
			else if(arr[i] + arr[j] > num)
				j--;
			else // equality sum
			{
				pair.add(arr[i]);
				pair.add(arr[j]);
				i++;
				j--;
			}
		}
		return pair;
	}
	
	//Method-2 -->Using Hash table
	public ArrayList<Integer> findPairSum_02(int[] arr, int num)
	{
		int size = arr.length;
		
		// store the elements in the hash map
		//create a hash set can be also useful as compared to hash table
		//But hash set doesn't contains duplicates.
		//HashMap<Integer, Integer> hashmap;
		HashSet<Integer> hashset = new HashSet<Integer>(); 
		ArrayList<Integer> pair = new ArrayList<Integer>();
		
		//add the elements into the hashSet. But before 
		//adding check whether (num-arr[i]) is present or not
		// if yes then u got the pair otherwise add into the hash set
		for(int i = 0; i < size; i++)
		{
			if(hashset.contains(num-arr[i]))   //{1,4,12,8,8, 45,6,10,6};
			{
				pair.add(arr[i]);
				pair.add(num-arr[i]);
			}
			else
			{
				hashset.add(arr[i]);
			}
		}
		return pair;
		
	}
}

class Solution
{
	public static void main(String[] args)
	{
		pairSum prsum = new pairSum();
		//int[] arr = {9,-4,2,0,5,9,3,5,4,1,2,10};
		
		//int arr[] = {1, 4, 45, 6, 10, -8};
		
		int arr[] = {1,4,12,8,8, 45,6,10,6};
		
		//int arr[] = { -4, 1, 2, -8 }; 
		
		System.out.println(" The Pairs are : " + prsum.finfPairForSum(arr, 10));
		
		System.out.println(" The Pairs are : " + prsum.findPairSum_02(arr, 10));
	}
}
