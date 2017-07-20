package Exception;

public class MetroTravelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	public MetroTravelException() {
		super();
	}
	
	public MetroTravelException(String message) {
		super(message);
	}
	
	public MetroTravelException(Throwable cause) {
		super(cause);
	}
	
	public MetroTravelException(Throwable cause, String message) {
		super(message, cause);
	}
}
