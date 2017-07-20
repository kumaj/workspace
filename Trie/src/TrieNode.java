import java.util.HashMap;

/**
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries/
 * @author kumaj04
 *
 */
public class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;
	
	public TrieNode() { }
	
	public TrieNode(char c) {
		this.c = c;
	}
}

