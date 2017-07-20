import Exception.CardRechargeException;

/**
 * This class handles the recharge of the metro card.
 * @author kumaj04
 *
 */
public class MetroCardRecharge {

	private MetroCard metroCard;
	public MetroCardRecharge() { }
	
	public boolean rechargeMetroCard(MetroCard metroCard, int rechargeAmt) throws CardRechargeException {
		Boolean rechargeStatus = false;
		//get the existing balance of card
		int existingBalance = metroCard.getBalance();
		metroCard.setBalance(existingBalance + rechargeAmt);
		rechargeStatus = true;
		return rechargeStatus;
	}
	
	/**
	 * There could be couple of others methods as well like
	 * rechargeOnMonthlyBasis, on quterly, yearly logic will change as per the discount
	 * So this class holds the single responsibility of recharge of the metro card.
	 */
}
