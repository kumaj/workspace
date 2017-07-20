import java.util.Scanner;


public class Piles {

}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String no_of_test_case = sc.nextLine();
		
		
		String no_of_element = sc.nextLine();
		String elements =  sc.nextLine();
		String[] elementsArr = elements.split(" ");
		
		// Go ahead and take the XOR of elements
		int res = 0;
		for(int i = 0; i< elementsArr.length; i++) {
			 res = res^ Integer.valueOf(elementsArr[i]);
		}
		if(res != 0)
			System.out.println("KILLED");
		else {
			// Find out the max sum of the elemnts
		}
	}
}
