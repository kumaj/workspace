// http://www.javaworld.com/article/2074996/hashcode-and-equals-method-in-java-object---a-pragmatic-concept.html

//Don't override the hashcode and equals and then compare between the objects
public class Employee {
	private int age;
	
	public Employee(int age) {
		this.age = age;
	}
}

//override the equals only and then compare the objects
class Student {
	private int age;
	
	public Student(int age) {
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		Student st = (Student) obj;
		if(this.age == st.age)
			return true;
		return false;
	}
}

//Overide the hashcode and equals both and then compare the objects.
class Person {
	private int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hash code has been called inside Person class");
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		Person st = (Person) obj;
		if(this.age == st.age)
			return true;
		return false;
	}
}
//Override the hash method only and compare the objects
class User {
	private int age;
	
	public User(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
}

class Solution {
	public static void main(String[] args) {
		
		Employee e1 = new Employee(23);
		Employee e2 = new Employee(23);
		//What would be the result ?
		System.out.println(e1.equals(e2));
		System.out.println(e1 == e2);
		
		Student s1 = new Student(23);
		Student s2 = new Student(23);
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		
		Person p1 = new Person(23);
		Person p2 = new Person(23);
		System.out.println(p1.equals(p2));
		System.out.println(p1 == p2); //compare the reference of two objects. Here reference are different.
		
		User u1 = new User(23);
		User u2 = new User(23);
		System.out.println(u1.equals(u2));
		System.out.println(u1 == u2);
	}
}
