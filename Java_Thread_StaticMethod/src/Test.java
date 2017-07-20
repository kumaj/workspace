import java.util.ArrayList;

/**
 * http://stackoverflow.com/questions/17343157/static-method-behavior-in-multi-threaded-environment-in-java
 * This class contains one static method which has been called by 5 different thread. So in such case will there be a race condition?
 * @author kumaj04
 *
 */
public class Test implements Runnable {
	
	static int x = 0;
	public static void foo() {
		System.out.println("Inside foo .. " + Thread.currentThread().getName());
		x++;
		System.out.println(x + " " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exiting foo .. " + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		foo();
	}
}

class Solution {
	public static void main(String[] args) {
		Test t = new Test();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		Thread t5 = new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
