package com.ca.park;

import java.util.ArrayList;
import java.util.List;

import com.ca.slot.ParkingLot;
import com.ca.slot.ParkingSlot;
import com.ca.slot.ReservedSlot;
import com.ca.vehicle.ReservationType;
import com.ca.vehicle.VehicleInfo;
import com.ca.vehicle.VehicleType;

/**
 * Class to park the bike.
 * This is  a service class which has the internal business logic
 * @author kumaj04
 *
 */
public class ParkBike implements ParkVehicle {

	@Override
	public ParkingResponse parkVehicle(VehicleInfo vehicleInfo) {
		// Get the list of avaialable parking slots
		// Get the vehicle type and find out how much slots are required for it
		// Get the reservation type
		// Remove that much slots from the avaialable list and add it to the reserved list

		ParkingSlot slot = new ParkingSlot();
		List<ParkingLot> availableSlotList = slot.getAvailableParkingSlot();
		List<ReservedSlot> reservedSlotList = slot.getReservedParkingSlot();
		VehicleType vehicleType = vehicleInfo.getVehicleType();
		ReservationType reservationType = vehicleInfo.getReservationType();
		Integer slotsRequired = vehicleType.getSlotRequired(vehicleType);
		Integer slotsCount = 0;
		List<Integer> slotIds = new ArrayList<Integer>();
		
		return AllotSlotsToVehicle(vehicleInfo, availableSlotList,
				reservedSlotList, reservationType, slotsRequired, slotsCount,
				slotIds);
	}

	/** Allot the space/slots to the vehicle
	 * @param vehicleInfo
	 * @param availableSlotList
	 * @param reservedSlotList
	 * @param reservationType
	 * @param slotsRequired
	 * @param slotsCount
	 * @param slotIds
	 * @return
	 */
	private ParkingResponse AllotSlotsToVehicle(VehicleInfo vehicleInfo,
			List<ParkingLot> availableSlotList,
			List<ReservedSlot> reservedSlotList,
			ReservationType reservationType, Integer slotsRequired,
			Integer slotsCount, List<Integer> slotIds) {
		ParkingResponse parkingResponse = null;;
		for (int i = 0; i < availableSlotList.size(); i++) {
			 ParkingLot availableSlot = availableSlotList.get(i);
			if(availableSlot.getReservationType().equals(reservationType)) {
				slotsCount++;
				slotIds.add(availableSlot.getSpaceId()); 
				if(slotsCount == slotsRequired) {
					// good..We found the required slots
					Integer floorNo = availableSlot.getFloorId();
					 String reservationId = getReservationId(floorNo, slotIds);
					 //Remove the slots from available list and add it into the reserved list
					 removeSlotsFromAvailableSlotList(availableSlotList, slotIds, floorNo);
					 addSlotsInReservedSlotList(reservedSlotList, slotIds, vehicleInfo, floorNo);
					parkingResponse = new ParkingResponse(vehicleInfo.getVehicleNo(), reservationId, vehicleInfo.getParkingTime());
					return parkingResponse;
				}
			} else {
				slotsCount = 0;
				slotIds.clear(); // reset the slots
			}
		}
		return parkingResponse;
	}

	/**
	 * Add the slots into the reserved slot id
	 * @param reservedSlotList
	 * @param slotIds
	 * @param vehicleInfo
	 * @param floorNo
	 */
	private void addSlotsInReservedSlotList( List<ReservedSlot> reservedSlotList, List<Integer> slotIds,
			VehicleInfo vehicleInfo, Integer floorNo) {
		ReservedSlot reservedSlot = new ReservedSlot(slotIds, floorNo, vehicleInfo);
		reservedSlotList.add(reservedSlot);
	}

	/**
	 * Remove the list of lot ids from the available slots
	 * @param availableSlotList
	 * @param slotIds
	 * @param floorNo
	 */
	private void removeSlotsFromAvailableSlotList(List<ParkingLot> availableSlotList,
			List<Integer> slotIds, Integer floorNo) {
		for (ParkingLot availableLot : availableSlotList) {
			for (Integer slotId : slotIds) {
				if(availableLot.getFloorId() == floorNo && availableLot.getSpaceId() == slotId) {
					availableSlotList.remove(availableLot);
				}
			}
		}
		
	}

	private String getReservationId(Integer floorNo, List<Integer> slotIds) {
		StringBuffer reservId = new StringBuffer(floorNo);
		for (Integer slotNo : slotIds) {
			reservId.append("-" + slotNo);
		}
		return reservId.toString();
	}

	@Override
	public void unparkVehicle(VehicleInfo vehicleInfo) {
		//Remove the slots from the reserved slot list
		// and add it into the the available slot list
	}

}
