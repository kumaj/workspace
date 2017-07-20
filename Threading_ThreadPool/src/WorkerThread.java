
public class WorkerThread implements Runnable {

	private String message;
	public WorkerThread(String msg) {
		this.message = msg;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start Message = " + message);
		processMessage();
		System.out.println(Thread.currentThread().getName() + " End Message ");
	}
	
	private void processMessage() {
		try {
			System.out.println("\nInside Process Mesage...\n");
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
