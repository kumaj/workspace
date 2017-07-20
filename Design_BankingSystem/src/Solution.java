import java.util.ArrayList;
import java.util.List;

import bank.BankBranch;
import bank.BankController;
import account.exception.AccountManagerException;

/**
 * 
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) throws AccountManagerException {
		
		//Call the account manager to create the account.
		AccountManager accMgr = new AccountManager();
		BankController bankContrl = new BankController();
		
		// Initialise the branch first
		BankBranch branch1 = new BankBranch("BOBWALMI", "ADD1");
		BankBranch branch2 = new BankBranch("BOBPHUL", "ADD2");
		BankBranch branch3 = new BankBranch("BOBJANI", "ADD3");
		BankBranch branch4 = new BankBranch("BOBHYD", "ADD4");
		BankBranch branch5 = new BankBranch("BOBPATNA", "ADD5");
		
		bankContrl.addBranch(branch1); bankContrl.addBranch(branch2); bankContrl.addBranch(branch3); bankContrl.addBranch(branch4); bankContrl.addBranch(branch5);
		
		//create saving account
		CustomerInfo customerInfo = new CustomerInfo("Ajit", "Hyderabad", "1111");
		AccountResponse response = accMgr.createAccount(customerInfo, AccountType.Saving);
		System.out.println(response);
		
		//create joint account
		CustomerInfo customerInfo2 = new CustomerInfo("Amit", "Kumar",  "Patna", "2222");
		AccountResponse response2 = accMgr.createAccount(customerInfo2, AccountType.Joint);
		System.out.println(response2);
		
		// create demat account.
		CustomerInfo customerInfo3 = new CustomerInfo("Alok", 1000,  "Bihar", "3333");
		AccountResponse response3 = accMgr.createAccount(customerInfo3, AccountType.Demat);
		System.out.println(response3);
		
		//get all account details
		accMgr.getAllAccountDetails();
		
		//get detail of a specific account
		accMgr.getAccountDetail("BOB_WAlMI_7418", AccountType.Saving);
		
	}
}
