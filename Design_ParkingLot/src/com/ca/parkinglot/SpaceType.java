package com.ca.parkinglot;

public enum SpaceType {
	SMALL(1),
	MEDIUM(2),
	LARGE(3);
	
	private int value;
	
	// Check that constructor is private here
	private SpaceType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
