
// http://howtodoinjava.com/core-java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/
// http://stackoverflow.com/questions/17827022/what-is-countdown-latch-in-java-multithreading
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Processor implements Runnable {
	
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println("Started from Run Method");
		
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("latch count is : " + latch.getCount());
		//decreement the latch count.
		latch.countDown();
	}

}


class Solution {
	public static void main(String[] args) {
		//set the inital no of latches
		CountDownLatch latch = new CountDownLatch(3);
		//create 3 thread into the thread pool
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			//get the count of the latch
			System.out.println("latch count inside main : " + latch.getCount());
			latch.await();
			System.out.println("Inside main After await. Thread name is " + Thread.currentThread().getName());
		} catch(InterruptedException ex) {
			
		}
		// As soon as count reaches zero, Thread awaiting starts running. One of the disadvantages/advantages of CountDownLatch is that 
		//its not reusable once count reaches to zero you can not use CountDownLatch any more.
		
		// Classical example of using CountDownLatch in Java is any server side core Java application which uses services architecture, where multiple services are provided by
		// multiple threads and application can not start processing until all services have started successfully.
	}
}