package com.ca.uml.dependency;

/**
 * @author kumaj04
 *
 */
public class Car extends Vehicle {

	WheelManufacturer wheel;
	EngineManufacturer engine;
	
	@Override
	public String assembleVehicle() {
		return createCar(wheel, engine);
	}
	
	private String createCar(WheelManufacturer wheel, EngineManufacturer engine) {
		return wheel.produceWheel() + engine.ManufactureEngine();
	}
}
