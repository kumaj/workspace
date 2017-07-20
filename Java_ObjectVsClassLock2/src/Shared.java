/**
 * This class illustrate the difference between objecta nd class level locking.
 * http://stackoverflow.com/questions/3718148/java-class-level-lock-vs-object-level-lock
 * @author kumaj04
 *
 */
public class Shared {
	static int x;
	static synchronized void show(String str, int i) {
		x = i;
		System.out.println("Starting in method : " + str + " " +  x);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending the method : " + str + " " + x);
	}
	
	synchronized void show1(String str, int i) {
		x = i;
		System.out.println("Starting show1() in method : " + str + " " + x);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending show1() the method : " + str + " " + x);
	}
}

class Customthread extends Thread {
	Shared s;
	public Customthread(Shared s, String str) {
		super(str);
		this.s = s;
		start();
	}
	
	public void run() {
		Shared.show(Thread.currentThread().getName(), 10);
	}
}

class Customthread1 extends Thread {
	Shared s;
	public Customthread1(Shared s, String str) {
		super(str);
		this.s = s;
		start();
	}
	
	public void run() {
		s.show1(Thread.currentThread().getName(), 20);
	}
}

