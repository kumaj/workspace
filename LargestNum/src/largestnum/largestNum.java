package largestnum;
//Interview Bit
//Given a list of non negative integers, arrange them such that they form the largest number.

//For example:

//Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

//Note: The result may be very large, so you need to return a string instead of an integer.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestNum {
	
	public String largestNumber(final List<Integer> A)
	{
		int size = A.size();
		List<Integer> testList = new ArrayList<Integer>();
		List<Integer> arrList = new ArrayList<Integer>();
		StringBuilder strbldr = new StringBuilder();
		
		for(int i = 0; i<size; i++)
			arrList.add(A.get(i));
		
		if(A.size() == 1)
			return strbldr.append(arrList.get(0)).toString();
		
		for(int i = 0; i<size-1; i++)   // [3, 30, 34, 5, 9]
		{
			int largest = arrList.get(i);
			int pos = i;
			for(int j = i+1; j<size; j++)
			{
				//first find the digits of each nos
				int num1 = largest;
				int num2 = arrList.get(j);
				
				List<Integer> d1 = new ArrayList<Integer>();
				List<Integer> d2 = new ArrayList<Integer>();
				while(num1 > 0)
				{
					int rem = num1 % 10;
					num1 = num1 / 10;
					d1.add(rem);
				}
				
				while (num2 > 0)
				{
					int rem = num2 % 10;
					num2 = num2 / 10;
					d2.add(rem);
				}

				int size1 = d1.size();
				int size2 = d2.size();
				
				int ii = size1 -1;
				int jj = size2 -1;
				while (ii > -1 && jj > -1)      // [3, 30, 34, 5, 9]
				{
					if(d2.get(jj) > d1.get(ii))
					{
						largest = arrList.get(j); 
						pos = j;
						break;
					}
					else if (d2.get(jj) < d1.get(ii))
						break;
					ii--;
					jj--;
				}
				
				//let say one of the array end while other have some element left in it
				if(ii == -1 && jj > -1)
				{
					ii = size1 - 1;
					while(ii > -1 && jj > -1)
					{
						if(d2.get(jj) > d1.get(ii))
						{
							largest = arrList.get(j);
							pos = j;
							break;
						}
						else if (d2.get(jj) < d1.get(ii))
							break;
						jj--;
						ii--;
					}
				}
				
				if(jj == -1 && ii > -1)
				{
					jj = size2 - 1;
					while(ii > -1 && jj > -1)
					{
						if(d2.get(jj) > d1.get(ii))
						{
							largest = arrList.get(j);
							pos = j;
							break;
						}
						else if (d2.get(jj) < d1.get(ii))
							break;
						ii--;
						jj--;
					}
				}
			}
			Collections.swap(arrList, i, pos);
			testList.add(arrList.get(pos));
		} // for loop
		
		for(int index = 0; index < arrList.size(); index++)
		{
			if(index > 0)
			{
				if(arrList.get(index) == 0 && arrList.get(index - 1) == 0 )
					continue;
			}
			strbldr.append(arrList.get(index));
		}
		
		String lrgstStrnum = strbldr.toString();
		return lrgstStrnum;
	}
	
	public String largestNumber_02(final List<Integer> A)
	{
		//First break the elements into digits and sort it then
		//convert the list into a string object
		List<Integer> digitList = new ArrayList<Integer>();
		int size = A.size();
		for(int i = 0; i<size; i++)
		{
			//break the nos into digits
			int num = A.get(i);
			if(A.get(i) == 0)
				digitList.add(0);
			else
			{
				while(num > 0)
				{
					int rem = num % 10;
					num = num/10;
					digitList.add(rem);
				}
			}
		} // for loop
		
		System.out.println(digitList);
		
		//sort the collection in descending order
		Collections.sort(digitList, Collections.reverseOrder());
		System.out.println(digitList);
		
		StringBuilder strbldr = new StringBuilder();
		for(int index = 0; index < digitList.size(); index++)
		{
			strbldr.append(digitList.get(index));
		}
		
		String lrgstStrnum = strbldr.toString();
		return lrgstStrnum;
	}
	
	public String largestNumber_03(final List<Integer> A)
	{
		//create an intermediate arraylist
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(Integer i : A)
			arr.add(i);
		
		int low = 0;
		int high = arr.size() - 1;
		//call the quick sort
		System.out.println(arr);
		quickSort(arr, low, high);
		StringBuilder result = new StringBuilder();
		//return the result
		for(Integer i : arr)
			result.append(i);
		
	    String regex = "^0+(?!$)";	    
	    String foo = result.toString().replaceAll(regex, "");

		return foo;
	}
	
	
	//This problem cannot be solved using the quicksort algorithm
	public static void quickSort(ArrayList<Integer> arr, int low, int high) {
		if (arr == null || arr.size() == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr.get(middle);
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i < j) {
			//while (arr.get(i) < pivot) {
			  while(compare(pivot, arr.get(i))) {
				i++;
			}
 
			//while (arr.get(j) > pivot) {
			  while(compare(arr.get(j), pivot)) {
				j--;
			}
 
			if (i <= j) {
			//	if(compare(arr.get(i),arr.get(j))) { //if x=30, y=3 Here yx > xy so swap x and y
					int temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
					i++;
					j--;
			//	}
			}
		}
		System.out.println(arr);
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
	// This approach is totally correct but it takes a n^2 time complexit]y.
	// Think how can we reduce it.
	public String largestNumber_04(final List<Integer> A)
	{
		//create an intermediate arraylist
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(Integer i : A)
			arr.add(i);
		int high = arr.size();

		for(int i = 0; i< high-1 ; i++)
		{
			for(int j = i+1; j<high; j++)
			{
				if(compare(arr.get(i),arr.get(j))) { //if x=30, y=3 Here yx > xy so swap x and y
					int temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
			System.out.println(arr);
		}
		
		StringBuilder result = new StringBuilder();
		//return the result
		for(Integer i : arr)
			result.append(i);
		
	    String regex = "^0+(?!$)";	    
	    String foo = result.toString().replaceAll(regex, "");

		return foo;
	}

	//Compare both the integers
	private static boolean compare(int i, int j) {
		//convert the i and j to string
		Integer ii = new Integer(i);
		Integer jj = new Integer(j);
		String str1 = ii.toString() + jj.toString();
		String str2 = jj.toString() + ii.toString();
		//compare both the strings
		if(str2.compareTo(str1) > 0)
			return true;
		else
			return false;
	}
	

}

class Solution
{
	public static void main(String[] args)
	{
		largestNum lrge = new largestNum();
		
		//create an Arraylist
		List<Integer> listA = new ArrayList<Integer>();
//		listA.add(3); listA.add(30); listA.add(34); listA.add(5); listA.add(9);
		
		Integer[] arr = { 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 };
		List<Integer> listB = new ArrayList<Integer>(Arrays.asList(arr));
		
//		listA.add(0); listA.add(0); listA.add(0); listA.add(1);
//		listA.add(0); listA.add(0); listA.add(0); 
		
		//listA.add(0); listA.add(0); listA.add(0); listA.add(0); listA.add(0);
		
		//listA.add(8); listA.add(9);
		
		//listA.add(8); listA.add(98);
		
		//listA.add(8); listA.add(89);
		
		//listA.add(21); listA.add(12);listA.add(32); listA.add(22);listA.add(2); listA.add(20);
		//[ 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 ]
		// 4124726639647224858526354368676319
		//[ 782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905 ]
		//99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372982927126124019124113
		
		//listA.add(472); listA.add(663);listA.add(964); listA.add(722);listA.add(485); listA.add(852);
		//listA.add(635); listA.add(4);listA.add(368); listA.add(676);listA.add(319); listA.add(412);
		
//		listA.add(782); listA.add(240); listA.add(409); listA.add(678); listA.add(940); listA.add(502); 
//		listA.add(113); listA.add(686); listA.add(6); listA.add(825); listA.add(366); listA.add(686); 
//		listA.add(877); listA.add(357); listA.add(261); listA.add(772); listA.add(798);
//		listA.add(29); listA.add(337); listA.add(646); listA.add(868); listA.add(974); listA.add(675);
//		listA.add(271); listA.add(791); listA.add(124); listA.add(363); listA.add(298);
//		listA.add(470); listA.add(991); listA.add(709); listA.add(533); listA.add(872);
//		listA.add(780); listA.add(735); listA.add(19); listA.add(930); listA.add(895); listA.add(799);
//		listA.add(395); listA.add(905);
		
		// [ 170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247, 124, 461, 317, 457, 48, 886, 420, 473, 973, 464, 203, 288, 785, 703, 935, 7, 987, 48, 692, 633, 597, 857, 139, 733, 692, 68, 434, 587, 489, 517, 305, 432, 577, 335, 586, 34, 659, 491, 310, 857, 256, 856, 257, 877, 209, 979, 653, 646, 2, 65, 858, 779, 372, 116, 404, 268, 364, 351, 866, 824, 947, 960, 91, 691, 492, 312, 609, 915, 579, 476, 248, 192 ]
		// 9879799739609479359359191589688868778668588578578568448248027857797735733703692692691686596565364663463361060959759158758657957751749249148948484804764734644614574464434344324204043833723643513433531731231030528826825725624824722092031921701391241161
		

				
//		Integer[] A ={ 170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247, 124, 461, 317, 457, 48, 886, 420, 473, 973, 464, 203, 288, 785, 703, 935, 7, 987, 48, 
//				  692, 633, 597, 857, 139, 733, 692, 68, 434, 587, 489, 517, 305, 432, 577, 335, 586, 34, 659, 491, 310, 857, 256, 856, 257, 877, 209, 979, 653, 646, 2, 65, 858, 779, 
//				  372, 116, 404, 268, 364, 351, 866, 824, 947, 960, 91, 691, 492, 312, 609, 915, 579, 476, 248, 192 };
//		//Convert into arraylist
//		 for (int index = 0; index < A.length; index++)
//		 {
//			 listA.add(A[index]);
//		 }
		

		
		//System.out.println(lrge.largestNumber(listA));
		 
//		System.out.println(lrge.largestNumber_03(listA));
//		 System.out.println(lrge.largestNumber_04(listA));
		 
		 System.out.println(lrge.largestNumber_03(listB));
		 System.out.println(lrge.largestNumber_04(listB));
	}
	
}
