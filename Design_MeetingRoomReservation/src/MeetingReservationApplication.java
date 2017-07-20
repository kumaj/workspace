import java.util.List;

import Exception.MeetingReservationException;

/**
 * This class is responsible for booking of meeting room.
 * This will act as a controller class. 
 * Use case :-
 * 1. Meeting can be booked from 9 to 6
 * 2. Meeting can be booked for a min and max of 1 hr.
 * @author kumaj04
 *
 */
public class MeetingReservationApplication {

	private MeetingRequestValidation meetingRequestValidation;
	private List<MeetingRoom> meetingRoomList;
	
	public MeetingReservationApplication(MeetingRequestValidation requestvalidation, List<MeetingRoom> meetingRoomList) {
		this.meetingRequestValidation = requestvalidation;
		this.meetingRoomList = meetingRoomList;
	}
	
	public MeetingReservation bookMeetingRoom(MeetingRequest request) throws MeetingReservationException {
		MeetingReservation meetingReservation = null;
		
		// First do the validation of the meeting request.
		meetingRequestValidation.validateRequest(request);
		
		// Check the avaialibilty of the room and book the room
		MeetingReservationProcess process = new MeetingReservationProcess();
		MeetingRoom meetingRoom = process.InitiateRoomBooking(meetingRoomList, request);
		
		if(meetingRoom == null)
			throw new MeetingReservationException("No meeting room is avaialble");
		
		meetingReservation = new MeetingReservation();
		meetingReservation.setBookingStatus(true);
		meetingReservation.setMeetingRoom(meetingRoom);
		meetingReservation.setMeetingRequest(request);
		
		return meetingReservation;
	}
}
