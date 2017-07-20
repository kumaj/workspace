package account.exception;

public class AccountManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountManagerException() {
		super();
	}
	
	public AccountManagerException(String message) {
		super(message);
	}
	
	public AccountManagerException(Throwable cause) {
		super(cause);
	}

}
