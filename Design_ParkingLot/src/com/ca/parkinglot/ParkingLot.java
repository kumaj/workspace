package com.ca.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	// call the constructor of the slot class and initialize the 
	// slot space to 20
	Slot slot = new Slot();

	/**
	 * Check whether the parking space is available or not
	 * @param bookInfo
	 * @return 
	 */
	public boolean IsParkingSpaceAvailable(BookingInfo bookInfo) {
		
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE.name())) {
			//search in smaller slots
			List<String> smallerSlots =  slot.getSmallSlots();
			if(smallerSlots.size() == 0)
				return false;
			else 
				return true;
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR.name())) {
			//search in the medium slots
			List<String> mediumSlots = slot.getMediumSlots();
			if(mediumSlots.size() == 0)
				return false;
			else
				return true;
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS.name())) {
			// search in the larger slot
			List<String> largerSlot = new ArrayList<String>();
			if(largerSlot.size() == 0)
				return true;
			else
				return false;
			
		} else
			return false;
	}
	/**
	 * Based upon the type of vehicle, it looks the 
	 * available space in the slot
	 * @param bookInfo
	 * @return
	 */
	public String findAvailableSlot(BookingInfo bookInfo) {
		String availableSlot = "";
		
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE)) {
			List<String> smallerSlots =  slot.getSmallSlots();
			if(smallerSlots.size() == 0)
				return "";
			else 
				availableSlot = smallerSlots.get(0);
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR)) {
			List<String> mediumSlots = slot.getMediumSlots();
			if(mediumSlots.size() == 0) 
				return "";
			else
				availableSlot = mediumSlots.get(0);
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS)) {
			List<String> largerSlot = slot.getLargeSlots();
			if(largerSlot.size() == 0) 
				return "";
			else
				availableSlot = largerSlot.get(0);
			
		} else
			return "";
		return availableSlot;
	}
	
	/**
	 * Find all available slots 
	 * @param bookInfo
	 * @return
	 */
	public List<String> findAllAvailableSlot(BookingInfo bookInfo) {
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE)) {
			return  slot.getSmallSlots();	
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR)) {
			return slot.getMediumSlots();
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS)) {
			return slot.getLargeSlots();	
		} else
			return null;
	}
	
	/**
	 * Find all the booked slots
	 * @param bookInfo
	 * @return
	 */
	public List<BookingInfo> findAllBookedSlot(BookingInfo bookInfo) {
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE)) {
			return  slot.getSmallBookedSlots();	
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR)) {
			return slot.getMediumBookedSlots();
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS)) {
			return slot.getLargeBookedSlots();
		} else
			return null;
	}
	
	/**
	 * Book the slot
	 * @param slotNo
	 */
	public String bookSlot(BookingInfo bookInfo) {
		String seatNo = null;
		// remove the slotNo from the available slot and add into booked category of slot
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE.name())) {
			List<String> smallerSlots =  slot.getSmallSlots();
			if(smallerSlots.size() != 0) {
				//remove it from available slot and put it in booked slot
				seatNo = smallerSlots.remove(0);
				List<BookingInfo> smallerBookedSlots =  slot.getSmallBookedSlots();
				bookInfo.setSeatNo(seatNo);
				smallerBookedSlots.add(bookInfo);
			}
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR.name())) {
			List<String> mediumSlots =  slot.getMediumSlots();
			if(mediumSlots.size() != 0) {
				//remove it from available slot and put it in booked slot
				seatNo = mediumSlots.remove(0);
				List<BookingInfo> mediumBookedSlots =  slot.getMediumBookedSlots();
				bookInfo.setSeatNo(seatNo);
				mediumBookedSlots.add(bookInfo);
			}
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS.name())) {
			List<String> largeSlots =  slot.getLargeSlots();
			if(largeSlots.size() != 0) {
				//remove it from available slot and put it in booked slot
				seatNo = largeSlots.remove(0);
				List<BookingInfo> largeBookedSlots =  slot.getLargeBookedSlots();
				bookInfo.setSeatNo(seatNo);
				largeBookedSlots.add(bookInfo);
			}	
		}
		return seatNo;
	}
	
	/**
	 * Method to vacate the slot
	 * @param seatNo
	 */
	public void unBookSlot(BookingInfo bookInfo) {
		// first check the type of the vehicle
		String seatNo = bookInfo.getSeatNo();
		if(bookInfo.getVehicleType().equals(VehicleType.BIKE)) {
			//remove it from the booked slot
			List<BookingInfo> smallerBookedSlots =  slot.getSmallBookedSlots();
			smallerBookedSlots.remove(bookInfo);
			
			// add into the available slots
			List<String> smallerSlots = slot.getSmallSlots();
			smallerSlots.add(seatNo);
			
		} else if(bookInfo.getVehicleType().equals(VehicleType.CAR)) {
			List<BookingInfo> mediumBookedSlots =  slot.getMediumBookedSlots();
			mediumBookedSlots.remove(bookInfo);
			
			//add into the available seats
			List<String> mediumSlots = slot.getMediumSlots();
			mediumSlots.add(seatNo);
			
		} else if(bookInfo.getVehicleType().equals(VehicleType.BUS)) {
			List<BookingInfo> largeBookedSlots =  slot.getLargeBookedSlots();
			largeBookedSlots.remove(bookInfo);
			
			// add into the available seats
			List<String> largeSlots = slot.getLargeSlots();
			largeSlots.add(seatNo);
		}
	}
}
