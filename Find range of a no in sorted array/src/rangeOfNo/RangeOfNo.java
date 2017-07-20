//Given a sorted array of integers, find the starting and ending position of a given target value.
//Your algorithm’s runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
//Example:
//Given [5, 7, 7, 8, 8, 10]
//and target value 8,
//return [3, 4].

package rangeOfNo;

import java.util.ArrayList;
import java.util.List;

public class RangeOfNo {
	// DO NOT MODIFY THE LIST
		public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
			
			ArrayList<Integer> range = new ArrayList<Integer>();
			int firstOcc = firstOccUsingBinarySearch(a, b);
			int lastOcc = lastOccUsingBinarySearch(a, b);
			range.add(firstOcc);
			range.add(lastOcc);
			return range;
		}
		
		private int firstOccUsingBinarySearch(final List<Integer>a, int b)
		{
			int low = 0;
			int high = a.size() -1;
			int result = -1;
			
			while(low <= high)
			{
				int mid = (low + high)/2;
				if(a.get(mid) == b)
				{
					result = mid;
					high = mid - 1;
				}
				else if(a.get(mid) > b)
					high = mid - 1;
				else
					low = mid + 1;
			}
			return result;
		}
		
		private int lastOccUsingBinarySearch(final List<Integer>a, int b)
		{
			int low = 0;
			int high = a.size() -1;
			int result = -1;
			
			while(low <= high)
			{
				int mid = (low + high)/2;
				if(a.get(mid) == b)
				{
					result = mid;
					low = mid + 1;
				}
				else if(a.get(mid) > b)
					high = mid - 1;
				else
					low = mid + 1;
			}
			return result;
		}
}

class Solution
{
	public static void main(String[] args)
	{
		RangeOfNo rnge = new RangeOfNo();
	}
}
