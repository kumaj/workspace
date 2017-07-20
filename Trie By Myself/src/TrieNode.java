import java.util.HashMap;

/**
 * What does a trie node contains. Achar, a hashMap and a boolean
 * @author kumaj04
 *
 */
public class TrieNode {

	public char val;
	HashMap<Character, TrieNode> children;
	boolean isEnd;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}
