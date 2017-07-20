import Exception.MeetingReservationException;

/**
 * This class is responsible for validation of the meeting request(payload)
 * @author kumaj04
 *
 */
public class MeetingRequestValidation {

	/**
	 * Method to validate the user meeting request.
	 * @param request
	 * @throws MeetingReservationException
	 */
	public void validateRequest(MeetingRequest request) throws MeetingReservationException {
		if(request == null)
			throw new MeetingReservationException("Meeting request is null");
		if(request.getStartTime() < 9 || request.getStartTime() > 18)
			throw new MeetingReservationException("Meeting can be booked netwwn 9 to 18");
		if(request.getNoOfParticipant() < 1 || request.getNoOfParticipant() > 20) {
			throw new MeetingReservationException("No of participant should be between 1 to 20");
		}
	}
}
