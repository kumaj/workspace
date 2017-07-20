import java.util.HashMap;

/**
 * What will happen if you won't override hashCode() and equals() methods
 * or override only one of them. So how would be the behaviour in map
 * @author kumaj04
 *
 */
public class Employee {

	private int age;
	
	public Employee(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hash code has been called..");
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals has been called for age : " + (Employee) obj);
		if(obj == null)
			return false;
		Employee st = (Employee) obj;
		if(this.age == st.age)
			return true;
		return false;
	}
}

class Solution {
	public static void main(String[] args) {
		HashMap<Employee, String> map = new HashMap<Employee, String>();
		Employee emp1 = new Employee(100);
		Employee emp2 = new Employee(200);
		Employee emp3 = new Employee(300);
		Employee emp4 = new Employee(400);
		
		map.put(emp1, "emp1 with age 100");
		map.put(emp2, "emp2 with age 200");
		map.put(emp3, "emp3 with age 300");
		map.put(emp4, "emp4 with age 400");
		map.put(emp4, "DUPLICATE emp4 with age 400");
		
		System.out.println("map Size : " + map.size());
		System.out.println(map);
		System.out.println("Contains : " + map.containsKey(new Employee(400)));
		System.out.println("Remove : " + map.remove(new Employee(400)));
		
		/** What will happen if hashcode hasn't been ovverriden and below statement has to executed
		 * 		System.out.println("Contains : " + map.containsKey(emp4));
		System.out.println("Remove : " + map.remove(emp4));
		 */
		System.out.println("map Size : " + map.size());
	}
}