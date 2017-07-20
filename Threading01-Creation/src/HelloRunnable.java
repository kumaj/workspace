// Program has been written based upon below links
// http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
//Program 01 :: program to illustrate the override of the rum method

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +  " Hello from a thread by implemneting the runnable interface");
		//let's print the name of the thread
		
		
	}
	
	public static void main(String[] args) {
		// Let's create a thread and call the run method
		//thread takes the object whose run method has to be executed
		new Thread(new HelloRunnable(), "AjitThread").start();
		
		//call the run method
		(new HelloRunnable02()).start();
		//same thing can be done by this also. but how we can put the properties on the thread ?
		HelloRunnable02 obj = new HelloRunnable02();
		obj.start();

	}

}

//let do the same program by extending the thread class
class HelloRunnable02 extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " Hello world from thread by extending the thread class.");
	}
}
