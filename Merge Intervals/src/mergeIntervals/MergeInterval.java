package mergeIntervals;

import java.util.ArrayList;

public class MergeInterval {
	
	public ArrayList<Integer> mergeIntervals(ArrayList<Integer> inArray)
	{
		//assume the intervals are in sorted order
		//There are 3 cases
		// 1. No intersection [1,4] [5,8]
		// 2. One intersection [1,4] [2,5]
		// 3. Two intersection [1,4] [2,4/3] 
		//get the count of arrlist
		int size = inArray.size();
		
		int k = 0;
		int l = 1;
		int m = 2;
		int n = 3;
		//Modify the existing array
		// We are not using the "size" becuase we have to check the 
		// size of the array at run time as we are removing the elements.
		for (int i = 0; i <= inArray.size()-4; i=i+2)
		{
//			k = i;
//			l = i+1;
//			m = i+2;
//			n = i+3;
			
			//No intersection [1,4] [5,7] 
			if(inArray.get(m) > inArray.get(k) && inArray.get(m) > inArray.get(l) && inArray.get(n) > inArray.get(l))
			{
				//No need to merge the intervals
				//increment the counters
				k = k + 2;
				l = l + 2;
				m = m + 2;
				n = n + 2;
			}
			//handle the case of one intersection [1,4] [3,5]
			else if(inArray.get(m) > inArray.get(k) && inArray.get(m) < inArray.get(l) && inArray.get(n) > inArray.get(l))
			{
				//in such case remove the l and m and finally merge the array. It will be [k,n]
				int t1 = l;
				int t2 = m;
				// K remains as it is
				l = m;
				m = m + 2;
				n = n + 2;
				
				//remove l and m
//				inArray.remove(t1);
//				inArray.remove(t2);
				
				//When the item get removed, it reduces the size of the arraylist
				//So if you remove ith elemnet next time when you remove ith item,
				// then actually you are removing i + 1th item because the size of 
				// the array gets reduced.
				
				// So to overcome this problem remove gretaer element then smallest
				inArray.remove(t2);
				inArray.remove(t1);
			}
			//case when both the elements intersects [1,4] [2,3]
			else if(inArray.get(m) > inArray.get(k) && inArray.get(m) < inArray.get(l) && inArray.get(n) < inArray.get(l))
			{
				//remove m and n
				int t1 = m;
				int t2 = n;
				
				m = m + 2;
				n = n + 2;
				
				inArray.remove(t2);
				inArray.remove(t1);
				
				if(inArray.size() >= 4)
					i = 0;
				
			}
		} //for loop
		return inArray;
	}

}

class Solution
{
	public static void main(String[] args)
	{
		MergeInterval mrg = new MergeInterval();
		
		//create arrayList 
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(1); arr.add(4); arr.add(5); arr.add(7);
//		
//		System.out.println("Arr ... : " + mrg.mergeIntervals(arr));
//		
//		//2nd Array
//		ArrayList<Integer> arr2 = new ArrayList<Integer>();
//		arr2.add(1); arr2.add(4); arr2.add(3); arr2.add(7);
//		
//		System.out.println("Arr2 ... : " + mrg.mergeIntervals(arr2));
//		
//		//3rd Array
//		ArrayList<Integer> arr3 = new ArrayList<Integer>();
//		arr3.add(1); arr3.add(4); arr3.add(2); arr3.add(3);
//		
//		System.out.println("Arr3 ... : " + mrg.mergeIntervals(arr3));
//		
//		//{{1,3}, {2,4}, {5,7}, {6,8}
//		//3rd Array
//		ArrayList<Integer> arr4 = new ArrayList<Integer>();
//		arr4.add(1); arr4.add(3); arr4.add(2); arr4.add(4);arr4.add(5); arr4.add(7); arr4.add(6); arr4.add(8);
//		
//		System.out.println("Arr4 ... : " + mrg.mergeIntervals(arr4));
		
		//{ {6,8}, {1,9}, {2,4}, {4,7} }
		ArrayList<Integer> arr5 = new ArrayList<Integer>();
		arr5.add(1); arr5.add(9); arr5.add(2); arr5.add(4);arr5.add(4); arr5.add(7); arr5.add(6); arr5.add(8);
		
		System.out.println("Arr5 ... : " + mrg.mergeIntervals(arr5));
	}
}
