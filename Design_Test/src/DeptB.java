import java.util.ArrayList;
import java.util.List;


public class DeptB implements Company {

	//static list so that all objects of deptB will access the same list.
	// otherwise each object will create its own list which we won't want.
	private static List<String> deptBEmployeesList = new ArrayList<String>();
	
	/**
	 * @return the deptBEmployees
	 */
	public static List<String> getDeptBEmployees() {
		return deptBEmployeesList;
	}

	/**
	 * @param deptBEmployees the deptBEmployees to set
	 */
	public static void setDeptBEmployees(List<String> deptBEmployees) {
		DeptB.deptBEmployeesList = deptBEmployees;
	}


	@Override
	public void addCommonEmployees(String empName) {
		commonEmployeesList.add(empName);
	}

	@Override
	public void removeCommonEmployees(String empName) {
		commonEmployeesList.remove(empName);
	}

	@Override
	public void printCommonEmployees() {
		for (String empName : commonEmployeesList) {
			System.out.println(empName);
		}
	}
	
	/**
	 * Add employee B into list
	 * @param empB
	 */
	public void AddDeptBEmp(String empB) {
		deptBEmployeesList.add(empB);
	}
	
	public void removeDeptBEmp(String empB) {
		deptBEmployeesList.remove(empB);
	}
	
	public void printDeptBEmp() {
		for (String empName : deptBEmployeesList) {
			System.out.println(empName);
		}
	}
}
