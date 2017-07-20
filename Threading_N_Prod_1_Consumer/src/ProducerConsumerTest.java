import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 *  This class will test the producer and consumer using semaphore and blockingQueue
 *  Here there are 2 producer and 1 consumer
 * @author kumaj04
 *
 */
public class ProducerConsumerTest {

	public static void main(String[] args) {
		Semaphore prodSema = new Semaphore(2);
		Semaphore conSema = new Semaphore(0);
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		Producer pd = new Producer(queue, prodSema, conSema);
		Consumer cs = new Consumer(queue, prodSema, conSema);
		
		new Thread(cs).start();
		new Thread(pd).start();
		new Thread(pd).start();
	}
}
