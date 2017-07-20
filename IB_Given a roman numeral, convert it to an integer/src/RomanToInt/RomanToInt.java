package RomanToInt;

/*Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
Read more details about roman numerals at Roman Numeric System
Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20 
// https://en.wikipedia.org/wiki/Roman_numerals#Roman_numeric_system

Symbol	Value
Ⅰ	1
Ⅴ	5
Ⅹ	10
Ⅼ	50
C	100
Ⅾ	500
Ⅿ	1,000 */

//Scan from right and kcheck if the prev element is less than current then add
//the current val into total else substract it eg IV, VI
public class RomanToInt {
	
	public int romanToInt(String a) {
		
		int len = a.length();
		int i = len - 1;
		char ch;
		int sum = 0;
		int val = 0;
		while(i >= 0)
		{
			ch = a.charAt(i);
			switch (ch)
			{
				case 'I':
					if(val > 1)
						sum = sum - 1;
					else
						sum = sum + 1;
					val = 1;
					break;
				case 'V':
					if(val > 5)
						sum = sum - 5;
					else
						sum = sum + 5;
					val = 5;
					break;	
				case 'X':
					if(val > 10)
						sum = sum - 10;
					else
						sum = sum + 10;
					val = 10;
					break;
				case 'L':
					if(val > 50)
						sum = sum - 50;
					else
						sum = sum + 50;
					val = 50;
					break;
				case 'C':
					if(val > 100)
						sum = sum - 100;
					else
						sum = sum + 100;
					val = 100;
					break;
				case 'D':
					if(val > 500)
						sum = sum - 500;
					else
						sum = sum + 500;
					val = 500;
					break;
				case 'M':
					if(val > 1000)
						sum = sum - 1000;
					else
						sum = sum + 1000;
					val = 1000;
					break;	
				default:
					break;
			}
			i--;
		}
		return sum;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		RomanToInt rmn = new RomanToInt();
		//String str = "MI";
		String str = "MDCCCIV";
		System.out.println(rmn.romanToInt(str));
	}
}