//Can we write the demo01 program in a different way ? 
package demo02;

class doWork implements Runnable
{
	//shared resources
	private int count = 0;
	
	// 1st method to incr the count
	public void incrCount01()
	{
		for(int i = 0; i< 10000; i++)
			count++;
	}
	// 2nd method to incr the count
	public void incrCount02()
	{
		for(int i = 0; i< 10000; i++)
			count++;
	}
	
	//override the run method
	public void run()
	{
		incrCount01();
		incrCount02();
		//what would be the vakue of the count ?
		System.out.println("count :: " + count);
	}
}

public class demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new doWork());
		t1.start();
	}

}
