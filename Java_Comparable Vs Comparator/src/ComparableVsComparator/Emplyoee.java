package ComparableVsComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Problem : Sort the emplyoee objects based upon its empId
 */
public class Emplyoee {
	
	private Integer empId;
	private String empName;
	
	//create a constructor
	public Emplyoee(Integer id, String name) {
		empId = id;
		empName = name;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}

//This class has been written so that the employee2 objects can be
// sorted using the collections.sort() method
class Emplyoee2 implements Comparable<Emplyoee2> {
	
	private Integer empId;
	private String empName;
	
	//create a constructor
	public Emplyoee2(Integer id, String name) {
		empId = id;
		empName = name;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	//comparison of the employee objects has been done on the basis of emplyoee Id
	//What will happen when i will comment the @override annotation.
	public int compareTo(Emplyoee2 o) {
		// TODO Auto-generated method stub
		return this.empId - o.empId;
	}
	
	@Override
	public String toString() {
		//return empId + " " + empName;
		// return String.format("Person[name: %s, %s]", empName, empId);
		return String.format("%s,  %s", empId, empName);
	}
}

class Solution {
	
	public static void main(String[] args) {
		//Try to use the sort to sort the string data structure
		String[] strArr = { "bb","ee","ff","uu","aa"};
		ArrayList<String> strlist = new ArrayList<String>(Arrays.asList(strArr));
		
		//sort the array and arraylist both
		//Internally String has implemented IComparable interface 
		Arrays.sort(strArr);
		Collections.sort(strlist);
		
		for (String str : strlist) {
			System.out.print(str + " ");
		}
		
		// Now create some employee objects and try to sort it
		Emplyoee e1 = new Emplyoee(1, "cc");
		Emplyoee e2 = new Emplyoee(1, "aa");
		Emplyoee e3 = new Emplyoee(1, "ff");
		Emplyoee e4 = new Emplyoee(1, "bb");
		Emplyoee e5 = new Emplyoee(1, "dd");
		
		//store all the employee in the araayList and try to sort it
		ArrayList<Emplyoee> empList = new ArrayList<Emplyoee>();
		empList.add(e1); empList.add(e2); empList.add(e3); empList.add(e4); empList.add(e5);
		System.out.println();
		
		// sort the employee object
		//it failed to sort it stating that the argument of sort() "ArrayList<Emplyoee> is not applicable"
		//Collections.sort(empList);
		
		//So in order to overcome this problem we have to implement comparable interface
		//This has been done in Emplyoee2 class
		Emplyoee2 ee1 = new Emplyoee2(12, "cc");
		Emplyoee2 ee2 = new Emplyoee2(2, "aa");
		Emplyoee2 ee3 = new Emplyoee2(1, "ff");
		Emplyoee2 ee4 = new Emplyoee2(4, "bb");
		Emplyoee2 ee5 = new Emplyoee2(3, "dd");
		
		//store all the employee in the araayList and try to sort it
		ArrayList<Emplyoee2> empList2 = new ArrayList<Emplyoee2>();
		empList2.add(ee1); empList2.add(ee2); empList2.add(ee3); empList2.add(ee4); empList2.add(ee5);
		Collections.sort(empList2);
		
		for (Emplyoee2 em2 : empList2) {
			System.out.println(em2 + "");  // http://stackoverflow.com/questions/29140402/how-do-i-print-my-java-object-without-getting-sometype2f92e0f4
			// All Java objects have a toString() method, which is invoked when you try and print the object.
			// So override the toString() methd
		}
	}
	
}
