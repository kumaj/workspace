//This program has been taken from "concurrency in Java" book
//chapter 3 page 17
// This program illustrate the visibility of the variables among different threads
//If one thread change the values of one variable, then does another thread get's its updated value
//Let's check it out
package demo02;

public class NoVisibility extends Thread {
	public static Boolean ready = true;
	public static int number = 10;
	
	public void run()
	{
		while(ready)
		{
			System.out.println(number + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Main thread creates a new thread 
		NoVisibility t = new NoVisibility();
		t.start();
		
		System.out.println("hiiiiii");
		
		//Now change the value of number
		number = 20;
	}

}
