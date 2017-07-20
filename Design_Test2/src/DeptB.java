import java.util.ArrayList;
import java.util.List;

/**
 * DeptB
 * @author kumaj04
 *
 */
public class DeptB extends Company {
	private static List<String> deptBEmployeesList = new ArrayList<String>();
	
	/**
	 * Add employee B into list
	 * @param empB
	 */
	public void AddDeptBEmp(String empA) {
		deptBEmployeesList.add(empA);
	}
	
	public void removeDeptBEmp(String empA) {
		deptBEmployeesList.remove(empA);
	}
	
	public void printDeptBEmp() {
		for (String empName : deptBEmployeesList) {
			System.out.println(empName);
		}
	}
}
