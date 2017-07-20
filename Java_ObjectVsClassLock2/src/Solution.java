/**
 * Test class
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Shared sh = new Shared();
		Customthread t1 = new Customthread(sh, "One");
		Customthread1 t2 = new Customthread1(sh, "Two");
		//show1() is non static and show() is static. Now, show() is called by class name (or by object) and show1() 
		//is called by object, then both methods can accessed simultaneously by two threads.
		
		// If both show() and show1() are static then what would be the behaviour? Can both the methods be accessed simultaneosly?
		// Here show1() is being called using the instance variable ...
	}
}
