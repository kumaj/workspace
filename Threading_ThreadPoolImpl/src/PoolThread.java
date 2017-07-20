import java.util.concurrent.BlockingQueue;


public class PoolThread extends Thread {

	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;
	
	public PoolThread(BlockingQueue<Runnable> queue) {
		taskQueue = queue;
	}
	
	@Override
	public void run() {
		while(!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.remove();
				runnable.run();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public synchronized void doStop() {
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
	
	
}
