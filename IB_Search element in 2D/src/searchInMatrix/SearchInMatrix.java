package searchInMatrix;

import java.util.ArrayList;

public class SearchInMatrix {
	
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		//Get the size of the arraylist
		for (ArrayList<Integer> arrlist : a) {
			int size = arrlist.size() - 1;
			if(arrlist.get(0) <= b && b <= arrlist.get(size))
			{
				//Do the binary search in the arraylist
				return BinarySearch(arrlist, b);
			}
		}
		return 0;
	}
	
	private int BinarySearch(ArrayList<Integer> arrlist, int b)
	{
		int low = 0;
		int high = arrlist.size() -1;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(arrlist.get(mid) == b)
				return 1;
			else if(arrlist.get(mid) > b) //left half
				high = mid - 1;
			else //right half
				low = mid + 1;
		}
		return 0;
	}

}

class Solution
{
	public static void main(String[] args)
	{
		SearchInMatrix srch = new SearchInMatrix();
	}
}
