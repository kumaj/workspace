package com.ca.parkinglot;

/**
 * enum class to store the type of vehicle
 * @author kumaj04
 *
 */
public enum VehicleType {
	BIKE("bike"),
	CAR("car"),
	BUS("bus");
	
	private String value = "";
	
	// Check that the constructor is PRIVATE here.
	private VehicleType(String val) {
		this.value = val;
	}
	
	public String getValue() {
		return value;
	}
}
