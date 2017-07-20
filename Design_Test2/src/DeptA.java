import java.util.ArrayList;
import java.util.List;

/**
 * DeptA
 * @author kumaj04
 *
 */
public class DeptA extends Company {
	private static List<String> deptAEmployeesList = new ArrayList<String>();
	
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
