package intersectionOf2Arrays;

import java.util.ArrayList;
import java.util.List;

/*Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.
Example :
Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]
Output : [3 3 5]
Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]
Output : [3 5] 

*NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that 
*elements that appear more than once in both arrays should be included multiple times in the final output.*/
		
public class IntersectionOfArrays {
	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) 
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		while(i < a.size() && j < b.size())
		{
			if(a.get(i).equals(b.get(j)))
			{
				res.add(a.get(i));
				i++;
				j++;
			}
			else if(a.get(i) < b.get(j))
			{
				i++;
			}
			else
			{
				j++;
			}
		}
		return res;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		//A : [ 1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101 ]
		//B : [ 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98 ]
		// o/p: 35 38 53 67 69 94 98 
	}
}
