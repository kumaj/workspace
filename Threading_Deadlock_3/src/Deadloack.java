// http://www.java2novice.com/java-interview-programs/thread-deadlock/
// This is the modified version of the deadlock_2 program where the classes are static. But here the classes are normal and check
// out how the lock objects has been created using the Lockclass and has been used inside Thread1 and Thread2 classes.
// Never ever create the new object inside the thread1 and thread2 classes otherwise there wouldn't be any deadlock situation.
//Basic logic
//LockClass - 2 instance are created
//Thread1, THread2 try to take lock on these objects in different order
//with a delay in between and deadlock happens
public class Deadloack {
	public static void main(String args[]) throws Exception{//not a good practice, ideally should handle
		LockClass a = new LockClass();
		LockClass b = new LockClass();
		Thread1 thread1 = new Thread1(a,b);//These are actually application classes having thread property
		Thread2 thread2 = new Thread2(a,b);
		new Thread(thread1,"Thread1").start();//Thread1 starts executing run and get lock of a and wait 1 sec
		Thread.sleep(500);
		new Thread(thread2,"Thread2").start();//thead to starts after 500 ms and gets lock to b and try to get lock on a
	}
}

class Thread1 implements Runnable {
	private LockClass a;
	private LockClass b;
	public Thread1(LockClass a, LockClass b) {
		this.a = a;
		this.b = b;
	}
	public void run() {
		synchronized (a) {// Thread 1 gets lock to a and goes to sleep for 1
							// sec
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1 trying to get lock on b");
			synchronized (b) {
				System.out.println("THread1 got all lock");
			}
		}
	}
}

class Thread2 implements Runnable {
	private LockClass a;
	private LockClass b;
	public Thread2(LockClass a, LockClass b) {
		this.a = a;
		this.b = b;
	}
	public void run() {
		synchronized (b) {// Thread2 gets lock on b and try to get lock on a
							// after 500ms
			System.out.println("Thread2 trying to get lock on a");
			synchronized (a) {
				System.out.println("Thread2 got all lock");
			}
		}
	}
}
class LockClass {
}
