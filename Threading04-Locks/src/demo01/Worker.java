//This class will demonstrate the disadvantage of the synchronized methods.
package demo01;

import java.util.ArrayList;

public class Worker {
	
	//create 2 list
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	
	// create 2 methods to fill the 2 lists
	private synchronized void stageOne()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stageOne" + Thread.currentThread().getName());
		for(int i = 0; i< 10; i++)
			list1.add(i);
	}
	
	private synchronized void stageTwo()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stageTwo" + Thread.currentThread().getName());
		for(int i = 0; i< 10; i++)
			list2.add(i);
	}
	
	//create another method to call these 2 methods
	private void process()
	{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				stageOne();
				stageTwo();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				stageOne();
				stageTwo();
			}
		});
		t1.start();
		t2.start();	
		
		//join both the thread
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doWork()
	{
		long start = System.currentTimeMillis();
		// call the process method
		process();
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken.. " + (end - start));
		System.out.println("list1 : " + list1.size());
		System.out.println("list2 : " + list2.size());
	}
}
