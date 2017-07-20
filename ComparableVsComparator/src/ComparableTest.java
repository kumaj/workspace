import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author kumaj04
 * This class illustrate the use of comparable and comparator interface
 * https://www.tutorialspoint.com/java/java_using_comparator.htm
 */
public class ComparableTest {
// sort the elelments of an array which contains Student class objects
	List<Student> studentArr = new ArrayList<Student>();
	public void AddStudent(Student student) {
		studentArr.add(student);
	}
	
	public List<Student> getStudentArr() {
		return studentArr;
	}
	
	public void setStudentArr(List<Student> studentArr) {
		this.studentArr = studentArr;
	}
}

class Student implements Comparable<Student>, Comparator<Student> {
	String name;
	Integer rollNo;
	
	public Student() {
	}
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public int compareTo(Student st) {
		return this.name.compareTo(st.getName());
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.rollNo;
	}

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getRollNo() - o2.getRollNo();
	}
}

class Solution {
	public static void main(String[] args) {
		ComparableTest c = new ComparableTest();
		c.AddStudent(new Student("Subhash", 20));
		c.AddStudent(new Student("Praveen", 10));
		c.AddStudent(new Student("Ajit", 40));
		c.AddStudent(new Student("Manish", 30));

		//Sort the arraylist. It will sort using the comparable interface
		Collections.sort(c.getStudentArr());
		System.out.println(c.getStudentArr());
		
		// It will sort using the comparator interfcae using the anonymous function
		Collections.sort(c.getStudentArr(), new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getRollNo() - o2.getRollNo();
			}
		});
		
		System.out.println(c.getStudentArr());
		
		//it will sort the objects based upon the comparator class
		// here u can do one more thing. Create a new class and ask it to implement comparator interface
		//So rather than using new Student we have to write new ClassXXX(). We have just seggregated the  
		Collections.sort(c.getStudentArr(), new Student());
		System.out.println(c.getStudentArr());
	}
}
