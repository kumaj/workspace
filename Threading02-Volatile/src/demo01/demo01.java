// This program illustrate the use of the volatile keyword in threading
//Volatile keyword is used to share the members between different threads
package demo01;

import java.util.Scanner;

class Runner implements Runnable
{
	volatile boolean running = true;
	public void run() {
		while(running)
		{
			System.out.println(Thread.currentThread().getName() + " " + running);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // while		
	} // run
	
	public void shutdown()
	{
		running = false;
	}
	
}

public class demo01 {
	public static void main(String[] args)
	{
		//thread is running in infinite loop 
		Runner r1 = new  Runner();
		Thread t1 = new Thread(r1);
		t1.start();

		//let's change the variable to false
		// so now the loop has to be stooped
		System.out.println("Press return to stop..");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		r1.shutdown();
	}
}
