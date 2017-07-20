/**
 * This is the test class
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println("Now we are going to test the solution...");
		//First subscribe the user
		Observer ob = new Observer();
		ob.registerUser("Ajit");
		ob.registerUser("Alan");
		ob.registerUser("Donald");
		
		//Since they have subscribed...so they will receive the information
		Subject sub = new Subject(ob);
		sub.AddDiscount("Shirt");
		sub.AddDiscount("Mobile");
		sub.itemAdded("Laptop");
		
		ob.unRegisterUser("Donald");
		sub.AddDiscount("Laptop");
	}
}
