package account.utility;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Utiltiy class for generic method
 * @author kumaj04
 *
 */
public class AccountUtility {
	private SecureRandom secRandom = new SecureRandom();

	/**
	 * Method to return the unique account no.
	 * @return
	 */
	public BigInteger getNextAccountNo(){
		return new BigInteger(16, secRandom);
	}
}
