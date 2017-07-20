package com.ca.vehicle;
/**
 * Enum to list down the type of vehicle being supported and slot required by each of them.
 * As of now we are supporting 3 types of vehicle.
 * @author kumaj04
 *
 */
public enum VehicleType {
	Bike(1), // Bike require 1 unit of slot
	Car(2),  // Car requires 2 unit of slot
	Bus(4)   // Bus requires 4 unit of slot
	;
	
	private int slotRequired;
	private VehicleType(int slotRequired) {
		this.slotRequired = slotRequired;
	}
	
	//Get the slot required for vehicle type
	public int getSlotRequired(VehicleType vehicleType) {
		return vehicleType.slotRequired;
	}
}
