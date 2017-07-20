import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
        	return false;
        
        //first sort the string and put it into hashmap
        HashSet<String> set = new HashSet<String>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        set.add(new String(s1));
        
        // why the fuck are u using the hashset.. use equals
        //return !set.add(new String(t1));
        
        return new String(s1).equals(new String(t1));
    }
    
    /*
     * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
     */
    
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
    		
    	//use the above logic to check if the stringa are anagrams or not and then put inside the hashmap
    	HashMap<String, ArrayList<Integer>> set = new HashMap<String, ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	int size = a.size();
    	if(size == 0)
    		return ret;
    	
    	for(int i = 0; i < size; i++) {
    		//check if the string is anagram then add the index to its value
    		char[] s1 = a.get(i).toCharArray();
            Arrays.sort(s1);
            String s2 = new String(s1);
    		if(set.containsKey(s2)) {
    			//get the value 
    			ArrayList<Integer> temp = set.get(s2);
    			temp.add(i+1);
    			//put the array back into the hashset
    			set.put(s2, temp);
    		} else {
    			ArrayList<Integer> arr = new ArrayList<Integer>();
    			arr.add(i+1);
    			set.put(s2, arr);
    		}
    	}
    	
    	//Now get all the elements from the hashset and put it into the arrayList
    	for (Map.Entry<String, ArrayList<Integer>> entry : set.entrySet()) {
			ret.add(entry.getValue());
		}
    	return ret;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
    	//use the above logic to check if the stringa are anagrams or not and then put inside the hashmap
    	HashMap<String, ArrayList<String>> set = new HashMap<String, ArrayList<String>>();
    	List<List<String>> ret = new ArrayList<List<String>>();
    	
    	int size = strs.length;
    	if(size == 0)
    		return ret;
    	
    	for(int i = 0; i < size; i++) {
    		//check if the string is anagram then add the index to its value
    		char[] s1 = strs[i].toCharArray();
            Arrays.sort(s1);
            String s2 = new String(s1);
    		if(set.containsKey(s2)) {
    			//get the value 
    			ArrayList<String> temp = set.get(s2);
    			temp.add(s2);
    			//put the array back into the hashset
    			set.put(s2, temp);
    		} else {
    			ArrayList<String> arr = new ArrayList<String>();
    			arr.add(s2);
    			set.put(s2, arr);
    		}
    	}
    	
    	//Now get all the elements from the hashset and put it into the arrayList
    	for (Map.Entry<String, ArrayList<String>> entry : set.entrySet()) {
    		ret.add(entry.getValue());
		}
    	return ret;
    }
}

class Solution {
	public static void main(String[] args) {
		Anagram a = new Anagram();
		
		String s = "cab";
		String t = "bcavv";
		System.out.println(a.isAnagram(s, t));
		
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<String> list = Arrays.asList(arr);
		
		System.out.println(a.anagrams(list));
		
		System.out.println(a.groupAnagrams(arr));
	}
}
