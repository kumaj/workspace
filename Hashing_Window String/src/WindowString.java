import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.interviewbit.com/problems/window-string/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"
 * @author kumaj04
 *
 */
public class WindowString {
	public String minWindow(String S, String T) {
		int i = 0;
		int j = 0;
		int sourceSize = S.length();
		int targetSize = T.length();
		
		// first of all put all the elements of T into hash map
		HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
		char[] targetChars = T.toCharArray();
		int charCount = 0;
		for(int k = 0; k < targetChars.length; k++) {
			if(targetMap.containsKey(targetChars[k])) {
				charCount = targetMap.get(targetChars[k]);
				targetMap.put(targetChars[k], ++charCount);
			} else {
				targetMap.put(targetChars[k], 1);	
			}
		}
		
		int max_length = Integer.MAX_VALUE;
		String result = "";
		int count = 0;
		while(i < sourceSize) {
			j = i;
			while(j < sourceSize) {
				if(isTargetMapCountNull(targetMap)) {
					int windowSize = j - i + 1;
					if(windowSize < max_length) {
						max_length = windowSize;
						result = S.substring(i, j+1);
					}
				} else {
					if(targetMap.containsKey(S.charAt(j))) {
						count = targetMap.get(S.charAt(j));
						if(count > 0)
							targetMap.put(S.charAt(j), --count);
					}
					j++;
				} // else
			} // inner while	
			i++;
		} // outer while
		return result;
	}
	
	private boolean isTargetMapCountNull(HashMap<Character, Integer> targetMap) {
		//iterate through the target map
		for (Map.Entry<Character, Integer> entrySet : targetMap.entrySet()) {
			if(entrySet.getValue() != 0)
				return false;
		}
		return true;
	}
}

class Solution {
	public static void main(String[] args) {
		WindowString w = new WindowString();
		System.out.println(w.minWindow("ADOBECODEBANC", "ABC"));
	}
}
