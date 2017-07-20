
public class AsciiToInt {
	
	public int myAtoi(String a) {
		if (a == null || a.length() < 1)
			return 0;
	 
		// trim white spaces
		String str = a.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}
	
	// wrong output for 12a00
	public int myAtoi_02(String str) {
      
		//trim the string
		str = str.trim();
		if(str.length() < 1)
			return 0;
		
		int i = str.length() - 1;
		int total = 0;
		int k = 1;
		int multilplier = 1;
		int operatorCount = 0;
		
		while(i >= 0) {
			char ch = str.charAt(i);
			if(ch == '+') {
				if(operatorCount == 0) {
					multilplier = 1;
				    operatorCount++; }
				else
					return 0;
			} else if(ch == '-') {
				if(operatorCount == 0) {
					multilplier = -1;
					 operatorCount++; }
				else
					return 0;
			} else if(ch >= '0' && ch <='9') {
				int num = ch - '0'; 
				
				//return the max or min limit
				if(total <= 2147483647 && (total + k*num) < 0) {
					char c = str.charAt(0);
					if(c == '-')
						return -2147483648;
					else
						return 2147483647;
				}
					
				total = total + k*num;
				k = k*10;
			} else
				return 0;
			i--;
		}
		
		return multilplier*total;
    }
}

class Solution {
	public static void main(String[] args) {
		AsciiToInt a = new AsciiToInt();
/*		String s1 = "-1";
		System.out.println(a.myAtoi(s1));
		
		String s2 = "+-2";
		System.out.println(a.myAtoi(s2));
		
		String s3 = "1";
		System.out.println(a.myAtoi(s3));
		
		String s4 = "999999999999999999999999999999";
		System.out.println(a.myAtoi(s4));
		
		String s5 = "-999999999999999999999999999999";
		System.out.println(a.myAtoi(s5));*/
		
/*		String s6 = "-0012a42";
		System.out.println(a.myAtoi(s6));
		*/
		String s7 = "-a42";
		System.out.println(a.myAtoi(s7));
		
	}
}