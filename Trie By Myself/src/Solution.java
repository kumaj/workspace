/**
 * Driver class
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		// When constructor is called it initialises the root of the trie
		Trie t = new Trie();
		t.insert("aaa");
		t.insert("aab");
		
		System.out.println(t.search("paax"));
		System.out.println(t.searchPrefix("aa"));
		//write a method to find out all the words which has the prefix and print them.
	}
}
