/**
 * 
 * @author kumaj04
 *
 */
public class Deadlock implements Runnable{

	Account fromAccount;
	Account toAccount;
	double amount;
	
	public Deadlock(Account fromAccount, Account toAccount, double amount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		transferAmount(fromAccount, toAccount, amount);
	}
	
	public boolean transferAmount(Account fromAccount, Account toAccount, double amount) {
		System.out.println("waiting for fromAccount lock");
		synchronized (fromAccount) {
			System.out.println("Aquired fromAccount lock");
			
			System.out.println("waiting for toAccount lock");
			synchronized (toAccount) {
				System.out.println("Aquired toAccount lock");
				fromAccount.debitAmount(amount);
				toAccount.creditAccount(amount);
				return true;
			}
		}
	}

}

class Account {
	String fromAccountNo;
	String toAccountNo;
	double currentAmount;
	
	public double getCurrentAmount() {
		return 1000.0;
	}
	
	public double debitAmount(double amount) {
		return currentAmount - amount; 
	}
	
	public double creditAccount(double amount) {
		return currentAmount + amount;
	}
}

class Solution {
	public static void main(String[] args) {
		Account fromAccount = new Account();
		Account toAccount = new Account();
		
		Deadlock d1 = new Deadlock(fromAccount, toAccount, 100);
		Deadlock d2 = new Deadlock(fromAccount, toAccount, 200);
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		
		t1.start();
		t2.start();
	}
}
