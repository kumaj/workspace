
public class DeadlockFixed implements Runnable {

	public void Method1() throws InterruptedException {
		synchronized (String.class) {
			System.out.println("Aquired lock on string.class object inside method1 by " + Thread.currentThread().getName() );
		}
		
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object inside method1 " + Thread.currentThread().getName());
		}
	}
	
	/* * This method also requests same two lock but in exactly
	 *  * Opposite order i.e. first Integer and then String. 
	 *  * This creates potential deadlock, if one thread holds String lock 
	 *  * and other holds Integer lock and they wait for each other, forever. */
	
	public void Method2() throws InterruptedException {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object inside method2 " + Thread.currentThread().getName());
		}
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object inside method2 " + Thread.currentThread().getName());
		}
	}

	@Override
	public void run() {
		try {
			Method1();
			Method2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class Solution {
	public static void main(String[] args) {
		DeadlockFixed d = new DeadlockFixed();
		Thread t1 = new Thread(new DeadlockFixed());
		t1.start();
		
		Thread t2 = new Thread(new DeadlockFixed());
		t2.start();
	}
}

