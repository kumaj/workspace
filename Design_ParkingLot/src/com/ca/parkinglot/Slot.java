package com.ca.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds 3 types of slots
 * @author kumaj04
 *
 */
public class Slot {

	private String slotNo;

	// Available slots
	private List<String> smallFreeSlots;
	private List<String> mediumFreeSlots;
	private List<String> largeFreeSlots;
	
	// Booked Slot
	private List<BookingInfo> smallBookedSlots;
	private List<BookingInfo> mediumBookedSlots;
	private List<BookingInfo> largeBookedSlots;
	
	// Assume that 20 slots are available for each type of vehicle
	public Slot() {
		smallFreeSlots = new ArrayList<String>(20);
		mediumFreeSlots = new ArrayList<String>(20);
		largeFreeSlots = new ArrayList<String>(20);
		assignSeatNumber(smallFreeSlots, "S");
		assignSeatNumber(mediumFreeSlots, "M");
		assignSeatNumber(largeFreeSlots, "L");
	}
	
	/**
	 * attach seat name to each seats
	 * S1, S2....S20
	 * M1, M2....M20
	 * L1, L2....L20
	 * @param smallSlots
	 * @param seatName
	 */
	private void assignSeatNumber(List<String> smallSlots, String seatName) {
		for(int i = 1; i <= 20; i++) {
			String no = String.valueOf(i);
			smallSlots.add(seatName + no);
		}	
	}

	public List<String> getSmallSlots() {
		return smallFreeSlots;
	}
	   public void setSmallSlots(List<String> smallSlots) {
		this.smallFreeSlots = smallSlots;
	}
	public List<String> getMediumSlots() {
		return mediumFreeSlots;
	}
	public void setMediumSlots(List<String> mediumSlots) {
		this.mediumFreeSlots = mediumSlots;
	}
	public List<String> getLargeSlots() {
		return largeFreeSlots;
	}
	public void setLargeSlots(List<String> largeSlots) {
		this.largeFreeSlots = largeSlots;
	}
	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public List<BookingInfo> getSmallBookedSlots() {
		return smallBookedSlots;
	}

	public void setSmallBookedSlots(List<BookingInfo> smallBookedSlots) {
		this.smallBookedSlots = smallBookedSlots;
	}

	public List<BookingInfo> getMediumBookedSlots() {
		return mediumBookedSlots;
	}

	public void setMediumBookedSlots(List<BookingInfo> mediumBookedSlots) {
		this.mediumBookedSlots = mediumBookedSlots;
	}

	public List<BookingInfo> getLargeBookedSlots() {
		return largeBookedSlots;
	}

	public void setLargeBookedSlots(List<BookingInfo> largeBookedSlots) {
		this.largeBookedSlots = largeBookedSlots;
	}
}
