/**
 * A class that will wait for other threads to invoke notify methods to complete it’s processing. 
 * Notice that Waiter thread is owning monitor on Message object using synchronized block.
 * Difference between wait and Notify Vs Sleep
 * Wait and notify should always need an object's monitor. otherwise it will throw illegalMonitorException
 * Wait and Notify should always lie inside the synchronized block.
 * 
 * @author kumaj04
 *
 */
public class Waiter implements Runnable {

	private Message msg;
	
	public Waiter(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		synchronized (msg) {
			try{
				System.out.println(Thread.currentThread().getName() + " waiting to get modified at time " + System.currentTimeMillis());
				msg.wait(); // // if we remove the 'msg' object then the it will throw illegalMonitorState exception
			} catch(InterruptedException ex) {
				ex.getStackTrace();
			}
			 System.out.println(Thread.currentThread().getName()+" waiter thread got notified at time:"+System.currentTimeMillis());
	         //process the message now
	        // System.out.println(threadName+" processed: "+msg.getMsg());
		} // end of synchronized block
	}
}
