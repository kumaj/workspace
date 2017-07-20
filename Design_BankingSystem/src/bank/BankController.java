package bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class to manage the banks, its employee and its branches
 * @author kumaj04
 *
 */
public class BankController {

	
	private BankFactory bankFactory;
	
	public BankController() {
		bankFactory = new BankFactory();
	}
	
	/**
	 * Method to allocate the branch manager.
	 * @param managerName
	 * @param bankType
	 */
	public void AllocateBranchManager(String managerName, BankType bankType) {
		Bank bank = bankFactory.getBankInstance(bankType);
		bank.setManagerName(managerName);
	}
	
	/**
	 * Method to add the branch to the list.
	 * @param bankBranch
	 */
	public void addBranch(BankBranch bankBranch) {
		branchList.add(bankBranch);
	}
	
	/**
	 * Method to remove the branch name from the list
	 * @param bankBranch
	 */
	public void removeBranch(BankBranch bankBranch) {
		branchList.remove(bankBranch);
	}
	
	/**
	 * Method to update the branch details
	 * @param bankBranch
	 */
	public void updateBranchDetails(BankBranch bankBranch) {
		System.out.println("Updated the branch details");
	}
}
