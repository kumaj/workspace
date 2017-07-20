// There are two sorted arrays. First one is of size m+n containing only m elements.
//Another one is of size n and contains n elements. Merge these two arrays into the
//first array of size m+n such that the output is sorted

package mergeSortedArrays;

public class MergeSortedArray {

	public void mergeSortedArray(int[] arr1, int[] arr2)
	{
		// arr1 has size m+n while arr2 have n elements
		//Here the void elements in arr1 is represented bu 0
		// Move all the elements of arr1 to right side 
		//Merge both the arrays
		
		//Move the void pointers to left in arr1
		//Take 2 pointers. One left pointer and another right pointers
		int lPtr = 0;
		int rptr = arr1.length -1;
		while(lPtr < rptr)
		{
			while(arr1[lPtr] == 0)
				lPtr++;
			while(arr1[rptr] != 0)  //{2, 8, NA, NA, NA, 13, NA, 15, 20};
				rptr--;
			//swap left and right pointers elements
			int temp = arr1[lPtr];
			arr1[lPtr] = arr1[rptr];
			arr1[rptr] = temp;
			lPtr++;
			rptr--;
		}
		
		System.out.println("Elements after moving the void elements..");
		for(int i =0; i <  arr1.length; i++)
			System.out.print(arr1[i] + " ");
		
//		Now merge both arr1 and arr2 elements  // {NA, NA, NA, NA, 2, 8, 13, 15, 20}; // {5, 7, 9, 25};
		int size1 = arr1.length;
		int size2 = arr2.length;
		for(int i = 0, j = 0, k = 0; i< (size1-size2);)
		{
			if(arr1[size1-size2-1+i] < arr2[j])
			{
				arr1[k] = arr1[size1-size2-1-i];
				arr1[size1-size2-1-i] = 0;
				i++;
			}
			else
			{
				arr1[k] = arr2[j];
				j++;
			}
			k++;
		}
		System.out.println("\nElements after merging..");
		for(int i =0; i <  arr1.length; i++)
			System.out.println(arr1[i] + " ");
	}
}

class Solution
{
	public static void main(String[] args)
	{
		MergeSortedArray merge = new MergeSortedArray();
		
		int NA = 0;
		//create two arrays
		int[] arr1 = {2, 8, NA, NA, NA, 13, NA, 15, 20};
		int[] arr2 = {5, 7, 9, 25};
		
		merge.mergeSortedArray(arr1, arr2);
	}
}
