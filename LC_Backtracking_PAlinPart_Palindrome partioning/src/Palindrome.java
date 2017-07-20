import java.util.List;



/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class Palindrome {

    public List<List<String>> partition(String s) {
      //Find the palindrome in s[i] and s[i+1, end] 
    	int len = s.length();
    	for(int i = 0; i < len-1; i++) {
    		String temp1 = s.substring(0, i);
    		String temp2 = s.substring(i+1, len);
    		//find all the palindromes in temp1 and temp2
    	}
    }
}

class Solution {
	
}
