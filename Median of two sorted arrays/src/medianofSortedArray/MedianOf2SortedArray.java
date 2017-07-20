// Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array
//obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
package medianofSortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOf2SortedArray {

	//Method -1
	// Create a new array and put the elements in sorted order
	//print the middle element.
	public void medianOfTwoSortedArray(int[] arr1, int[] arr2)
	{
		//let's merge both the array
		int size1 = arr1.length;
		int size2 = arr2.length;
		int[] mergedArr = new int[size1 + size2];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < size1 && j < size2)       
		{
			if(arr1[i] < arr2[j])
			{
				mergedArr[k] = arr1[i];
				i++;
			}
			else
			{
				mergedArr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		//Merge the rest of the array
		if(i == size1)
		{
			while(j < size2)
			{
				mergedArr[k++] = arr2[j];
				j++;
			}
		}
		else if(j == size2)
		{
			while(i < size1)
			{
				mergedArr[k++] = arr1[i];
				i++;
			}
		}
					
		for(int p = 0; p < mergedArr.length; p++)
			System.out.print(mergedArr[p] + " ");	
		
		//Print the median of the array
		//if length of array is even then it is the average of n/2 and n/2+1 elements
		int len = mergedArr.length;
		if(len%2 != 0 ) //odd
			System.out.println("\nMedian of the array : " + mergedArr[len/2]);
		else //even
			System.out.println("\nMedian of the array : " + (mergedArr[len/2 - 1] + mergedArr[len/2])/2);
	}
	
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		//let's merge both the array
				int size1 = a.size();
				int size2 = b.size();
				ArrayList<Integer> mergedArr = new ArrayList<Integer>();
								
				int i = 0;
				int j = 0;
				int k = 0;
				
				while(i < size1 && j < size2)       
				{
					if(a.get(i) < b.get(j))
					{
						mergedArr.add(a.get(i));
						i++;
					}
					else
					{
						mergedArr.add(b.get(j));
						j++;
					}
				}
				
				//Merge the rest of the array
				if(i == size1)
				{
					while(j < size2)
					{
						mergedArr.add(b.get(j));
						j++;
					}
				}
				else if(j == size2)
				{
					while(i < size1)
					{
						mergedArr.add(a.get(i));
						i++;
					}
				}
				
				//Get the length of the merged array
				int len = mergedArr.size();
				// if it is even then the median is the avg of n/2 and n/2+1 element
				if(len % 2 != 0)
					return mergedArr.get(len/2);
				else {
					int med = (mergedArr.get(len/2-1) + mergedArr.get(len/2));
					return med/2;
				}
	}
}


class Solution
{
	public static void main(String[] args)
	{
		MedianOf2SortedArray median = new MedianOf2SortedArray();
		
		//int[] arr1 = {1, 12, 15, 26, 38};
	    //int[] arr2 = {2, 13, 17, 30, 45};
		
		//int[] arr1 = {1, 2, 5, 6, 8};
	    //int[] arr2 = {12, 13, 17, 30, 45};
	    
	    int[] arr1 = {12, 15, 26, 38};
	    int[] arr2 = {2, 13, 17, 30, 45, 50};
	    
	   // int[] arr1 = {12, 15};
	    //int[] arr2 = {11, 13, 17, 30, 45, 50};
	    
	   // int[] arr1 = {12, 15,16,17,99};
	   // int[] arr2 = {50};
	    
	    median.medianOfTwoSortedArray(arr1, arr2);
	    
	    Integer[] A = { 0, 23 };
	    Integer[] B = {  };
	    List<Integer> a = Arrays.asList(A);
	    List<Integer> b = Arrays.asList(B);
	    
	    System.out.println(median.findMedianSortedArrays(a, b));
	}
}