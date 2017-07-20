/**
 * 
 * @author kumaj04
 *
 */
public class MeetingReservation {
	private MeetingRoom meetingRoom;
	private MeetingRequest meetingRequest;
	private boolean bookingStatus;
	/**
	 * @return the meetingRoom
	 */
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	/**
	 * @return the meetingRequest
	 */
	public MeetingRequest getMeetingRequest() {
		return meetingRequest;
	}
	/**
	 * @param meetingRequest the meetingRequest to set
	 */
	public void setMeetingRequest(MeetingRequest meetingRequest) {
		this.meetingRequest = meetingRequest;
	}
	/**
	 * @return the bookingStatus
	 */
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
