package ComparableVsComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * This class shows the difference between comparable vs comparator
 * Comparable --> compareTo(Object o1)
 * Comparator --> compare(Object o1, Object o2)
 * usually as of now we have sorted the collections which contains integer or string
 */
public class Employee implements Comparable<Employee>  {

	private Integer empNo;
	private String name;
	
	public Employee(Integer empNo, String name) {
		this.empNo = empNo;
		this.name = name;
	}
	
	@Override
//	So how this guy will be called and in what scenario ?
	// What would be the 
	public int compareTo(Employee o) {
		//implement the compare based upon the name
		return this.name.compareToIgnoreCase(o.name);
	}
	
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		//So tell me when this method will be called and how it will be called ?
		public void  ToString() {
			System.out.println("ToString() method has been called in Emplyoee class");
			System.out.println(empNo + " " +  name);
		}
}

//Let's try to see the comparator class

class Student {
	private Integer rollNo;
	private String name;
	
	public Student(Integer rollno, String name) {
		this.rollNo = rollno;
		this.name = name;
	}
	
	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//So tell me when this method will be called and how it will be called ?
	public void  ToString() {
		System.out.println("ToString() method has been called in Student class");
		System.out.println("Roll no is " + rollNo + " " + " having name " + name);
	}
}

//created a new comparator class to make the comparision based upon rollNo
class StuRollNoComparator implements Comparator<Student> {
	
	public int compare(Student o1, Student o2) {
		return o1.getRollNo().compareTo(o2.getRollNo());
	}
}

//Created a new comparator class to make the comparision based upon name.
class StuNameComparator implements Comparator<Student> {
	public int compare(Student o1, Student o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
}


class Solution {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Aoo");
		Employee emp2 = new Employee(2, "Coo");
		Employee emp3 = new Employee(2, "Eoo");
		Employee emp4 = new Employee(2, "Doo");
		Employee emp5 = new Employee(2, "Boo");
		
		Integer[] a = {6,2,3,1,4};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
		//sort the integer. 
		Collections.sort(arr);
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		//Let's try to sort the employee objects
		ArrayList<Employee> empArr = new ArrayList<Employee>();
		empArr.add(emp1); empArr.add(emp2); empArr.add(emp3); empArr.add(emp4); empArr.add(emp5);
		//comparision has been made on the basis of names
		Collections.sort(empArr);  // If we fail to implement the compareTo() method in emplyoee then
		                          //the method sort in the type collections is not applicable for the arguments
		                         // and you will get the compilation error.
		for (Employee emp : empArr) {
			System.out.print(emp.getName() + " ");
		}

	}
}
