package com.ca.park;

import com.ca.vehicle.VehicleInfo;

/**
 * Interface to park, unpark and shift the vehicle
 * Why should we have 3 different parking classes. Why can't one?
 * Let's we have to make the change in parking scheme of bus, then the 
 * modification will be done in ParkBus class only. Rest of the classes 
 * remains un affected.
 * So it's better to create different parking classes for diferent types of parking
 * @author kumaj04
 *
 */
public interface ParkVehicle {
	// These 2 methods should not contains the list of reserved and unreserved arraylist
	// as why should user pass the this list as one of the argument.
	// Your application should internally get the list.
	public ParkingResponse parkVehicle(VehicleInfo vehicleInfo);
	public void unparkVehicle(VehicleInfo vehicleInfo);
}
