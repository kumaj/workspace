import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kumaj04
 * If the runnable target is same for 2 or more thread and methods are synchronized then the thread will execute the methods seqentially
 * If some threads are synchronized and some are not-synchronized then race condition will happen on non-synchronized methods. 
 */
public class Student implements Runnable {

	private String name;
	private String age;
	//list to store the names of the student
	List<String> namesList = new ArrayList<String>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
	//Put synchronized keyword and see the diff
	public void AddStudentName() {
		System.out.println("AddStudentName() is called by " + Thread.currentThread().getName());
		for(int i = 1; i<= 100; i++)
			namesList.add("Ajit_" + i);
	}
	
	//Put synchronized keyword and see the diff
	public void getStudentCount() {
		System.out.println("getStudentCount() is called by " + Thread.currentThread().getName() + " count : " + namesList.size());
	}
	@Override
	public void run() {
		System.out.println("run() is called by " + Thread.currentThread().getName());
		AddStudentName();
		getStudentCount();
	}

}

class Solution {
	public static void main(String[] args) {
		Student s = new Student();
		//assign the runnable target to the thread;
		//Here the runnale target is same. what would happen if we use another runnable target
		//Student s2 = new Student();
		Thread t1 = new Thread(s, "thread-1");
		Thread t2 = new Thread(s, "Thread-2");
		
		//start the thread
		t1.start();
		t2.start();
		
	}
	
}
