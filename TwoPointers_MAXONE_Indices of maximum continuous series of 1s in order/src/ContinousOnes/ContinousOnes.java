package ContinousOnes;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

/*You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.
For this problem, return the indices of maximum continuous series of 1s in order.
Example:
Input : 
Array = {1 1 0 1 1 0 0 1 1 1} 
M = 1
Output : 
[0, 1, 2, 3, 4] 

A : [ 0, 1, 1, 1 ]
B : 0
Output : 1 2 3 

A : [ 1, 1, 0 ]
B : 2
output : 0 1 2 

A : [ 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 ]
B : 4
output :4 5 6 7 8 9 10 11 12 13 14 15 

A : [ 1, 0, 0, 0, 0, 0, 1, 0, 1, 1 ]
B : 2
output : 5 6 7 8 9 

If there are multiple possible solutions, return the sequence which has the minimum start index. */
 class ContinousOnes {
//	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b)
//	{
//		ArrayList<Integer> maxOnes = new ArrayList<Integer>();
//		if(!(b%2 == 0)) //odd times then flip the elemenst of the array
//		{
//			for(int i = 0; i< a.size(); i++)
//			{
//				if(a.get(i) == 0)
//					a.set(i, 1);
//				else
//					a.set(i, 0);
//			} 
//		}
//		
//		//Now scan the whole array and find the pos of first and last 
//		//occurence of contionous sum
//		int len = a.size();
//		int global_start = 0;
//		int global_end = -1;
//		int start = 0;
//		int end = 0;
//		int i = 0;
//		int j = 0;
//		while(i < len)
//		{
//			if(a.get(i) == 1)
//			{
//				start = i;
//				j = i;
//				while(j < len)
//				{
//					if(a.get(j) == 1)
//					{
//						end = j;
//						j++;
//					}
//					else
//						break;
//				}
//				if((end - start) > (global_end - global_start))
//				{
//					global_start = start;
//					global_end = end;
//				}
//			}
//			i++;
//		}
//		
//		for(int k = global_start; k <= global_end; k++)
//		{
//				maxOnes.add(k);
//		}
//		return maxOnes;
//	}
	 
	 //Method -1 uses 2 loops
	 public ArrayList<Integer> maxone(ArrayList<Integer> a, int b)
	 {
			ArrayList<Integer> maxOnes = new ArrayList<Integer>();
			
			//Now scan the whole array and find the pos of first and last 
			//occurence of contionous 1's
			int len = a.size();
			int global_start = 0;
			int global_end = -1;
			int start = 0;
			int end = 0;
			int i = 0;
			int j = 0;
			
			Boolean setToOne = false;
			while(i < len)
			{
				int count = b;
				if(a.get(i) == 0 && count > 0)
				{
					//flip the 0 to 1
					//a.set(i, 1); Don't modify the original array
					setToOne = true;
					count--;
				}
				if(a.get(i) == 1 || setToOne == true)
				{
					setToOne = false;
					start = i;
					j = i + 1;
					while(j < len)
					{
						if(a.get(j) == 0 && count > 0)
						{
							//Set the flag as true
							setToOne = true;
							count--;
						}
						if(a.get(j) == 1 || setToOne == true)
						{
							setToOne = false;
							end = j;
							j++;
						}
						else
							break;
					}
					if((end - start) > (global_end - global_start))
					{
						global_start = start;
						global_end = end;
					}
				}
				i++;
			}
			
			for(int k = global_start; k <= global_end; k++)
			{
					maxOnes.add(k);
			}
			return maxOnes;
		}
	 
	 // Method -2 used sliding window concept
	 public ArrayList<Integer> maxone_02(ArrayList<Integer> a, int b)
	 {
		 ArrayList<Integer> maxOnes = new ArrayList<Integer>();
		 int wL = 0;
		 int wR = 0;
		 int global_start = 0;
		 int global_end = -1;
		 
		 int len = a.size();
		 while(wR < len)
		 {
			 if(a.get(wR) == 0 && b > 0)
			 {
				 b--;
				 wR++;
			 }
			 else if(a.get(wR) == 0 && b == 0)
			 {
				 //shrink the leftwindow until it remove a 0
				 while(a.get(wL) != 0)
					 wL++;
				 wL++;
				 if((wR - wL) > (global_end - global_start))
					 b++;
			 }
	
			if((wR - wL) > (global_end - global_start))
			{
				global_start = wL;
				global_end = wR;
			}
			 wR++;
		 }
		 	
		for(int k = global_start; k <= global_end; k++)
		{
				maxOnes.add(k);
		}
		return maxOnes;
	 }
}

class Solution
{
	public static void main(String[] args)
	{
		ContinousOnes cs = new ContinousOnes();
		// A : [ 0, 1, 1, 1 ]
		//B : 0
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//arr.add(0); arr.add(1); arr.add(1); arr.add(1);
		// int B = 0;
		
		//A : [ 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 ]
		//B : 4
		//arr.add(1); arr.add(0); arr.add(1); arr.add(0); arr.add(1); arr.add(1);arr.add(1);arr.add(1);
		//arr.add(0);arr.add(0);arr.add(0);arr.add(0);arr.add(1);arr.add(1);arr.add(1);arr.add(1);arr.add(0);
		//int B = 4;
		
		//A : [ 1, 0, 0, 0, 0, 0, 1, 0, 1, 1 ]
		//		B : 2
		arr.add(1);arr.add(0);arr.add(0);arr.add(0);arr.add(0);arr.add(0);arr.add(1);arr.add(0);arr.add(1);arr.add(1);
		int B = 2;
		
		System.out.println("1st : " + cs.maxone(arr, B));
		System.out.println("2nd : "+cs.maxone_02(arr, B));
	}
}
