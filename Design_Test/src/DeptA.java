import java.util.ArrayList;
import java.util.List;

/**
 * Each department has its own list of individual employees. 
 * @author kumaj04
 *
 */
public class DeptA implements Company {

	//static list so that all objects of deptB will access the same list.
	// otherwise each object will create its own list which we won't want.
	private static List<String> deptAEmployeesList = new ArrayList<String>();
	
	/**
	 * @return the deptAEmployees
	 */
	public List<String> getDeptAEmployees() {
		return deptAEmployeesList;
	}

	/**
	 * @param deptAEmployees the deptAEmployees to set
	 */
	public void setDeptAEmployees(List<String> deptAEmployees) {
		DeptA.deptAEmployeesList = deptAEmployees;
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
	 * Add employee A into list
	 * @param empB
	 */
	public void AddDeptAEmp(String empA) {
		deptAEmployeesList.add(empA);
	}
	
	public void removeDeptAEmp(String empA) {
		deptAEmployeesList.remove(empA);
	}
	
	public void printDeptAEmp() {
		for (String empName : deptAEmployeesList) {
			System.out.println(empName);
		}
	}
}
