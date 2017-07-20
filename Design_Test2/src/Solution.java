/**
 * In Design_Test project, replace the "company" interface with a class and then check the process.
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Company compA = new DeptA();
		Company compB = new DeptB();
		
		Company c = new Company();
		c.addCommonEmployees("Comm_0");
		compA.addCommonEmployees("Comm_1");
		compB.addCommonEmployees("Comm_2");
		
		compA.printCommonEmployees();
		
		DeptA deptA = new DeptA();
		DeptB deptB = new DeptB();
		deptA.AddDeptAEmp("Nitish");
		deptB.AddDeptBEmp("Chandan");
		deptA.printDeptAEmp();
		deptB.printDeptBEmp();
		
		deptA.addCommonEmployees("Comm_3");
		deptB.addCommonEmployees("Comm_4");
		
		deptB.printCommonEmployees();
		
		DeptA deptA2 = new DeptA();
		DeptB deptB2 = new DeptB();
		deptA2.AddDeptAEmp("Manish");
		deptB2.AddDeptBEmp("Roy");
		deptA2.printDeptAEmp();
		deptB2.printDeptBEmp();
	}
}
