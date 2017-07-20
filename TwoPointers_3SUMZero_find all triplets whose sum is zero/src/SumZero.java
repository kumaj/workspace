import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* TwoPointers_3SUMZero
 * 3SUMZERO
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 
 */
public class SumZero {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		Collections.sort(a);
		int len = a.size();
		int i = 0;
		int j = 0;
		int k = 0;
		int sum = 0;
		
		while(i < len-2) {  //loop till n-2th element as j will point to n-1 and k = n
			j = i + 1;
			k = len-1;
			while(j < k)
			{
				sum = a.get(i) + a.get(j) + a.get(k);
				if(sum == 0) {// add into the arraylist
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(a.get(i));
					arr.add(a.get(j));
					arr.add(a.get(k));
					//System.out.println(arr);
					res.add(arr);
				}
				if(sum <= 0)
				{
					while(((j+1) <= k) && (a.get(j).equals(a.get(j+1)))) //skip the duplicates
						j++;
					j++;
				}
				if(sum >= 0)
				{
					while(((k-1) >= j) && (a.get(k).equals(a.get(k-1)))) //skip the duplicates
						k--;
					k--;
				}
			}
			while(((i+1) < (len-2)) && (a.get(i).equals(a.get(i+1)))) //skip the duplicates
				i++;
			i++;
		}
		return res;
	}
}

class Solution {
	public static void main(String[] args) {
		SumZero s = new SumZero();
		
		Integer[] arr = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
		//Integer[] arr =  { -31013930, -31013930, 9784175, 21229755 };
		List list = new ArrayList<Integer>(Arrays.asList(arr));;
		
		System.out.println(s.threeSum((ArrayList<Integer>) list));
	}
}
