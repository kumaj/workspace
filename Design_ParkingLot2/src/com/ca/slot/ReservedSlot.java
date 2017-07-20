package com.ca.slot;
import java.util.List;

import com.ca.vehicle.VehicleInfo;

/**
 * Response class contains the details about the parking reservation information
 * @author kumaj04
 *
 */
public class ReservedSlot {
	private List<Integer> slotIds; // list of slots booked for the vehicle
	private Integer floorNo; // floor on which the vehicle is booked
	private VehicleInfo vehicleInfo; // Which type of vehicle is boooked, vehicle no, owner mobile no and parking time 
	
	public ReservedSlot(List<Integer> slotIds, Integer floorNo, VehicleInfo vehicleInfo) {
		this.slotIds = slotIds;
		this.floorNo = floorNo;
		this.vehicleInfo = vehicleInfo;
	}
}
