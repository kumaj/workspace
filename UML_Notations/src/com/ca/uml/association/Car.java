package com.ca.uml.association;

/**
 * Here car contains the instance of wheel and engine manufacturer.
 * CAR ------> WHEELMANUFACTURER
 * @author kumaj04
 *
 */
public class Car extends Vehicle {

	WheelManufacturer wheel = new WheelManufacturer();
	EngineManufacturer engine = new EngineManufacturer();
	@Override
	public String assembleVehicle() {
		wheel.produceWheel();
		engine.ManufactureEngine();
		return "car";
	}
}
