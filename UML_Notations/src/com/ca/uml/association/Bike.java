package com.ca.uml.association;

public class Bike extends Vehicle {
	
	WheelManufacturer wheel = new WheelManufacturer();
	EngineManufacturer engine = new EngineManufacturer();
	@Override
	public String assembleVehicle() {
		wheel.produceWheel();
		engine.ManufactureEngine();
		return "Bike";
	}
}
