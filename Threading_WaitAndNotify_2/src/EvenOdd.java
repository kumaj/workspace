/**
 *  
 * @author kumaj04
 * Take 2 thread where one thread will print even no and another thread print odd no upto 10
 * http://stackoverflow.com/questions/1553886/java-lang-illegalmonitorstateexception-m-null-failed-to-get-monitor-for
 * http://howtodoinjava.com/core-java/multi-threading/thread-synchronization-object-level-locking-and-class-level-locking/
 */
public class EvenOdd implements Runnable {

	private int i = 0;
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	@Override
	public void run() {
		PrintEvenOdd();
	}
	
	private void PrintEvenOdd() {
		synchronized (obj1) {
			try {
				for(int i =0; i<=10; i=i+2) {
					System.out.println(Thread.currentThread().getName() +  " " + i);
					//obj1.wait();
					//obj2.notify();
					Thread.sleep(1000);
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}  // end of obj1 synchronization
		
		synchronized (obj2) {
			try {				
				for(int i = 1; i <= 9; i=i+2) {
					System.out.println(Thread.currentThread().getName() + " " + i);
					//obj2.wait();
					//obj1.notify();
					Thread.sleep(1000);
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}

class Solution {
	public static void main(String[] args) {
		EvenOdd eo = new EvenOdd();
		Thread t1 = new Thread(eo, "Thread_1");
		Thread t2 = new Thread(eo, "Thread_2");
		t1.start();
		t2.start();

	}
}
