import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
// http://tutorials.jenkov.com/java-concurrency/thread-pools.html

public class ThreadPool {

	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	private boolean isStopped = false;
	
	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new LinkedBlockingQueue<Runnable>(maxNoOfTasks);
		
		for(int i = 0;i<noOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for (PoolThread thread : threads) {
			thread.start();
		}
	}
	
	public synchronized void execute(Runnable task) throws Exception {
		if(this.isStopped) throw new IllegalStateException("ThreadPool is stopped");
		
		this.taskQueue.add(task);
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		for(PoolThread thread : threads)
			thread.doStop();
	}
}
