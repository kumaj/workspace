import java.util.concurrent.TimeUnit;

/**
 * This is the continuation of the "Java_Threading_Synchronization_Effective" part
 * Here synchronization keyword has been used
 * @author kumaj04
 *
 */
public class StopThread {
	// You can use the volatile keyword as well to do the synchronization
	// In that case you won't require the two synchronized method
private static boolean stopRequested;
	
	private static synchronized void stopRequest() {
		stopRequested = true;
	}
	
	private static boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside run : " + stopRequested);
				int i = 0;
				while(!stopRequested()) {
					System.out.println("i : " + i);
					i++;
				}
			}
		});
		
		t1.start();
		System.out.println("Before sleep : " + stopRequested);
		TimeUnit.SECONDS.sleep(1);
		stopRequest();
		System.out.println("After sleep : " + stopRequested);
	}
}
