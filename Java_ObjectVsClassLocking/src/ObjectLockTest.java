import java.util.ArrayList;
import java.util.List;


/**
 * This class illustrate the use of object level locking
 * http://stackoverflow.com/questions/3718148/java-class-level-lock-vs-object-level-lock
 * @author kumaj04
 *
 */
public class ObjectLockTest implements Runnable {
	private List<Integer> list;
	private Object objLock;
	private Integer count;
	
	public ObjectLockTest(Object objLock, Integer count) {
		list = new ArrayList<Integer>();
		this.objLock = objLock;
		this.count = count;
	}

	/**
	 * @return the list
	 */
	public List<Integer> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		// Here list and count both are shared element among the thread.
		// So there is need to do the synchronization
		// other than objLock what are the other avialable objects which can be used for locking?
		// can we locking on the 'ObjectLockTest.class'. if yes then how is it working? 
		// 'ObjectLockTest.class' is a class level locking. 
		//  prevents multiple threads to enter in synchronized block in any of all available instances 
		// This means if in runtime there are 100 instances of  DemoClass, then only one thread will be able to execute 
		// here if you want to turn objLock into class level locking then convert the objLock as static
		// It’s possible that both static synchronized and non static synchronized method can run simultaneously
		// 	or concurrently because they lock on different object.
		// http://howtodoinjava.com/core-java/multi-threading/thread-synchronization-object-level-locking-and-class-level-locking/
		testMethod();
		synchronized (objLock) {
			for(int i = 0; i<5; i++) {
				System.out.println("Added by" + Thread.currentThread().getName() + " : " + count);
				list.add(count);
				count = count + 10;
			}
		}
		//testMethod();
	}

	/**
	 * Since this method is not synchronized it will get called without any issue.
	 */
	private void testMethod() {
		System.out.println("TestMethod() called " + Thread.currentThread().getName());
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}	
}

