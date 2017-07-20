import java.util.Scanner;

/**
 * 
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		//Take the input from user
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String userInput = sc.nextLine();
			if("quit".equals(userInput)) {
				break;
			}
			System.out.println("User input : " + userInput);
		}
	}
}
