import java.util.Queue;
import java.util.concurrent.Semaphore;


public class Producer implements Runnable {

	private Queue<Integer> queue;
	private Semaphore producerSem;
	private Semaphore consumerSem;
	public Producer(Queue<Integer> queue, Semaphore prodSema, Semaphore conSema) {
		this.queue = queue;
		this.producerSem = prodSema;
		this.consumerSem = conSema;
	}

	@Override
	public void run() {
		// Here observe the fact that synchronize keyword is not being used at all.
		
		for(int i = 0; i<10; i++) {
			try {
/*				System.out.println("Producer Permit count : " + producerSem.availablePermits());
				producerSem.acquire();*/ // If the permit count has already reached to zero, then again if you try to acquire 
				// the semaphore thne it will become dormat or you can say inactive. It stopped the execution.
				//System.out.println("Producer Permit count : " + producerSem.availablePermits());
				producerSem.acquire();
				//System.out.println("Producer Permit count : "  + producerSem.availablePermits());
				System.out.println("Produced : " + i);
				queue.add(i);
				consumerSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
