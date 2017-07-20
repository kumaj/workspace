/**
 * This is the test class which locks two objects lock1 and lock2
 * @author kumaj04
 *
 */
public class Test1 implements Runnable {

	private Object lock1;
	private Object lock2;
	//create the constructor which will pass the lock1 and lock2 object from the solution class
	// otherwise there is no other way to get the lock1 and lock2 objects
	public Test1(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		foo();
	}
	
	public void foo() {
		System.out.println("Inside foo");
		synchronized (lock1) {
			System.out.println("locked lock1 by " + Thread.currentThread().getName());
		//}
		
			// Remove the sleep statement and then check the output
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Waiting for lock2...");
			synchronized (lock2) {
				System.out.println("locked lock2 by " + Thread.currentThread().getName());
			}
		}
	}
}
