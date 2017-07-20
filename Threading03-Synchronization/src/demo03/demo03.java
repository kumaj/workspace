//As we have seen that the value of the count in demo01 is not 
// correct. So we will use the synchronized keyword
package demo03;

public class demo03 {

	//shared variable 
	private int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo03 dm = new demo03();
		dm.doWork();

	}
	//use the synchronized keyword
	public synchronized void increment()
	{
		count++;
	}
	
	public void doWork()
	{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i =0; i< 100; i++)
					increment();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i =0; i< 100; i++)
					increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count :: " + count);
	}

}
