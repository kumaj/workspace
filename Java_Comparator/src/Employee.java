import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.print.attribute.standard.Compression;

// This example will give the insight about the use of the comparator class
// http://howtodoinjava.com/search-sort/when-to-use-comparable-and-comparator-interfaces-in-java/
//https://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
public class Employee {

	private int empId;
	private String name;
	
	public Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

class EmpNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
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
		
		//Let's try to sort the employee objects
		ArrayList<Employee> empArr = new ArrayList<Employee>();
		empArr.add(emp1); empArr.add(emp2); empArr.add(emp3); empArr.add(emp4); empArr.add(emp5);
		//comparision has been made on the basis of names
		//Collections.sort(empArr);  // Here employee class should implement the comparable interface and not the comparator interface  as per the guidelines of the sort method
		
		// To use the comparator method, a new comparator class has been created "EmpNameComparator"
		//Collections.sort(empArr, new EmpNameComparator());
		
		//OR 
		empArr.sort(new EmpNameComparator());
	
		
		for (Employee emp : empArr) {
			System.out.print(emp.getName() + " ");
		}
		

	}
}

