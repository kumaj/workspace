// This program illustrate the concurreny issue faced by threads

//http://stackoverflow.com/questions/574240/is-there-an-advantage-to-use-a-synchronized-method-instead-of-a-synchronized-blo?rq=1

public class ConcurrencyIssue implements Runnable{

	private int counter = 10;
	public void increment()
	{
		counter++;
	}
	
	public void decrement()
	{
		counter--;
	}
	
	public int getValue()
	{
		return counter;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		increment();
		System.out.println(Thread.currentThread().getName() + " Value : " + counter);
	}
	
	public static void main(String[] args) {
		// create 2 threads and see the value of counter
		Thread t1 = new Thread(new ConcurrencyIssue(), "Thread-A");
		t1.start();

		Thread t2 = new Thread(new ConcurrencyIssue(), "Thread-B");
		t2.start();

	}

}
