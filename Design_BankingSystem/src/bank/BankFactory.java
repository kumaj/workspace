package bank;

public class BankFactory {
	
	private BankFactory() {	}
	
	public Bank getBankInstance(BankType bankType) {
		switch (bankType) {
		case Consumer:
			return new ConsumerBank();
		case Planning:
			return new PlanningBank();
		case Investment:
			return new InvestmentBank();
		default:
			return null;
		}
	}
}
