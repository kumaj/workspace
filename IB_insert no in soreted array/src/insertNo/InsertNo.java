//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0

package insertNo;

import java.util.ArrayList;

public class InsertNo {

	public int searchInsert(ArrayList<Integer> a, int b) {
		//Do the binary search
		int pos = BinarySearch(a, b);
		if(pos >= 0)
			return pos;
		else
		{
			int i = 0;
			while( i< a.size()) {
				if(b > a.get(i))
				{
					i++;
				}
				else
				{
					pos = i;
					break;
				}
			}
			if(i == a.size())
				pos = i;
			return pos;
		}
	}
	
	
	private int BinarySearch(ArrayList<Integer> arrlist, int b)
	{
		int low = 0;
		int high = arrlist.size() -1;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(arrlist.get(mid) == b)
				return mid;
			else if(arrlist.get(mid) > b) //left half
				high = mid - 1;
			else //right half
				low = mid + 1;
		}
		return -1;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		InsertNo insrt = new InsertNo();
	}
}
