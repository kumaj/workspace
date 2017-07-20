package com.ca.station;

public class StationC implements Station{

	private static final String code = "B";
	private static String name = "B";
	private static Integer totalPassenger;
	
	@Override
	public void enterStation(Integer cardNo) {
		System.out.println("Entered into station B");
		totalPassenger++;
	}

	public Integer getTotalPassenger() {
		return totalPassenger;
	}

	@Override
	public void exitStation(Integer cardNo) {
		System.out.println("Exited station B");
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
