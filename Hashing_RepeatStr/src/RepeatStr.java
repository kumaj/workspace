import java.util.HashSet;
/*
 * Hashing_RepeatStr
 * Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class RepeatStr {
	public int lengthOfLongestSubstring(String a) {
		int i = 0;
		int j = 0;
		int count = 0;
		int max_count = 0;
		
		char[] str = a.toCharArray();
		HashSet<Character> h = new HashSet<Character>();
		
		while(j < str.length) {
			if(h.add(str[j])) { //add returns true if it is a non-reteated character
				count++;
				j++;
				if(count > max_count)
					max_count = count;
			} else { // if repeation is found then clear the hashset
				i++;
				j = i; 
				h.clear();
				count = 0;
			}
		} //while
		return max_count;
	}//end
}

class Solution {
	public static void main(String[] args) {
		
		RepeatStr r = new RepeatStr();
		//String a = "abcabcbb";
		
		String a = "bbbbbbbb";
		
		System.out.println(r.lengthOfLongestSubstring(a));
	}
}
