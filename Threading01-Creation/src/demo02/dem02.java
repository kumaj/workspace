// Write a program to create a thread by implementing runnable interface
package demo02;

class Runner implements Runnable
{
	public void run() {
		for(int i = 0; i < 5 ; i++)
		{
			System.out.println(Thread.currentThread().getName() + "...   " + i + "  " + Thread.currentThread().getClass() + " .." + Thread.activeCount());
			//ask the thread to sleep for some time
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//let's destroy the thread here
		}
		
	}
	
}
public class dem02 {

	public static void main(String[] args) {
		//let's call the thread
		Runner runObj = new Runner();
		Thread t1 = new Thread(runObj);
		t1.start();
		//t1.stop();
		
		//let's create another thread
		Thread t2 = new Thread(new Runner());
		t2.start();
		
	}

}
