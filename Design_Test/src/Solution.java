/**
 * Create an interface which has a list which contains common items.
 * This interface is implemented by 2 classes which has its own individual list.
 * Exmaple let say a company is there which has 2 departments. Few employees are common to both the departments
 * (VP, GM, Salried section etc) and each department has its individual employess as well.
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Company compA = new DeptA();
		Company compB = new DeptB();
		
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
