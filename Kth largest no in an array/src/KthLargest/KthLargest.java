package KthLargest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthLargest {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
		
		//change the arraylist first
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(Integer i : a)
			arr.add(i);
		
		//Now start sorting the elements
		//logic is similar to the quick sort. but the pivot is k-1th element
		int i = 0;
		int j = arr.size() - 1;
		int kthElement = 0;
		while(i <= j)
		{
			//increment the i
			while(arr.get(i) <= arr.get(k-1) && (i < k-1))
				i++;
			while(arr.get(j) >= arr.get(k-1) && (j > k-1))
				j--;
			
			if(i==j)
			{
				kthElement = arr.get(i); //j or k. Here i and j concides to the k-1th position
				break;
			}
			
			//otherwise swap it
			else if((i == (k -1)) || (j == (k -1)))
			{
				swap(arr, i, j);
				i = 0;
				j = arr.size() - 1;
			}	
			
			else if(i < j)
			{
				swap(arr, i, j);
				i++;
				j--;
			}
		//	System.out.println("i : "+i + " " + "j :"+j);
		//	System.out.println(arr);
		}
		return kthElement;
	}

	private void swap(List<Integer> a, Integer i, Integer j) {
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
	
	//This is the recursive way of doing the job. As per the coding standard, it's more neat and clean.
	//This method has to handle the duplicates as well.
	public int findkthSmallestElement_02(final List<Integer> a, int k) {
        k = k - 1; // since array index starts with 0
        
        //convert the input arraylist to a set in order to remove the duplicates.
      //  HashSet<Integer> set = new HashSet<Integer>(a);
        Integer [] arr = a.toArray(new Integer[a.size()]);
        
        return kSmall(arr, 0, arr.length - 1, k);
    }
 
    public int kSmall(Integer[] arrA, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = start;
        while (left <= right) {
            while (left <= right && arrA[left] <= arrA[pivot])
                left++;
            while (left <= right && arrA[right] >= arrA[pivot])
                right--;
            if (left < right) {
                swap(arrA, left, right);
                left++;
                right--;
            }
        }
        swap(arrA, pivot, right);
        if (pivot == k)
            return arrA[pivot];// if pivot is kth element , return
        else if (pivot < k)
            // if pivot is less than k, then kth element will be on the right
            return kSmall(arrA, pivot + 1, end, k);
        else
            // if pivot is greater than k, then kth element will be on the right
            return kSmall(arrA, start, pivot - 1, k);
    }
 
    public void swap(Integer[] arrA, int a, int b) {
        int x = arrA[a];
        arrA[a] = arrA[b];
        arrA[b] = x;
    }
	
}

class Solution
{
	public static void main(String[] args)
	{
		KthLargest lrge = new KthLargest();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//arr.add(4); arr.add(5); arr.add(7); arr.add(1); arr.add(3); arr.add(2); arr.add(6);arr.add(8);
		//int k = 4;
		
		Integer[] a = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
//		Integer[] a = {8, 16, 18, 15, 45, 23, 74, 81, 42, 28, 16};
//		Integer[] a = {1};
		for(int i = 0; i < a.length; i++)
			arr.add(a[i]);
		int k = 9;
		
		Collections.sort(arr);
		System.out.println(arr);
		//Why u are iterating the loop . Same job can be done using the java util.
		//arr = (ArrayList<Integer>) Arrays.asList(a);
				
		System.out.println(lrge.kthsmallest(arr, k));
		System.out.println(lrge.findkthSmallestElement_02(arr, k));
	}
}
