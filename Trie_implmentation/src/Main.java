/**
 * Driver class to check the trie implementation
 * @author kumaj04
 *
 */
public class Main {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("aab");
		t.insert("aac");
		
		System.out.println(t.search("aa"));
	}
}
