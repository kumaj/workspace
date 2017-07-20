// This class demonstrate the use of synchronized keyword
package demo01;

public class demo01 {
	
	private int count = 0;
	public static void main(String[] args) {
		
		demo01 d = new demo01();
		d.doWork();
		//System.out.println("count :: " + count);

	} //main
	
public void doWork()
{
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i =0;i<100; i++)
				count++;
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i = 0; i< 100; i++)
				count++;
		}
	});
	
	//let's call the threads
	t1.start();
	t2.start();
	
	// the value of the count should be 200
	// but we found that it's random because 
	// count++ is not an atomic operation it is 
	// count = count + 1;
	System.out.println("count :: " + count);
}

}//class
