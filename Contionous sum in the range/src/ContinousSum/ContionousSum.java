package ContinousSum;

/*
 * 
 * Given an array of non negative integers A, and a range (B, C), 
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3 
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

NOTE : The answer is guranteed to fit in a 32 bit signed integer.

 A : [ 80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 ]
B : 99
C : 269

o/p : 58
 */
import java.util.ArrayList;

public class ContionousSum {

	protected int checkCount(ArrayList<Integer>a, int b, int c)
	{
		int i = -1;
		int j= 0;
		int sum = 0;
		int count = 0;
		
		while(i < j)
		{
			if(j < a.size())
				sum = sum + a.get(j);
			
			if(sum >= b && sum <= c && j < a.size())
			{	
				if(j == a.size())
				{
					sum = sum - a.get(i);
					i++;
				}
				else
				{
					j++;
				}
				count++;
			}
			else if( sum < b )
			{
				if(j == a.size() && i < a.size())
				{
					sum = sum - a.get(i);
					i++;
				}
				else
				{
					j++;
				}
			}
			else //sum > b
			{
				if(j < a.size())
					sum = sum - a.get(j);
				j++;
				i++;
			}
		}
		return count;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		ContionousSum cs = new ContionousSum();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(10); arr.add(5); arr.add(1); arr.add(0);arr.add(2);
		
		//arr.add(4); arr.add(5); arr.add(1); arr.add(3);arr.add(2);arr.add(0);
		
		//int b = 6; 
		//int c = 8;
		
		arr.add(1);
		int b = 0;
		int c = 0;
		
		System.out.println(cs.checkCount(arr, b, c));
		}
}
