/**
 * A class that will process on Message object and then invoke notify method to wake up threads waiting for Message object. 
 * Notice that synchronized block is used to own the monitor of Message object.
 * @author kumaj04
 *
 */
public class Notifier implements Runnable {

	private Message msg;
	
	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				System.out.println("Inside the Notifier class run method");
				msg.setMsg(threadName +" Notifier work done");
				msg.notify(); // if we remove the 'msg' object then the it will throw illegalMonitorState exception
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
