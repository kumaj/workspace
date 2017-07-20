package MissingNo;

import java.util.ArrayList;

/*
 * Given an unsorted integer array, find the first missing positive integer.
Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1
A : [ 1 ] returns 2
Your algorithm should run in O(n) time and use constant space.
 */
public class PositiveNo {
	
	//This is a correct solution but the time complexity is more.
	public int firstMissingPositive(ArrayList<Integer> a) {
		//get the size of the array
		int size = a.size();
		ArrayList<Integer> arrayWithNos = new ArrayList<Integer>();
		for(int i = 1; i <= a.size(); i++) {
			arrayWithNos.add(i);
		}
		
		for (Integer val : a) {
			if(val > 0 && val <= size) {
				arrayWithNos.remove(val);
			}
		}
		return (arrayWithNos.size() == 0) ? (size + 1) : arrayWithNos.get(0);
	}
	
	public int firstMissingPositive02(ArrayList<Integer> a) {
		int size = a.size();
		Integer[] arr = new Integer[size];
		
		for (Integer val : a) {
			if(val > 0 && val <= size) {
				arr[val-1] = 1;
			}
		}
		
		//iterare throogh the array and find the first 0.
		int posNo = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				posNo = i+1;
				break;
			}
		}
		return (posNo == 0) ? (size+1) : posNo;
	}
}

class Solution {
	public static void main(String[] args) {
		PositiveNo ps = new PositiveNo();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		//arr.add(1); arr.add(2);arr.add(3);arr.add(4);
		//arr.add(5); arr.add(0);arr.add(4);arr.add(1);
		//arr.add( -5);
		System.out.println(ps.firstMissingPositive(arr));
		
		System.out.println(ps.firstMissingPositive02(arr));
	}
}
