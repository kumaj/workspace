package PossibleCombination;
/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
2-->abc; 3-->def; 4-->ghi; 5-->jkl; 6-->mno; 7-->pqrs; 8-->tuv; 9-->wxyz; 
The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
import java.util.ArrayList;

public class PossibleCombination {
	String reverseStr = "";
//	public ArrayList<String> letterCombinations(String a) {
//	
//	}
	
	public String reverseString(String str) {
		if(str == null || str.length() == 1)
			return str;
		reverseStr = str.charAt(str.length() -1) + reverseString(str.substring(0, str.length()-1));
		return reverseStr;
	}
}

class Solution {
	public static void main(String[] args) {
		PossibleCombination pc = new PossibleCombination();
		String str = "Ajit";
		System.out.println(str.length());
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(str.length()-1));
		System.out.println(str.substring(0, str.length()-1));
		System.out.println(pc.reverseString("Ajit"));
	}
}