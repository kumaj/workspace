//This is the 1st program for Java multithreading
// Source cave of programming
package Demo01;

class Runner extends Thread
{
	public void run() {
		//count from 1 to 10 using thread
		for(int i=0; i<10; i++)
		{
			System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " .. " + Thread.currentThread().getPriority() + " " + Thread.currentThread().isAlive());
			//ask the thread to sleep for some time 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class Demo01 {

	public static void main(String[] args) {
		// let's create the thread and call it
		Runner runner1 = new Runner();
		runner1.start();
		
		//create another thread 
		Runner runner2 = new Runner();
		runner2.start();

	}

}
