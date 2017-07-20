import java.util.ArrayList;


public class Permutation {

	ArrayList<Integer> getAllPermutation(int[] num) { // num = 934
		ArrayList<Integer> result = new ArrayList<Integer>();
	
		int length = num.length;
		
		if( length == 1) {
			result.add(num[0]);
			return result;
		}
		
		// add the first digit into the result 
		result.add(num[0]); // res = {9}
		
		int start = 1;
		int end = length;
		
		// Iterate through arraylist and insert the digit into it
		for(int i = start; i < end; i++) {
			permutate(result, num[1], str.substring(0, 1));
		}
		return result;
	}
	
	private void permutate(ArrayList<Integer> res, int digitToBeInserted, Integer num) {
		// get the size of the num
		String inputStr = String.valueOf(num);
		int length = inputStr.length();
		
		// insert the digit at 0, 1, 2....n-1 places one by one
		for(int i = 0; i <  length; i++) {
			String str = inputStr.substring(0, i+1) + String.valueOf(digitToBeInserted) + inputStr.substring(i+1, length-1);
			res.add(Integer.valueOf(str));
		}
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
