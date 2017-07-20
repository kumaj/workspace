import java.util.HashSet;
import java.util.List;

/**
 * Class which holds the business logic to book the room
 * @author kumaj04
 *
 */
public class MeetingReservationProcess {

	public MeetingRoom InitiateRoomBooking(List<MeetingRoom> meetingRoomList, MeetingRequest request) {
		MeetingRoom meetingRoom = null;
		//Iterate throgh the list of meeting room and check the availibility
		for (MeetingRoom room : meetingRoomList) {
			//check avaialable timing and capacity of the room
			HashSet<Integer> timing = room.getBookedSlot();
			int capacity = room.getCapacity();
			if(!timing.contains(request.getStartTime()) && capacity >= request.getNoOfParticipant()) {
				timing.add(request.getStartTime());
				meetingRoom = new MeetingRoom(room.getName(), room.getCapacity(), timing);
				return meetingRoom;
			}
		}
		
		return meetingRoom;
		
	}
}
