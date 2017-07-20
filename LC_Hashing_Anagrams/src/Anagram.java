import java.util.HashMap;
/*
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 */

public class Anagram {
	 public boolean isAnagram(String s, String t) {
	       boolean isAnagram = true;
	       
	       //use the hashing concept 
	       HashMap<Character, Integer> h = new HashMap<Character, Integer>();
	       //insert all the charcters of s in hash map
	       for(char ch : s.toCharArray()) {
	    	   if(h.containsKey(ch)) {
	    		   //get the existing count and increment it by one
	    		   int count = h.get(ch);
	    		   count++; //duplicates elemnts
	    		   h.put(ch, count);
	    	   } else {
	    		   h.put(ch, 1);
	    	   }
	       }
	       
	       // Iterate through 2nd string and check if the elements exists in hashmap or not
	       for(char ch : t.toCharArray()) {
	    	   if(!h.isEmpty()) {
		    	   if(h.containsKey(ch)) {
		    		   int count = h.get(ch);
		    		   count--;
		    		   if(count == 0)
		    			   h.remove(ch);
		    		   else 
		    			   h.put(ch, count);
		    	   } else {
		    		   isAnagram = false;
		    		   break;
		    	   }
	    	   } else {
	    		   isAnagram = false;
	    		   break;
	    	   }
	       }
	       if(!h.isEmpty()) 
	    	   isAnagram = false;
	       return isAnagram;
	    }
}

class Solution {
	
}