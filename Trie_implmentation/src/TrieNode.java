import java.util.HashMap;

/**
 * Class to construct a trie node
 * @author kumaj04
 *
 */
public class TrieNode {
	char ch;
	HashMap<Character, TrieNode> children;
	boolean isEnd;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}
