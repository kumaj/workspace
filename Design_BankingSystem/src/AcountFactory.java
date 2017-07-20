/**
 * Factory design pattern to let the subclasses decide to create the objects.
 * @author kumaj04
 *
 */
public class AcountFactory {

	public Account getAccountInstance(AccountType accountType) {
		
		switch (accountType) {
		case Saving:
			return new SavingAccount();
		case Joint:
			return new JointAccount();
		case Demat:
			return new DematAccount();
		default:
			return null;
		}
	}
}
