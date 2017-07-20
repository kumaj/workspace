/**
 * This is the solution class which call the run method of Test1 and Test2
 * @author kumaj04
 * https://www.tutorialspoint.com/java/java_thread_deadlock.htm
 */
public class Solution {
	
	public static void main(String[] args) {

		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Thread t1 = new Thread(new Test1(lock1, lock2));
		Thread t2 = new Thread(new Test2(lock1, lock2));
		
		//start the thread
		t1.start();
		t2.start();
	}
}
