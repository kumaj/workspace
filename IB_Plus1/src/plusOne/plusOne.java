
//Given a non-negative number represented as an array of digits,
//add 1 to the number ( increment the number represented by the digits ).
//The digits are stored such that the most significant digit is at the head of the list.
//Example:
//If the vector has [1, 2, 3]
//the returned vector should be [1, 2, 4]
//as 123 + 1 = 124.

package plusOne;

import java.util.ArrayList;
import java.util.Collections;

public class plusOne {
	
	// The problem with this approach is 
	// A : [ 9, 9, 9, 9, 9 ]
	// 1 0 0 0 0 0. The result should not be like this 10 0 0 0 0
	public ArrayList<Integer> plusOne_01(ArrayList<Integer> A)
	{
		int size = A.size() - 1;
		A.set(size, A.get(size)+1);
		
		int quot = 0;
		int rem = 0;
		for(int i = size; i > 0; i--)
		{
			A.set(i, A.get(i) + quot);
			quot = A.get(i) / 10;
			rem = A.get(i) % 10;
			A.set(i, rem);
		}
		A.set(0, A.get(0)+ quot);
		
		//Now try to remove the zeroes from the beginning
		//count the no of zeroes in the starting only
		int countZeroes = 0;
		for(int i = 0; i<= size; i++)
		{
			if(A.get(i) == 0)
				countZeroes++;
			else
				break;
		}
		
		int k = 0;
		while(A.get(k) == 0)
			A.remove(k);
		
		return A;
	}
	

	//reverse the collection and do the same process. It will solve the problem
	public ArrayList<Integer> plusOne(ArrayList<Integer> A)
	{
		int size = A.size() - 1;
		A.set(size, A.get(size)+1);
		
		Collections.reverse(A);
		int quot = 0;
		int rem = 0;
		for(int i = 0; i <= size; i++)
		{
			A.set(i, A.get(i) + quot);
			quot = A.get(i) / 10;
			rem = A.get(i) % 10;
			A.set(i, rem);
			//add the quotient 
			if(i == size && quot > 0)
				A.add(quot);
		}
		Collections.reverse(A);
		
		//Now try to remove the zeroes from the beginning
		//count the no of zeroes in the starting only
		int countZeroes = 0;
		for(int i = 0; i<= A.size(); i++)
		{
			if(A.get(i) == 0)
				countZeroes++;
			else
				break;
		}
		
		int k = 0;
		while(A.get(k) == 0)
			A.remove(k);
		
		return A;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		plusOne pls = new plusOne();
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		//A.add(0); A.add(0); A.add(0); A.add(0); A.add(0); A.add(1); A.add(2); A.add(3);
		
		// A : [ 9, 9, 9, 9, 9 ]
		// 1 0 0 0 0 0. The result should not be like this 10 0 0 0 0
		A.add(9); A.add(9); A.add(9);
		
		System.out.println(pls.plusOne(A));
	}
}
