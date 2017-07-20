//Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n­1]’ is sorted
//in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
//Examples:
//Input: arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
//Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
//{20, 5, 10, 2, 80, 6, 100, 3} OR
//any other array that is in wave form

//Input: arr[] = {20, 10, 8, 6, 4, 2}
//Output: arr[] = {20, 8, 10, 4, 6, 2} OR
//{10, 8, 20, 2, 6, 4}
package sortInWaveform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortInWaveForm {

	public void sortInWaveFrm(int[] arr)
	{
		// first sort the array and do the following operation
		//case 1: if 1 element --> No need to do anything
		//case 2: if 2 elements --> swap both of them (1 and 2)
		//case 3: if 3 elements --> swap 1st and 2nd element
		//case 4: if 4 elements --> swap 1st and 4th element
		
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-1; i=i+2)
		{
			int temp;
			temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
		for(int i = 0; i < arr.length; i=i+1)
		{
			System.out.println(arr[i] + " ");
		}
	}
	
	public ArrayList<Integer> sortInWaveFrm(ArrayList<Integer> A)
	{
		// first sort the array and do the following operation
		//case 1: if 1 element --> No need to do anything
		//case 2: if 2 elements --> swap both of them (1 and 2)
		//case 3: if 3 elements --> swap 1st and 2nd element
		//case 4: if 4 elements --> swap 1st and 4th element
		
		if(A.size() == 1)
			return A;
		
		Collections.sort(A);
		for(int i = 0; i < A.size()-1; i=i+2)
		{
			Collections.swap(A, i,i+1);
		}
		return A;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		SortInWaveForm srt = new SortInWaveForm();
		
		//int[] arr = {1,2};
		//int[] arr = {1,2, 3};
		//int[] arr = {1,2, 3, 4};
		//int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
		int[] arr = {20, 10, 8, 6, 4, 2};
		srt.sortInWaveFrm(arr);
	}
}
