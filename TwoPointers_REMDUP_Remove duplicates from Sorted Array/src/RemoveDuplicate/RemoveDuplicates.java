package RemoveDuplicate;

/*TwoPinters :: REMDUP
 * Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
Note that even though we want you to return the new length, make sure to change the original array as well in place
Do not allocate extra space for another array, you must do this in place with constant memory.

Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

	//Solved using two binary search
	// Time limit exceeds.
	public int removeDuplicates_01(ArrayList<Integer> a) 
	{
		int index = 0;
		while(index < a.size())
		{
			//Get the first occurence of duplicate
			int firstDup = firstDuplicate(a, a.get(index));
			
			//Get the last occurence of duplicate
			int lastDup = lastDuplicate(a, a.get(index));
			
			//remove the duplicates
			int temp = firstDup;
			while(temp < lastDup)
			{
				a.remove(firstDup);
				temp++;
			}
			index++;
		}
		System.out.println(a);
		return a.size();
	}
	
	//Above approach can be optimized and only one binary search is enough to
	// to find the last duplicate element.
	// Time limit exceeds.
	public int removeDuplicates_02(ArrayList<Integer> a) 
	{
		int index = 0;
		while(index < a.size())
		{	
			//Get the last occurence of duplicate
			int lastDup = lastDuplicate(a, a.get(index));
			
			//remove the duplicates
			int temp = index;
			while(temp < lastDup)
			{
				a.remove(index);
				temp++;
			}
			index++;
		}
		System.out.println(a);
		return a.size();
	}
	
	//Solve it by comparing the current with next element.
	// The problem here is the remove() method which cause 
	// the element to shift by 1 after removal of element which cause 
	// time limit exceed problem
	public int removeDuplicates_03(ArrayList<Integer> a) 
	{
		int i = 0;
		
		while(i < a.size()) {
			if(((i+1) < a.size()) && (a.get(i).equals(a.get(i + 1))))
				a.remove(i);
			else
				i++;
		}
		return a.size();
	}
	
	public int removeDuplicates_04(ArrayList<Integer> a) 
	{
		if (a.size() < 2)
			return a.size();
	 
		int j = 0;
		int i = 1;
	 
		while (i < a.size()) {
			if (a.get(i) == a.get(j)) {
				i++;
			} else {
				j++;
				a.set(j, a.get(i));
				i++;
			}
		}
		 System.out.println("i :" + i);
		 System.out.println("j :" +j);
		 while(i > j+1) {
			 a.remove(i-1);
			 i--;
		 }
		 System.out.println("i :" + i);
		 System.out.println("j :" +j);
		 System.out.println(a);
	 
		return a.size();
	}
	
	private int firstDuplicate(ArrayList<Integer> arr, int num)
	{
		int firstDup = -1;
		int low = 0;
		int high = arr.size() -1;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(arr.get(mid) == num)
			{
				high = mid -1;
				firstDup = mid;
			}
			else if(arr.get(mid) < num)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return firstDup;
	}
	
	//Get the last duplicate
	private int lastDuplicate(ArrayList<Integer> arr, int num)
	{
		int lastDup = -1;
		int low = 0;
		int high = arr.size() -1;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(arr.get(mid) == num)
			{
				low = mid + 1;
				lastDup = mid;
			}
			else if(arr.get(mid) < num)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return lastDup;
	}	
}

class Solution
{
	public static void main(String[] args)
	{
		RemoveDuplicates rm = new RemoveDuplicates();
		
		//Integer[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		Integer[] a = {5000, 5000, 5000};
		List list = new ArrayList<Integer>(Arrays.asList(a));
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0); arr.add(0); arr.add(0); arr.add(0); arr.add(0); arr.add(0); arr.add(0); arr.add(0);arr.add(1); arr.add(1); arr.add(1);
		
		System.out.println(rm.removeDuplicates_03(arr));
		
		System.out.println(rm.removeDuplicates_04((ArrayList<Integer>) list));
	}
}
