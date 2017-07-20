package ThreadsInStaticMethods;

 /*
 * In the previous class we have seen that result is ambigous. In order to come out of 
 * this problem we will make the method as synchronized.
 * Even though we have make the function as synchronized, still the result is ambigous.
 * Check the result in version1.3
 */
public class ThreadTest extends Thread {
	private int x = 0;
	private static int y = 0;
	
	private synchronized int incrementCount() {
		x++;
		return x;
	}
	
	private synchronized static int incCountY() {
		y++;
		return y;
	}
	
	public void fun1() {
		System.out.println("In fun1() : " + Thread.currentThread().getName() + "::" + incrementCount());
	}
	
	public void fun2() {
		System.out.println("In fun2() : " + Thread.currentThread().getName() + "::" + incrementCount());
	}
	
	public static void fun3() {
		System.out.println("In fun3() : " + Thread.currentThread().getName() + "::" + incCountY());
	}
	
	public static void fun4() {
		System.out.println("In fun4() : " + Thread.currentThread().getName() + "::" + incCountY());
	}
	
	public void run() {
		fun1();
		//fun2();
		fun3();
		//fun4();
	}

}

class Solution {
	
	public static void main(String[] args) {
		
		//Let's create the thread instance
		Thread t1 = new ThreadTest();
		Thread t2 = new ThreadTest();
		
		t1.start();
		t2.start();
		
	}
}

