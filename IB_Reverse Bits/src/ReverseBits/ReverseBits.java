package ReverseBits;
/*Reverse bits of an 32 bit unsigned integer
x = 3,
00000000000000000000000000000011 
=> 11000000000000000000000000000000
return 3221225472;  This is nothing but sum of pow(2,31) and pow(2,30)*/ 
		
public class ReverseBits {

	public long reverse(long a) {
		//Get all the bits and multiply it with pow(2,31) and so on.
		int rem = 0;
		double sum = 0;
		int count = 31;
		while(a > 0)
		{
			rem = (int) (a%2);
			a = a/2;
			sum = sum + rem*Math.pow(2, count);
			count--;
		}
		return (long) sum;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		
	}
}
