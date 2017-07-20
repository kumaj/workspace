// Given a column title as appears in an Excel sheet, return its corresponding column number.
//Example:
//    A -> 1  
//    B -> 2  
//    C -> 3   
//    ...  
//    Z -> 26  
//    AA -> 27    
//    AB -> 28 

package titleNo;

public class TitleNumber {
	
	public int titleToNumber(String a) {
		
		int pow = 0;
		int len = a.length() -1;
	    int total = 0;
		for(int i = len; i >= 0; i--)
		{
			char c = a.charAt(i);
			int char_value = (int)c - 64;
			if(char_value < 1 || char_value > 26){
				System.out.println("Expected output is Invalid Input! All characters should be A-Z");
				return -1;
			}
			total = (int) (total + Math.pow(26, pow)*char_value);
			pow++;
		}
		return total;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		TitleNumber tl = new TitleNumber();
		int total = tl.titleToNumber("ZZZ");
		System.out.println(total + " ");
	}
}
