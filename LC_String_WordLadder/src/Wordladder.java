import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author kumaj04
 *Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */

class WordNode {
	String word;
	int numSteps;
	
	public WordNode(String word, int numSteps) {
		this.word = word;
		this.numSteps = numSteps;
	}
}
public class Wordladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));
		
		wordDict.add(endWord);
		
		while(!queue.isEmpty()) {
			//remove the first element from the queue
			WordNode top = queue.remove();
			String word = top.word;
			
			//if the first and endwords are equal then return77 from here itself
			if(word.equals(endWord)) {
				return top.numSteps;
			}
			
			char[] arr = word.toCharArray();
			//create a new word by replacing a character and check if it exists into the wordlist or not
			for(int i = 0; i < arr.length; i++) {
				for(char c ='a'; c<='z';c++) {
					char temp = arr[i];
					if(arr[i] != c)
						arr[i] = c;
					
					String newWord = new String(arr);
					if(wordDict.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordDict.remove(newWord);
					}
					
					//put the original character
					arr[i] = temp;
				} //inner for loop
			} //outer for loop
		} //while loop
		return 0;
	}
}

class Solution {
	public static void main(String[] args) {
		Wordladder w = new Wordladder();
		
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hip");
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		
		System.out.println(w.ladderLength(beginWord, endWord, wordList));
		
	}
}
