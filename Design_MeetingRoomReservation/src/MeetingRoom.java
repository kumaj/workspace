import java.util.HashSet;
import java.util.List;

/**
 * MeetingRoom contains the attribute related to meeting room 
 * Few methods like get the capacity, get avaialable slot, booked slots
 * @author kumaj04
 *
 */
public class MeetingRoom {
	private String name;
	private int capacity;
	private HashSet<Integer> bookedSlot;
	
	//Default constructor
	public MeetingRoom() {
		
	}
	public MeetingRoom(String name, int capacity, HashSet<Integer> bookedSlot) {
		this.name = name;
		this.capacity = capacity;
		this.bookedSlot = bookedSlot;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the bookedSlot
	 */
	public HashSet<Integer> getBookedSlot() {
		return bookedSlot;
	}
	/**
	 * @param bookedSlot the bookedSlot to set
	 */
	public void setBookedSlot(HashSet<Integer> bookedSlot) {
		this.bookedSlot = bookedSlot;
	}
	
	public List<Integer> getAvaialableSlot() {
		return null;
		
	}
}
