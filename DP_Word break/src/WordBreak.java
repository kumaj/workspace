import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * @author kumaj04
 *
 */
public class WordBreak {
	public int wordBreak(String a, ArrayList<String> b) {
		//Put all elements of arraylist into hashmap
		HashMap<String, Integer> wordmap = new HashMap<String, Integer>();
		for (String word : b) {
			if(wordmap.containsKey(word)) { // if the word already exists then increment the count of the word.
				int count = wordmap.get(word);
				wordmap.put(word, ++count);
			} else {
				wordmap.put(word, 1);
			}
		}
		
		//Now parse the string and check if it present in the map or not
		// if it is present remove it from map. In the end map size == 0
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<a.length(); i++) {
			char c = a.charAt(i);
			str.append(c);
			String strWord = str.toString();
			if(wordmap.containsKey(strWord.toString())) {
				int count = wordmap.get(strWord);
				if(count == 1) { // if only one word is present
					wordmap.remove(strWord);
				} else {
					wordmap.put(strWord, --count);
				}
				str = new StringBuilder();
			} // if
		} // for
		
		if(wordmap.size() == 0)
			return 1; 
		else
			return 0;
	}
	
	//Leet code -- Program creek solution copied
	// http://www.programcreek.com/2012/12/leetcode-solution-word-break/
	 public boolean wordBreak(String s, Set<String> dict) {
	        boolean[] t = new boolean[s.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<s.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String a: dict){
	                int len = a.length();
	                int end = i + len;
	                if(end > s.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(s.substring(i, end).equals(a)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[s.length()];
	    }
	 
		public int wordBreak_02(String a, ArrayList<String> b) {
		    
		    String s = a;
		    	//Put all elements of arraylist into hashmap
			HashSet<String> dict = new HashSet<String>();
			for (String word : b) {
					dict.add(word);
			}

		   boolean[] t = new boolean[s.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<s.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String a: dict){
	                int len = a.length();
	                int end = i + len;
	                if(end > s.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(s.substring(i, end).equals(a)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[s.length()];
		}
}

class Solution {
	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("trainer");
		arr.add("my");
		arr.add("interview");
		
		String a = "myinterviewtrainer";
		
		System.out.println(w.wordBreak(a, arr));
		
		ArrayList<String> arr2 = new ArrayList<String>();
		arr.add("a");
		arr.add("a");
		
		String a2 = "aa";
		
		System.out.println(w.wordBreak(a2, arr2));
	}
}
