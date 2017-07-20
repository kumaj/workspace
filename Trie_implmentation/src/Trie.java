
/**
 * Class to insert node in trie
 * @author kumaj04
 *
 */
public class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Method to insert a word in trie
	 * @param str
	 */
	public void insert(String str) {
		TrieNode current = root;
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			//check if the char is already present in trie
			TrieNode temp = current.children.get(ch);
			if(temp == null) { // if it doesn't contain then create a new node and put the char in existing node and add the reference into new node.
				temp = new TrieNode();
				current.children.put(ch, temp);
			}
			current = temp;	
		}
		current.isEnd = true;
	}
	
	public boolean search(String str) {
		TrieNode current = root;
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			TrieNode temp = current.children.get(ch);
			if(temp == null)
				return false;
			current = temp;
		}
		return current.isEnd;
	}
}
