


public class User implements Runnable{

	private static String firstName;
	private static String lastName;
	private static int age;
	
	public static int getAge() {
		return age;
	}
	public void setAge(int age) {
		User.age = age;
	}
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}
	
	// A static method cannot access the non-static method
	public static String getFullName(String aliasName) {
		System.out.println("Start accessing getFullName");
		return aliasName + " : " +  firstName + lastName;
	}
	
	//Get the diff of age between father and son and multilpy by diffvalue
	public static int calculateDiff(int fatherAge, int diffValue) {
		System.out.println("Start accessing calculateDiff");
		return (fatherAge - age) * diffValue;
	}
	
	@Override
	public void run() {
		//Thread will call the run method
		System.out.println("Run method has been called..");
		System.out.println(getFullName("chotu"));
		System.out.println(calculateDiff(70,2));
	}

}

class Solution {
	
	//Create two threads and access the static methods.
	Thread t1 = new Thread(new User(), "Thread2");
	Thread t2 = new Thread(new User(), "Thread2");
	
	t1.start();
}
