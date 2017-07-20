package Exception;
/**
 * Exception to be thrown during the recharge of the card
 * @author kumaj04
 *
 */
public class CardRechargeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CardRechargeException() {
		super();
	}
	
	public CardRechargeException(String message) {
		super(message);
	}
	
	public CardRechargeException(Throwable cause) {
		super(cause);
	}
	
	public CardRechargeException(String message, Throwable cause) {
		super(message, cause);
	}
}
