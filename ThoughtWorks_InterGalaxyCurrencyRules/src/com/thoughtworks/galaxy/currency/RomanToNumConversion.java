package com.thoughtworks.galaxy.currency;

public class RomanToNumConversion {
	
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
