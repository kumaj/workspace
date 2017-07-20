package SquareRootOfNo;

/*
 * BinarySearch :: SQRT
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
import java.util.ArrayList;

public class SquareRoot {

	//Brute force method --> Iterating from 1 to n and finding the square
	// Time complexity : O(n)
	public int sqrt(int a) {
	    int i = 0;
	    while(i <= a)
	    {
	        if((a > i*i && a < (i+1)*(i+1)) || a == i*i)
	        return i;
	        i++;
	    }
	    return -1;
	}
	
	/*Returns the square root of n. Note that the function */
	int squareRoot(int a)
	{
		int t;
		 
		int squareRoot = a / 2;
		if(squareRoot == 0)
			return 0;
		else
		{
			do {
				t = squareRoot;
				squareRoot = (t + (a / t)) / 2;
			} while ((t - squareRoot) != 0);
			return squareRoot;
		}
	}
	
	//Use binary search to find the square root of the no
	//Time complexity : log(n)
	public int sqrt_02(int a) 
	{
		//Call the binary search to find the squart root
		return BinarySearchForSqrt(a);
	}

	private int BinarySearchForSqrt(int a) 
	{
		int low = 0;
		int high = a;
		int root = 0;
		
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(mid*mid == a)
				return mid;
			
			else if(mid*mid < a)
			{
				root = mid;
				low = mid+1;
			}
			else
				high = mid-1;
		}
		return root;
	}
	
// Solved using the binary approach
// Time complexity : log(n)	
public int sqrt_03(int A) {
	    
	    int low, high, root;
	    int mid;
	    int num;
	    
	    low = 1;
	    high = A;
	    root = 0;
	    
	    while (low <= high) {
	        
	        mid = (low + high) / 2;
	        
	        if (mid == A / mid && (A % mid == 0))
	            return mid;
	            
	        if (mid <= A / mid) {
	            root = mid;
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	        
	    }
	    return root;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		//int n = 2147483647;
		int n = 10;
		SquareRoot sqr = new SquareRoot();
		//System.out.println(sqr.sqrt(2147483647));
		//System.out.println(sqr.squareRoot(3));
		
		//Get the squart using binary search
		//System.out.println(sqr.sqrt_02(n));
		
		System.out.println(sqr.sqrt_03(n));
	}
}
