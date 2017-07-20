//Reverse digits of an integer.
//Example1:
//x = 123,
//return 321
//Example2:
//x = -123,
//return -321
//Return 0 if the result overflows and does not fit in a 32 bit signed integer

package reverseDigit;

public class ReverseDigit {
	public int reverse(int a) {
		Integer num = a;
		int mult = 1;
		if(num < 0)
		{
			num = Math.abs(num);
			mult = -1;
		}
		String str = num.toString();
		char[] charArr = str.toCharArray();
		
		int len = str.length() - 1;
		for(int i = 0, j=len; i<j; i++, j--)
		{
			char ch = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = ch;
		}
		int total = 0;
		for(int j = len, i = 0; j >= 0; j--, i++)
		{
			int k = charArr[j] - 48;
			total = (int) (total + Math.pow(10, i)*k);
			if(total >= Integer.MAX_VALUE)
				return 0;
		}
		return total*mult;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		ReverseDigit rs = new ReverseDigit();
		System.out.println(rs.reverse(1111111123));
		System.out.println(Integer.MAX_VALUE);
	}
}
