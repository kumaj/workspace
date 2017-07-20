import java.io.IOException;

/**
 * Read a file and check names that ends with 'aa'
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Names.txt";
		NameTester n = new NameTester();
		n.getName_2(path);
	}
}
