/**
 * 
 * @author kumaj04
 * Class to test the producer consumer scenario
 */
public class Solution {
	public static void main(String[] args) {
		SharedResource sr = new SharedResource();
		
		Producer pr = new Producer(sr);
		Consumer cr = new Consumer(sr);
		Thread t1 = new Thread(pr);
		Thread t2 = new Thread(cr);
		
		
		/**
		 * Here os a trick which can cause a deadlock situation
		 * t1.start();
		 * t2.start();
		 * Think why it will cause the deadlock situation.
		 */
		t2.start();
		t1.start();
		
		
	}
}
