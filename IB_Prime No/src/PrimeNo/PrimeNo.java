package PrimeNo;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeNo {

	public ArrayList<Integer> primesum(int A) 
	{
		//store all the prime Nos in arr
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//store the 2 prime no whose sum is A into prim arraylist
		ArrayList<Integer> prim = new ArrayList<Integer>();
	    
		//Get all the prime no and store it in arraylist
		arr.add(2);
		 for (int i=3; i<=A; i++) 
		 {
			 if((i%2 != 0) && isPrime(i))
				 arr.add(i);
		 }
        
		int i = 0;
		int j = arr.size() - 1;
		int sum = 0;
        while(i <= j)
        {
        	sum = arr.get(i) + arr.get(j);
        	if(sum == A)
        	{
        		prim.add(arr.get(i));
        		prim.add(arr.get(j));
        		return prim;
        	}
        	else if(sum > A)
        		j--;
        	else
        		i++;	
        }
        return prim;
	
    }
	
	//This method has used hashset to store the prime no
	// which will help to find the 2 nos faster as compared to 
	// above method.
	public ArrayList<Integer> primesum_02(int A) 
	{
		//store all the prime Nos in hashSet
		HashSet<Integer> set = new HashSet<Integer>();
		//store the 2 prime no whose sum is A into prim arraylist
		ArrayList<Integer> prim = new ArrayList<Integer>();
	    
		//Get all the prime no and store it in arraylist
		set.add(2);
		 for (int i=3; i<=A; i++) 
		 {
			 if((i%2 != 0) && isPrime(i))
				 set.add(i);
		 }
        
		 for(int i = 2; i<= set.size(); i++)
		 {
			 if(set.contains(i) && set.contains(A-i))
			 {
				 prim.add(i);
				 prim.add(A-i);
				 break;
			 }
		 }
        return prim;	
    }
	
	//This method has used hashset to store the prime no
	// which will help to find the 2 nos faster as compared to 
	// above method.
	public ArrayList<Integer> primesum_03(int A) 
	{
		//store all the prime Nos in hashSet
		HashSet<Integer> set = new HashSet<Integer>();
		//store the 2 prime no whose sum is A into prim arraylist
		ArrayList<Integer> prim = new ArrayList<Integer>();
	    
		//Get all the prime no and store it in arraylist
		set.add(2);
		 for (int i=3; i<=A; i++) 
		 {
			 if((i%2 != 0) && isPrime_02(i))
				 set.add(i);
		 }
        
		 for(int i = 2; i<= set.size(); i++)
		 {
			 if(set.contains(i) && set.contains(A-i))
			 {
				 prim.add(i);
				 prim.add(A-i);
				 break;
			 }
		 }
        return prim;	
    }
	
	//Best waay to find the prime no.
	public ArrayList<Integer> primesum_04(int A) 
	{
		//store all the prime Nos in hashSet
		HashSet<Integer> set = new HashSet<Integer>();
		//store the 2 prime no whose sum is A into prim arraylist
		ArrayList<Integer> prim = new ArrayList<Integer>();
	    
		//Get all the prime no and store it in arraylist
		set.add(2);
		 for (int i=3; i<=A; i++) 
		 {
			 if(isPrimeOrNot(i))
				 set.add(i);
		 }
        
		 for(int i = 2; i<= set.size(); i++)
		 {
			 if(set.contains(i) && set.contains(A-i))
			 {
				 prim.add(i);
				 prim.add(A-i);
				 break;
			 }
		 }
        return prim;	
    }

	private boolean isPrime(int num) 
	{
		for(int i = 2; i<num; i++)
		{
			if(num%i == 0)
				return false;
		}
		return true;
	}
	
	private boolean isPrime_02(int num) 
	{
		for(int i = 2; i<= Math.sqrt(num); i++)
		{
			if(num%i == 0)
				return false;
		}
		return true;
	}
	
	/* checking for division by even number, if its not divisible by 2. */ 
	public static boolean isPrimeNumber(int number) 
	{
		if (number == 2 || number == 3)
			{ return true; } 
		if (number % 2 == 0) 
			{ return false; } 
		
		int sqrt = (int) Math.sqrt(number) + 1; 
		for (int i = 3; i < sqrt; i += 2) 
		{ 
			if (number % i == 0) 
			{ return false; } 
		} 
			return true; 
	}
	
	/* * Third way to check if a number is prime or not. */ 
	public static Boolean isPrimeOrNot(int num) 
	{ if (num < 0) { return false; } 
	if (num == 0 || num == 1) { return false; } 
	if (num == 2 || num == 3) { return true; } 
	if ((num * num - 1) % 24 == 0) { return true; }
	else { return false; } } 
	
    /** Function to calculate all primes less than n **/
    private int[] calcPrimes(int N)
    {
        int[] arr = new int[N + 1];
        for (int i = 2; i <= Math.sqrt(N); i++)
        {
            if (arr[i] == 0)
            {
                for (int j = i * i; j <= N; j += i)
                {
                    arr[j] = 1;
                }
            }
        }
        return arr;
    }


}

class Solution
{
	public static void main(String[] args)
	{
		PrimeNo p = new PrimeNo();
		//int A = 4;
		//int A = 1048574;
		int A = 16777214;
		
//		long start_01 = System.nanoTime();
//		System.out.println(p.primesum(A));
//		long end_01 = System.nanoTime();
//		System.out.println("Time taken : " + (end_01 - start_01));
//		
//		//execute the 2nd method
//		long start_02 = System.nanoTime();
//		System.out.println(p.primesum_02(A));
//		long end_02 = System.nanoTime();
//		System.out.println("Time taken : " + (end_02 - start_02));
//		
//		//execute the 2nd method
//		long start_03 = System.nanoTime();
//		System.out.println(p.primesum_03(A));
//		long end_03 = System.nanoTime();
//		System.out.println("Time taken : " + (end_03 - start_03));
		
		//execute the 2nd method
		long start_03 = System.nanoTime();
		System.out.println(p.primesum_04(A));
		long end_03 = System.nanoTime();
		System.out.println("Time taken : " + (end_03 - start_03));
	}
}
