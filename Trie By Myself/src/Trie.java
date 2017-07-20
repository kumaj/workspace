/**
 * This is the actual implementation of the Trie data structure.
 * Methods like insert, search and prefix search are exposed here.
 * @author kumaj04
 *
 */
public class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	/**
	 * Method to insert the node in trie
	 * @param str user input 
	 */
	public void insert(String str) {
		TrieNode current = root;
		for(int i = 0; i<str.length(); i++) {
			//get each char 
			char c = str.charAt(i);
			TrieNode temp = current.children.get(c);
			if(temp == null) { // character doesn't exist
				temp = new TrieNode();
				current.children.put(c, temp);
			}
			current = temp;
		}
		current.isEnd = true;
	}
	
	/**
	 * Method to search a string in trie
	 * @param str
	 * @return
	 */
	public boolean search(String str) {
		TrieNode current = root;
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			TrieNode temp = current.children.get(c);
			if(temp == null) 
				return false;
			current = temp;
		}
		return current.isEnd;
	}
	
	/**
	 * Method to check if the prefix exist in the tie or not
	 * @param prefix
	 * @return
	 */
	public boolean searchPrefix(String prefix) {
		TrieNode current = root;
		for(int i=0; i< prefix.length(); i++) {
			char c = prefix.charAt(i);
			TrieNode temp = current.children.get(c);
			if(temp == null)
				return false;
			current = temp;
		}
		return true;
	}

}
