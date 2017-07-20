/**
 * 
 * @author kumaj04
 *
 */
public class MeetingRequest {
	private String meetingName;
	private int noOfParticipant;
	private int startTime;
	
	public MeetingRequest(String meetingName, int noOfParticipant, int startTime) {
		this.meetingName = meetingName;
		this.noOfParticipant = noOfParticipant;
		this.startTime = startTime;
	}
	
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public int getNoOfParticipant() {
		return noOfParticipant;
	}
	public void setNoOfParticipant(int noOfParticipant) {
		this.noOfParticipant = noOfParticipant;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
}
