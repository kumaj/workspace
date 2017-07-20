package ThreadsInStaticClass;
/*
 * http://stackoverflow.com/questions/10664346/java-threads-effect-on-static-classes
 * how many 1's and how many 0's will be printed? how can I ensure that the number of 1's will be the same every 
 * time the program runs? notice that the class is static
 * How is it possible to evaluate the max and min appearances of "1"?
 */
public class ThreadTest extends Thread {

	int x;
	int[] y;
	
	public ThreadTest(int x, int[] y) {
		this.x = x;
		this.y = y;
	}
	
	public void run() {
		
		//What would be the result if synchronised block is used?
		//synchronized (this) {
			while(x < 5) {
				x++;
				System.out.println(Thread.currentThread().getName() + ":" + x);
			}
			
			while(y[0] < 105) {
				y[0]++;
				System.out.println(Thread.currentThread().getName() + ":" + y[0]);
			}
		//}
	}
}

class Solution {
	public static void main(String[] args) {
		int x = 0;
		int[] y = new int[1];
		y[0] = 100;
			
		//call the run method.
		
		Thread t1 = new ThreadTest(x, y);
		Thread t2 = new ThreadTest(x,y);
		
		t1.start();
		t2.start();
	}
	//After analyzing the output, we can observe that if thread-0 gives priority to thread-1
	//then thread-0 will resume from the same state from where it has stopped.
}
