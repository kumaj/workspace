import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/stepping-numbers/
 * @author kumaj04
 *
 */
public class SteppingNumber {
	//Increment the no one by one
	// then get the digits and compare it with its prev digit
	// if the diff is 1, then add it into the result 
	public ArrayList<Integer> stepnum(int a, int b) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = a; i<=b; i++) {
			//Now check each digit of i
			String str = Integer.toString(i);
			if(isSteppingDigit(str)) {
				arr.add(i);
			}
		}
		return arr;
	}

	private boolean isSteppingDigit(String str) {
		int len = str.length();
		if(len == 1)
			return false;
		char prev = str.charAt(0);
		Integer prevInt = prev - '0';
		for(int i = 1; i<len; i++) {
			char curr = str.charAt(i);
			Integer currInt = curr - '0';
			if(Math.abs(currInt-prevInt) != 1)
				return false;
			prevInt = currInt;
		}
		return true;
	}
	
	public int exist(ArrayList<String> a, String b) {
		
		String[][] board = new String[a.size()][];
	    for (int i = 0; i < a.size(); i++) {
	        String row = a.get(i);
	        board[i] = row.toCharArray().toString();
	    }
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
