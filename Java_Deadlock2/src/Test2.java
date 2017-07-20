/**
 * This is the test class which locks two objects lock2 and lock1 in reverse order as compared to test1.java class
 * @author kumaj04
 *
 */
public class Test2 implements Runnable {
	
	private Object lock1;
	private Object lock2;
	//create the constructor which will pass the lock1 and lock2 object from the solution class
	// otherwise there is no other way to get the lock1 and lock2 objects
	public Test2(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		fun();
	}
    
	public void fun() {
		System.out.println("Inside Test2::fun()");
		synchronized (lock2) {
			System.out.println("Acquired lock2 by "  + Thread.currentThread().getName());
		//}
			
			// Remove the sleep statement and then check the output
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiting for lock1...");
			synchronized (lock1) {
				System.out.println("Acquired lock1 by "  + Thread.currentThread().getName());
			}
		}	
	}
}
