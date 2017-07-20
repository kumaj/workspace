// Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times
//(and hence there is at most one such element)

package majorityElement;

import java.util.Arrays;

//I/P : 3 3 4 2 4 4 2 4 4
//O/P : 4
public class MajorityElement {

	public int getMajorityElement(int[] arr)
	{
		int majorityCount = 0;
		int arr_size = arr.length;
		//Use 2 loops and check each element whether it's count > n/2
		for(int i = 0; i< (arr_size)/2; i++)  // 3 3 4 2 4 4 2 4
		{
			for(int j = i; j < arr_size; j++)
			{
				if(arr[i] == arr[j])
					majorityCount++;
				if(majorityCount > (arr_size/2))
					return arr[i];
			}
			majorityCount = 0;
		}
		return -1; // no majority elelemnt has been found
	}
	
	//Method-2
	// This problem can also be solved using sorting
	public int getMajorityElement_02(int[] arr)
	{
		//sort the arrays and check whether the 1st and n/2th element
		// are same or not if same then that is the majority element
		Arrays.sort(arr);
		
		int arr_size = arr.length;  // {3, 3, 4, 2, 4, 4, 2, 4, 4} ==> 2,2,3,3,4,4,4,4,4
		int half_arr = 0;
		if(arr_size%2 == 0) //even length
			half_arr = arr_size/2;
		else
			half_arr = arr_size/2 + 1;
			
		for(int i = 0; i< half_arr; i++)
		{
			if(arr[i] == arr[i+ (arr_size/2)]) //here only one element is majority but more than one element could also be in majority
				return arr[i];
		}
		return -1;
	}

}

class Solution
{
	public static void main(String[] args) {
		
		MajorityElement majority = new MajorityElement();
		
		//int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		//int[] arr = {3, 3, 4, 2, 4, 4, 2, 4};
		//int[] arr = {1, 3, 3, 1, 2};
		//int[] arr = {2, 2, 3, 3, 3, 5, 5};
		int[] arr = {1, 1, 1, 1, 5, 6, 7, 8};
		System.out.println("Majority elemnt is : " + majority.getMajorityElement(arr));
		
		System.out.println("Majority elemnt is : " + majority.getMajorityElement_02(arr));
}
}
