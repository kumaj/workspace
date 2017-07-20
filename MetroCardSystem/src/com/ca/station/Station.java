package com.ca.station;

/**
 * Interface for all the classes
 * @author kumaj04
 *
 */
public interface Station {
	
	public void enterStation(Integer cardNo);
	
	/**
	 * At exit of the station
	 * @param cardNo
	 * @return
	 */
	public void exitStation(Integer cardNo);
}
