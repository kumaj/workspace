/**
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * @author kumaj04
 *
 */
public class TrieNode {
	TrieNode[] arr;
	boolean isEnd;
	
	public TrieNode() {
		this.arr = new TrieNode[26];
	}
}
