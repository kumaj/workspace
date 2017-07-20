
/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1
 */
public class Factorial {
	
	//Get the factorail of a no
	public Integer factorial(int n) {
		Integer fact = 1;
		for(int i = 1; i <= n; i++) {
			fact = fact * i; 
		}
		return fact;
	}
	
	//get the trailing zeroes in logarithmic time
	public int trailingZeroes(int n) {
		if (n < 0)
			return -1;
	 
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
	 
		return count;
	}
	
	// get the no of trailing zeroes of factorial a
	public int trailingZeroes_02(int a) {
		int no_of_zeroes = 0;
		
		for(int i = 1; i <= a; i++) {
			if(i % 5 == 0)
				no_of_zeroes++;
		}
		return no_of_zeroes;
	}
}

class Solution {
	public static void main(String[] args) {
		Factorial f = new Factorial();
		
		System.out.println(f.trailingZeroes(25));
	}
}
