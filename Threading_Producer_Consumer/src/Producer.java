/**
 * 
 * @author kumaj04
 * This is the producer class which add new element into the arraylist
 */
public class Producer implements Runnable {

	//Get the sharedResource object. Once you have the object then you will get the 
	// arraylist and obj
	SharedResource sdResrce;
	
	public Producer(SharedResource sd) {
		this.sdResrce = sd;
	}

	@Override
	public void run() {
		Object objLock = sdResrce.getObj();
		Integer count = sdResrce.getCount();
		synchronized (objLock) {
			//Once the array has been filled then notify the consumer.
			sdResrce.getArr().add(count);
			System.out.println(Thread.currentThread().getName() + " Inside Producer..Added : " + count);
			count++;
			System.out.println("About to Notify");
			objLock.notify();
			System.out.println("Notification done");
		}
	}
}
