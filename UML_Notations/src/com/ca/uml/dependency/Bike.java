package com.ca.uml.dependency;

public class Bike extends Vehicle {
	
	WheelManufacturer wheel;
	EngineManufacturer engine;
	@Override
	public String assembleVehicle() {
		return createBike(wheel, engine);
	}
	
	private String createBike(WheelManufacturer wheel, EngineManufacturer engine) {
		return wheel.produceWheel() + engine.ManufactureEngine();
	}
}
