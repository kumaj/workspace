package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Consumer bank which has the list of all its branches and a dedicated 
 * employee to each customer  in form of key value map having account no as key and
 * employee id as its value
 * @author kumaj04
 *
 */
public class ConsumerBank extends Bank {
	private static List<BankBranch> branchList = new ArrayList<BankBranch>(); // static only one copy
	private static HashMap<String, String> customerEmployeeMap = new HashMap<String, String>(); // static only one copy

	public ConsumerBank() { }

	/**
	 * Add the branch to the bank list
	 * @param bankBranch
	 */
	public void addBranch(BankBranch bankBranch) {
		branchList.add(bankBranch);
	}
	
	/**
	 * Remove the bank from the list
	 * @param bankBranch
	 */
	public void removeBranch(BankBranch bankBranch) {
		branchList.remove(bankBranch);
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
		this.branchList = branchList;
	}

	/**
	 * @return the customerEmployeeMap
	 */
	public HashMap<String, String> getCustomerEmployeeMap() {
		return customerEmployeeMap;
	}

	/**
	 * @param customerEmployeeMap the customerEmployeeMap to set
	 */
	public void setCustomerEmployeeMap(HashMap<String, String> customerEmployeeMap) {
		this.customerEmployeeMap = customerEmployeeMap;
	}
}
