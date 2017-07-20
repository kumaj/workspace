/**
 * 
 * @author kumaj04
 * This is the consumer class which will remove the element from the arraylist
 */
public class Consumer implements Runnable {

	SharedResource sdr;
	public Consumer(SharedResource sr) {
		this.sdr = sr;
	}
	
	@Override
	public void run() {
		//The consumer will wait for the produce to produce. 
		// It has to wait for the producer. Once the producer fill the element into the arraylist
		// it will notify to the consumer. So wait until u get the notification from the producer
		Object obj = sdr.getObj();
		synchronized (obj) {
			System.out.println("Inside synch block of consumer");
			try {
				System.out.println("Waiting inside consumer..");
				obj.wait();
				System.out.println("Waiting over inside consumer..");
				//wake up after the notification from the producer
				sdr.getArr().remove(0);
				System.out.println(Thread.currentThread().getName() + " Inside Consumer.. Removed done. Array Size : " + sdr.getArr().size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
