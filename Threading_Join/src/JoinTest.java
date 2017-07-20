/**
 * This class shows the use of join method
 * Joins means that one thread should wait for another thread to get its task completed.
 * @author kumaj04
 *
 */
public class JoinTest implements Runnable {

	private double result;
	
	@Override
	public void run() {
		for(int i = 0; i< 1000; i++) {
			result = result + i;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setResult(result);
	}

	public double getResult() {
		return result;
	}

	public void setResult(double val) {
		this.result = val;
	}
}

class Solution {
	public static void main(String[] args) {
		JoinTest jt = new JoinTest();
		Thread t1 = new Thread(jt);
		t1.start();
		//here t1 thread will take some time to finish the addition of nos.
		// Once this task gets complete only then only proceed further. 
		// So main thread will wait for t1 to finsih its task.
		// comment the join() statement and then see the result.
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(jt.getResult());
		
		double finalResult = jt.getResult() + 100;
		System.out.println(finalResult);
		
	}
}
