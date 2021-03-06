import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
/**
 * 
 * @author kumaj04
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class Fraction {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
	 
		String result = "";
	 
		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}
	 
		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
	 
		// quotient 
		long res = num / den;
		result += String.valueOf(res);
	 
		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;
	 
		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}
	 
			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}
	 
		return result;
	}
}

class Solution {
	public static void main(String[] args) {
		Fraction f = new Fraction();
		
		double res1 = 2.0/3.0;
		f.fractionToDecimal(4, 7);
		
		double res2 = 3227.0/555.0;
		int n2 = 3227;
		int d2 = 555;
		f.fractionToDecimal(n2, d2);
		
		double res3 = 1.0/9.0;
		System.out.println(res3);
		

		int n1 = 1;
		int d1 = 3;
		f.fractionToDecimal(n1, d1);
		
		int n = 9;
		int d = 11;
		f.fractionToDecimal(n, d);
		
	}
}

