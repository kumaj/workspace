import java.util.concurrent.TimeUnit;

/**
 * This program has been copied from effective java book item no - 66
 * @author kumaj04
 *
 */
public class StopThread {
	// you can use the keyword volatile here as well which is nothing but an atomic operation
	private static boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside run : " + stopRequested);
				int i = 0;
				while(!stopRequested) {
					System.out.println("i : " + i);
					i++;
				}
			}
		});
		
		t1.start();
		System.out.println("Before sleep : " + stopRequested);
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		System.out.println("After sleep : " + stopRequested);
	}
}
