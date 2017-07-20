import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * http://javarevisited.blogspot.in/2011/04/top-10-java-serialization-interview.html
 * read some rules about the serialization
 * http://stackoverflow.com/questions/16442802/will-serialization-save-the-superclass-fields
 * String and all the wrapper classes implements the serializable interface.
 * If the parent class implements the serializable interface then it subclasses will also inherit the serialization
 * But if only subclass implement the serializable interface then what would be the behaviour?
 * @author kumaj04
 *
 */
public class Person {
	private String address;
	private Integer id;
	
	public Person() {
		System.out.println("Default constructor has been called in Person class");
		this.address = "Address has been initialised throgh default constructor in person class";
	}
	
	public Person(String address, Integer id) {
		System.out.println("Person Constructor has been called");
		this.setAddress(address);
		this.setId(id);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}

class Student extends Person implements Serializable {
	private Integer rollNo;
	private List<Integer> totalStudents;
	
	public Student(String address, Integer id, Integer rollNo, List<Integer> totalStudents) {
		super(address, id);
		System.out.println("Student Constructor has been called");
		this.setRollNo(rollNo);
		this.setTotalStudents(totalStudents);
	}

	/**
	 * @return the rollNo
	 */
	public Integer getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the totalStudents
	 */
	public List<Integer> getTotalStudents() {
		return totalStudents;
	}

	/**
	 * @param totalStudents the totalStudents to set
	 */
	public void setTotalStudents(List<Integer> totalStudents) {
		this.totalStudents = totalStudents;
	}	
}

class Solution {
	public static void main(String[] args) throws IOException {
		FileOutputStream fl = new FileOutputStream(new File("C://Ser.txt"));
		//Let's create the ObjectOutPut stream
		ObjectOutputStream out = new ObjectOutputStream(fl);
		
		Person p = new Person("Hyd", 1);
		List<Integer> totalStudents = new ArrayList<Integer>();
		totalStudents.add(100);
		Student s = new Student("Hyd", 1, 10, totalStudents);
		
		//Lets write the object into the file system
/*		out.writeObject(p);
		out.flush();
		System.out.println("Success");*/
		// Here it will throw Exception in thread "main" java.io.NotSerializableException: Person
		// because person class doesn't implement the serializable interface
		
		//let check for the student class where it has implemented the serializable interface but its parent doesn't.
		out.writeObject(s);
		out.flush();
		System.out.println("Successs in serializing the student object");
		
		//let's go ahead and deserialize it
		// Observe that still the super class doesn't implement the serializable interface
		//If it had been implemented the serializable interface then there won't be any problem
		FileInputStream fin = new FileInputStream(new File("C://Ser.txt"));
		ObjectInputStream inp = new ObjectInputStream(fin);
		
		try {
			Student st = (Student) inp.readObject();
			
			/**
			 * If you don't provide the default constructor inside the super class i.e, inside person class
			 * then it will throw exception Exception in thread "main" java.io.InvalidClassException: Student; no valid constructor
			 * http://stackoverflow.com/questions/9747443/java-io-invalidclassexception-no-valid-constructor
			 */
			System.out.println("Person Address : " + st.getAddress());
			System.out.println("Person ID: " + st.getId());
			System.out.println("Student Roll No : " + st.getRollNo());
			System.out.println("Student count : " + st.getTotalStudents());
			/**
			 * During deserialization, the fields of non-serializable classes will be initialized using 
			 * the public or protected no-arg constructor of the class. A no-arg constructor must be accessible 
			 * to the subclass that is serializable. The fields of serializable subclasses will be restored from the stream.
			 */
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
