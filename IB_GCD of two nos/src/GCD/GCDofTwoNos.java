package GCD;

/*Given 2 non negative integers m and n, find gcd(m, n)
GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Example
m : 6
n : 9
GCD(m, n) : 3 
*/
public class GCDofTwoNos {

	public int gcd(int a, int b) 
	{
		while(a!=b)
		{
			if(a>b)
				a = a-b;
			else
				b = b-a;
		}
		return a;			
	}
	
	//Method2
	public int gcd_02(int a, int b)
	{
		int gcd = 0;
		for(int i = 1; i<=a || i<=b; i++)
		{
			if((a%i==0) &&(b%i==0))
			{
				gcd = i;
			}
		}
		return gcd;
	}
	
	//Method3
	public int gcd_03(int a, int b)
	{
		int gcd = 0;
		int min = (a > b)?b:a;
		for(int i = min; i> 0; i--)
		{
			if((a%min==0) &&(b%min==0))
			{
				gcd = i;
				break;
			}
		}
		return gcd;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		GCDofTwoNos gc = new GCDofTwoNos();
	}
}
