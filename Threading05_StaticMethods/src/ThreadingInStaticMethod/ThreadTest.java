package ThreadingInStaticMethod;
// Below example illustrate the behaviour of threads when it access a critical section
// Here incrementCount() and incCountY() are the critical section.
public class ThreadTest extends Thread {
	private int x = 0;
	private static int y = 0;
	
	private int incrementX() {
		x++;
		return x;
	}
	
	private static int incrementY() {
		y++;
		return y;
	}
	
	public void fun1() {
		System.out.println("In fun1() : " + Thread.currentThread().getName() + "::" + incrementX());
	}
	
	public void fun2() {
		System.out.println("In fun2() : " + Thread.currentThread().getName() + "::" + incrementX());
	}
	
	public static void fun3() {
		System.out.println("In fun3() : " + Thread.currentThread().getName() + "::" + incrementY());
	}
	
	public static void fun4() {
		System.out.println("In fun4() : " + Thread.currentThread().getName() + "::" + incrementY());
	}
	
	public void run() {
		fun1();
	//	fun2();
		fun3();
	//	fun4();
	}

}


class Solution {
	
	public static void main(String[] args) {
		
		//Both thread has the same runnable target
		Thread t1 = new ThreadTest();
		Thread t2 = new ThreadTest();
		
		t1.start();
		t2.start();
		
	}
}
