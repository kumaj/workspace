package com.ca.slot;
import java.util.List;

import com.ca.vehicle.ReservationType;
import com.ca.vehicle.VehicleType;

/**
 * Class which contains the list of parking lot
 * @author kumaj04
 *
 */
public class ParkingSlot {
	// This list contains the available parking slots. There should be another list which contains the list 
	// of reserved slot
	private List<ParkingLot> availableParkingSlot;
	private List<ReservedSlot> reservedParkingSlot;
	
	public ParkingSlot() {};
	
	public ParkingSlot(List<ParkingLot> availableParkingSlot, List<ReservedSlot> reservedParkingSlot) {
		this.availableParkingSlot = availableParkingSlot;
		this.setReservedParkingSlot(reservedParkingSlot);
	}
	
	// Now you the list of the parking lot
	//So assign some of the floors to the handicapped, VIP and Common
	// charges will be collected based upon the reservation status
	
	/**
	 * Reserve the parking floor for specific types of people
	 * like handicap, vip and common
	 * @param floorNo
	 * @param reservationType
	 */
	public void reserveParkingFloor(Integer floorNo, ReservationType reservationType) {
		for (ParkingLot parkingLot : availableParkingSlot) {
			if(parkingLot.getFloorId() == floorNo) {
				parkingLot.setReservationType(reservationType);
			}
		}
	}
	
	/**
	 * Reserve specific slot on a specific floor with specific reservation type
	 * @param slotId
	 * @param floorNo
	 * @param reservationType
	 */
	public void reserveParkingSlot(Integer slotId, Integer floorNo, ReservationType reservationType) {
		for (ParkingLot parkingLot : availableParkingSlot) {
			if(parkingLot.getFloorId() ==  floorNo && parkingLot.getSpaceId() == slotId) {
				parkingLot.setReservationType(reservationType);
			}
		}
	}
	
	public ReservedSlot park(VehicleType vehicleType, ReservationType reservationType) {
		return null;
		
	}
	
	public void unpark() {
		
	}
	
	public void chargeFare() {
		
	}

	/**
	 * @return the reservedParkingSlot
	 */
	public List<ReservedSlot> getReservedParkingSlot() {
		return reservedParkingSlot;
	}

	/**
	 * @param reservedParkingSlot the reservedParkingSlot to set
	 */
	public void setReservedParkingSlot(List<ReservedSlot> reservedParkingSlot) {
		this.reservedParkingSlot = reservedParkingSlot;
	}

	public List<ParkingLot> getAvailableParkingSlot() {
		return availableParkingSlot;
	}

	public void setAvailableParkingSlot(List<ParkingLot> availableParkingSlot) {
		this.availableParkingSlot = availableParkingSlot;
	}
}
