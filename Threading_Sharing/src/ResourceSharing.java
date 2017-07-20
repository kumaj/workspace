import java.util.ArrayList;
import java.util.List;

/**
 * This class shows the sharing of the resource by multiple threads
 * An arraylist has been shared among 2 threads. It will throw concurrent modification exception sometime
 * @author kumaj04
 *
 */
public class ResourceSharing implements Runnable {

	List<Integer> arr = null;
	public ResourceSharing() {
		arr = new ArrayList<Integer>();
	}
	public List<Integer> getArr() {
		return arr;
	}
	public void setArr(List<Integer> arr) {
		this.arr = arr;
	}
	
	@Override
	public void run() {
		//One thread will insert 1 and another thread will insert 2 
		for(int i = 0; i< 10; i++)
			arr.add(1);
		setArr(arr);
	}
	
	// Solution 
	// stop the concurrentmodification exception. only one thread will access the shared resource
/*	@Override
	public void run() {
		InsertNo();
	}
	private synchronized void InsertNo() {
		for(int i = 0; i< 10; i++)
			arr.add(1);
		setArr(arr);
	}*/

}

class Solution {
	public static void main(String[] args) {
		//create 2 threads
		ResourceSharing rs = new ResourceSharing();
		Thread t1 = new Thread(rs, "Thread_1");
		Thread t2 = new Thread(rs, "Thread_2");
		t1.start();
		t2.start();
		
		//Now print the arraylist
		for (int i : rs.getArr()) {
			System.out.print(i + " ");
		}
	}
}
