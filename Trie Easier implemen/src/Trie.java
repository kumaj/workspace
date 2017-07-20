import java.util.HashMap;

/**
 * This is the easier implementation of the trie data structure 
 * Copied from Tushaar Roy video from you tube. It's worth watching.
 * @author kumaj04
 *
 */
// Trie node 
class TrieNode {
	HashMap<Character, TrieNode> children;
	boolean isEnd;
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}

public class Trie {

	private final TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	/**
	 * Method to insert the node
	 * See how easy the code is
	 * @param word
	 */
	public void insert(String word) {
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++) {
			// check if the word already exists
			char c = word.charAt(i);
			TrieNode newNode = current.children.get(c);
			if(newNode == null) { // no such character is present
				newNode = new TrieNode();
				current.children.put(c, newNode);
			}
			current = newNode;
		}
		current.isEnd = true;
	}
	
	/**
	 * Insert the word recursively
	 * @param word
	 */
	public void insertRecursive(String word) {
		TrieNode current = root;
		recursiveInsert(word, current, 0);
	}
	
	private void recursiveInsert(String word, TrieNode current, int index) {
		if(index >= word.length()) {
			current.isEnd = true;
			return;
		}
		char c = word.charAt(index);
		TrieNode node = current.children.get(c);
		if(node == null) {
			node = new TrieNode();
			current.children.put(c, node);
		}
		recursiveInsert(word, node, ++index);
	}

	/**
	 * Search the word if it exist in the trie or not
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null)
				return false;
			current = node;
		}
		return current.isEnd;
	}
	
	/**
	 * Method to search the word recursivly
	 * @param word
	 * @return
	 */
	public boolean searchRecursively(String word) {
		return searchRecursivly(word, root, 0);
	}

	private boolean searchRecursivly(String word, TrieNode current, int index) {
		if(index >= word.length())
			return current.isEnd;
		char c = word.charAt(index);
		TrieNode node = current.children.get(c);
		if(node == null)
			return false;
		return searchRecursivly(word, node, ++index);		
	}	
	
	/**
	 * Method to check if the prefix is available
	 * @param prefix
	 * @return
	 */
	public boolean hasPrefixFound(String prefix) {
		TrieNode current = root;
		for(int i = 0; i<prefix.length(); i++) {
			char c = prefix.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null) // if any of the prefix character is not avaialble then the prefix is not available.
				return false;
			current = node;
		}
		return true;
	}
}

class Solution {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insertRecursive("aaa");
		t.insert("aa");
		t.insert("aab");
		t.insert("ab");
		
		System.out.println(t.search("aaac"));
		System.out.println(t.searchRecursively("aaa"));
		System.out.println(t.hasPrefixFound("ax"));
	}
}
