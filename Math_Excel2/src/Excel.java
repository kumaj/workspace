/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class Excel {
	public String convertToTitle(int a) {
		String res = new String();
		
		int rem;
		int digit;
		while(a > 0) {
			a--;
			rem = a % 26;
			digit = rem + 65;
			Character c = (char)digit;
			res = c.toString() + res; 
			a = a / 26;
		}
		return res;
	}
	
	//	wrong output for 953566->give BAQUZ whereas correct ans is BAQTZ
	public String convertToTitle_01(int a) {
		String res = new String();
		
		int rem;
		int digit;
		while(a > 0) {
			rem = a % 26;
			if(rem == 0)
				rem = 26;
			digit = rem + 64;
			Character c = (char)digit;
			res = c.toString() + res; 
			a = a / 26;
		}
		return res;
	}
	
	public String convertToTitle_02(int n) {
	    if(n <= 0){
	        throw new IllegalArgumentException("Input is not valid!");
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    while(n > 0){
	        n--;
	        char ch = (char) (n % 26 + 'A');
	        n /= 26;
	        sb.append(ch);
	    }
	 
	    sb.reverse();
	    return sb.toString();
	}
}

class Solution {
	public static void main(String[] args) {
		Excel e = new Excel();
		System.out.println(e.convertToTitle(20));
		System.out.println(e.convertToTitle_02(20));
//		System.out.println(e.convertToTitle(36291));
		System.out.println(e.convertToTitle(943566));
		System.out.println(e.convertToTitle_02(943566));
//		System.out.println(e.convertToTitle(0));
//		System.out.println(e.convertToTitle(1));
//		System.out.println(e.convertToTitle(25));
//		System.out.println(e.convertToTitle(26));
//		System.out.println(e.convertToTitle(676));
	}	
}
