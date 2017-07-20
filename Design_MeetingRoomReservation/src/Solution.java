import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Exception.MeetingReservationException;

/**
 * Driver class to which request the meeting room
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) throws MeetingReservationException {
		MeetingRequestValidation requestvalidation = new MeetingRequestValidation();
		
		/**
		 * This is one of the most important point to remember, if we have the DB we will store the information
		 * there. However here we have to store it in list, hashmap, tree etc. So we will create the list, maps 
		 * inside the main class. Example meetingRoomList is created below which store the information about the meeting rooms.
		 */
		List<MeetingRoom> meetingRoomList = new ArrayList<MeetingRoom>();
		//let say we have 5 meeting rooms
		MeetingRoom mr1 = new MeetingRoom("A", 10, new HashSet<Integer>());
		MeetingRoom mr2 = new MeetingRoom("B", 5, new HashSet<Integer>());
		MeetingRoom mr3 = new MeetingRoom("C", 8, new HashSet<Integer>());
		MeetingRoom mr4 = new MeetingRoom("D", 4, new HashSet<Integer>());
		MeetingRoom mr5 = new MeetingRoom("E", 2, new HashSet<Integer>());
		meetingRoomList.add(mr1); meetingRoomList.add(mr2); meetingRoomList.add(mr3); meetingRoomList.add(mr4); meetingRoomList.add(mr5);
		
		// start booking the room
		MeetingReservationApplication reservation = new MeetingReservationApplication(requestvalidation, meetingRoomList);
		
		MeetingRequest request1 = new MeetingRequest("One-to-One", 10, 10);
		MeetingRequest request2 = new MeetingRequest("One-to-One", 1, 10);
		MeetingRequest request3 = new MeetingRequest("One-to-One", 1, 10);
		MeetingRequest request4 = new MeetingRequest("One-to-One", 1, 10);
		MeetingRequest request5 = new MeetingRequest("One-to-One", 1, 10);
		// All rooms are booked for 10 Am so 6th one should fail
		MeetingRequest request6 = new MeetingRequest("One-to-One", 1, 10);
		
		
		reservation.bookMeetingRoom(request1);
		reservation.bookMeetingRoom(request2);
		reservation.bookMeetingRoom(request3);
		reservation.bookMeetingRoom(request4);
		reservation.bookMeetingRoom(request5);
		reservation.bookMeetingRoom(request6);
		
		System.out.println("Hii");
	}
}
