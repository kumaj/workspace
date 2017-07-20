
/* BinarySearch_MedianArray
 * There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
 */
package median;

import java.util.ArrayList;
import java.util.List;

public class median {
	
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		return 0.9;
	}
	public double findMedianSortedArrays_02(final List<Integer> a, final List<Integer> b) {
		
		int n = (a.size() + b.size())/2;
		if(n==0)
		{
			if(a.isEmpty())
				return b.get(0);
			else
				return a.get(0);
		}
		int i = 0;
		int j = 0;
		int count = 0;
		int median = 0;
		int prev = 0;
		while(count < n) {
			if(a.get(i) < b.get(j)) {
				prev = a.get(i);
				i++;
				if(i < a.size())
					median = a.get(i);
			}
			else {
				prev = a.get(j);
				j++;
				if(j < a.size())
					median = b.get(j);
			}
			count++;
		}
		
		if(n%2!=0) {
			return median;
		}
		else {
			return (prev + median)/2;
		}
	}
	
	public double findMedianSortedArrays02(final List<Integer> a, final List<Integer> b) {
        return median2(a, 0, a.size() -1 ,b, 0, b.size() - 1);
	}
	
	public static int median2(List<Integer> a, int l1, int h1, List<Integer> b, int l2, int h2)
    {
        int mid1 = (h1 + l1 ) / 2;
        int mid2 = (h2 + l2 ) / 2;

        if (h1 - l1 == 1)
            return (Math.max(a.get(l1) , b.get(l2)) + Math.min(a.get(h1) , b.get(h2)))/2;
        else if (a.get(mid1) > a.get(mid2))
            return median2(a, l1, mid1 , b, mid2 , h2);    
        else
            return median2(a, mid1 , h1, b, l2 , mid2 );    
    } 
}

class Solution {
	public static void main(String[] args) {
		median md = new median();
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1); arr1.add(4); arr1.add(5);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(2); arr2.add(3);
		
		System.out.println(md.findMedianSortedArrays(arr1, arr2));
	}
}
