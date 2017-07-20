import java.util.Queue;
import java.util.concurrent.Semaphore;


public class Consumer implements Runnable {

	private Queue<Integer> queue;
	private Semaphore producerSem;
	private Semaphore consumerSem;
	public Consumer(Queue<Integer> queue, Semaphore prodSema, Semaphore conSema) {
		this.queue = queue;
		this.producerSem = prodSema;
		this.consumerSem = conSema;
	}

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			try {
				consumerSem.acquire();
				System.out.println("Consumed : " + queue.remove());
				producerSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}

}
