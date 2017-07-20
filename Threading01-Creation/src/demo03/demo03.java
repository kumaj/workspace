//We will create a thread using the anonymous class
package demo03;


public class demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i< 10; i++)
					System.out.println(i);
			}
		});
		t1.start();
	}
}
