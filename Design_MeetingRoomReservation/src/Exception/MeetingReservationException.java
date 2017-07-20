package Exception;

/**
 * This is the customized exception
 * @author kumaj04
 *
 */
public class MeetingReservationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MeetingReservationException() {
		super();
	}
	
	public MeetingReservationException(String message) {
		super(message);
	}
	
	public MeetingReservationException(Throwable throwableArgs) {
		super(throwableArgs);
	}
	
	public MeetingReservationException(String message, Throwable throwableArgs) {
		super(message, throwableArgs);
	}

}
