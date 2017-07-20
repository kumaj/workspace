import java.util.HashSet;


/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	
    	if(s.length() <= 0)
    		return 0;
    	
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int len = s.length();
        
        HashSet<Character> set = new HashSet<Character>();
        while(j < len) {
        	if(set.add(s.charAt(j))) {
        		if((j-i) > maxLen)
        			maxLen = j - i;
        		j++;
        	} else { // some duplicate has been found
        		//remove the elements before the duplicate
        		while(s.charAt(i) != s.charAt(j)) {
        			set.remove(s.charAt(i));
        			i++;
        		}
        		i++;
        		j++;
/*        		if((j-1) > maxLen)
        			maxLen = j - i;*/
        	}
        }
        maxLen +=  1;
        return maxLen;
    }
}

class Solution {
	public static void main(String[] args) {
		LongestSubstring l = new LongestSubstring();
		
		String s1 = "abcabc";
		System.out.println(l.lengthOfLongestSubstring(s1));
		
		String s2 = "";
		System.out.println(l.lengthOfLongestSubstring(s2));
		
		String s3 = "bbbb";
		System.out.println(l.lengthOfLongestSubstring(s3));
		
		String s4 = "xyzkabccsdkjfnalsdas";
		System.out.println(l.lengthOfLongestSubstring(s4));
		
		String s5 = "au";
		System.out.println(l.lengthOfLongestSubstring(s5));
	}
}
