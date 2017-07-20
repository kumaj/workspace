import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/*
 * ANAGRAMSBookmark
Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]

Input = A : [ "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb" ]

Expected Output = [1 ] [2 ] [3 5 ] [4 ] [6 ] [7 ] [8 ] 

A : [ "caat", "taac", "dog", "god", "acta" ]
[1 2 5 ] [3 4 ] 
 */

public class Anagram {

	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashSet<String> h = new HashSet<String>();
		int len = a.size();
		for(int i = 0; i<len; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			h.add(a.get(i));
			arr.add(i+1); 
			int j;
			for(j = i+1; j<len;j++) {
				if(isAnagram(a.get(i),a.get(j))) {
					if(h.add(a.get(j))) {					
						arr.add(j+1);
					}
				} //if cond
			} //second loop
			if(j == len && !h.contains(a.get(i))) {
				res.add(arr);
			}
		} // first loop
		return res;
	}
	
	//Doesn't handle the case like [1,2,3] , [4]
	public ArrayList<ArrayList<Integer>> anagrams_03(final List<String> a) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashSet<String> h = new HashSet<String>();
		int len = a.size();
		for(int i = 0; i<len; i++) {
			int j;
			for(j = i+1; j<len;j++) {
				if(isAnagram(a.get(i),a.get(j))) {
					h.add(a.get(j));
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(i+1); arr.add(j+1);
					res.add(arr);
					break;
				} //if cond
			} //second loop
			if(j == len && !h.contains(a.get(i))) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i+1);
				res.add(arr);
			}
		} // first loop
		return res;
	}
	
	
	//Not working correctly
	public ArrayList<ArrayList<Integer>> anagrams_02(final List<String> a) {
		
		int len = a.size();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0 ; i<len-1; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(i+1);
			boolean flag = true;
			for(int j = i+1; j<len; j++) {
				if(isAnagram(a.get(i), a.get(j))) { // if anagram then store like [[i,j]]
					arr.add(j+1);
					res.add(arr);
					flag = false;
				}
			}
			if(flag == true) {
				res.add(arr);
			}
		}
		return res;
	}
	
	//Working correctly
	private boolean isAnagram(String s, String t) {
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
	
	public static void main(String[] args) {
//		String[] A = {"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb" };
//		List<String> l = new ArrayList<String>();
//		l.add("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba");
//		l.add("abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa");
//		l.add("babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab");
//		l.add("bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb");
//		l.add("abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab");
//		l.add("aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba");
//		l.add("abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa");
//		l.add("aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb");
//		
		String[] A = { "cat", "dog", "god", "tca" };
		List<String> aa = new ArrayList<String>();
//		aa.add("cat");
//		aa.add("dog");
//		aa.add("god");
//		aa.add("tca");
		
		aa.add("a");
		aa.add("b");
		aa.add("cd");
		aa.add("e");
		aa.add("dc");
		aa.add("f");
		aa.add("g");
		aa.add("h");
		Anagram a = new Anagram();
		a.anagrams(aa);
		
	}
}
