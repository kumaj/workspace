import java.util.ArrayList;

/*
 * Math_Pow2
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 
 */
public class Power {
    public boolean isPower_02(int a) {
    	//First find all the factors of a no and store it in arraylist
    	ArrayList<Integer> arr = new ArrayList<Integer>();
        int factorNumber = 2;

        while(factorNumber <= a/2){
            if(a % factorNumber == 0){
               arr.add(factorNumber);
               a = a/factorNumber;
               factorNumber = 2;
            } else
            	factorNumber ++;
        }
        System.out.println(arr);
        return true;
    }
    
 // Returns true if n can be written as x^y
    public boolean isPower_01(int n)
    {
        // Base case
        if (n <= 1) return true;
     
        // Try all numbers from 2 to sqrt(n) as base
        for (int x=2; x<=Math.sqrt(n); x++)
        {
            int  p = x;
     
            // Keep multiplying p with x while is smaller
            // than or equal to x
            while (p <= n)
            {
                p *= x;
                if (p == n)
                    return true;
            }
        }
        return false;
    }
    
    public boolean isPower(int A) 
    {
        int i,a;
        double p;
        if(A == 1)
            return true;
        for(a = 1;a <= Math.sqrt(A);a++)
        {
            p = Math.log(A) / Math.log(a);
            if(p - (int)p < 0.000000001)
                return true;
        }
        return false;
    }
}

class Solution {
	public static void main(String[] args) {
		Power p = new Power();
//		p.isPower(1024);
//		p.isPower(2197);
		p.isPower(1024000000);
	}
}
