
import java.util.ArrayList;
import java.util.List;

/**
 * There are 3 categories of bank - Planning, Investment and consumer.
 * Each bank has a manager and set of employees. Branches are considered as subdivision of consumer division.
 * Each account holder has been assigned to have a personal banker
 * @author kumaj04
 *
 */
public class Bank {
	private String managerName;
	private static List<BankEmployee> employeeList = new ArrayList<BankEmployee>();
	private static List<BankBranch> branchList = new ArrayList<BankBranch>();
	
	
	public Bank(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the employeeList
	 */
	public List<BankEmployee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(List<BankEmployee> employeeList) {
		Bank.employeeList = employeeList;
	}

	/**
	 * @return the branchList
	 */
	public List<BankBranch> getBranchList() {
		return branchList;
	}

	/**
	 * @param branchList the branchList to set
	 */
	public void setBranchList(List<BankBranch> branchList) {
		Bank.branchList = branchList;
	}
}
