import java.util.List;

/**
 * Driver class
 * @author kumaj04
 *
 */
public class Solution {

	public static void main(String[] args) {
		//Initialise 2 branches
		BankBranch branch1 = new BankBranch("1", "Hyd");
		BankBranch branch2 = new BankBranch("2", "Patna");
		
		//Initilase bank employee
		BankEmployee emp1 = new BankEmployee("Ajit", "1");
		BankEmployee emp2 = new BankEmployee("Kumar", "2");
		
		//Add branch and emp in list
		Bank bank1 = new Bank("Sree");
		List<BankBranch> branchList = bank1.getBranchList();
		List<BankEmployee> employeeList = bank1.getEmployeeList();
		
		branchList.add(branch1);
		branchList.add(branch2);
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		
		System.out.println(branchList);
		System.out.println(employeeList);
		
		//If someone create a new object of the bank, he should get the same list of branch and employee.
		BankBranch branch3 = new BankBranch("3", "Phulwari");
		
		//Initilase bank employee
		BankEmployee emp3 = new BankEmployee("Rana", "3");
		
		//Add branch and emp in list
		Bank bank2 = new Bank("Sree");
		List<BankBranch> branchList2 = bank2.getBranchList();
		List<BankEmployee> employeeList2 = bank2.getEmployeeList();
		
		branchList.add(branch3);
		employeeList.add(emp3);
		
		System.out.println(branchList2);
		System.out.println(employeeList2);
		
	}
}
