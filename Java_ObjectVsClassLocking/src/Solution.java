
/**
 * This is the test class which call the objectlock and classlock and see the difference between them
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Object objLock = new Object();
		Integer count = 0;
		ObjectLockTest obj = new ObjectLockTest(objLock, count);
		
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		
		t1.start();
		t2.start();
	}
}

