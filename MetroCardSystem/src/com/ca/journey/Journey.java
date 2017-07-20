package com.ca.journey;

import com.ca.station.Station;
import com.ca.station.StationA;
import com.ca.station.StationB;
import com.ca.station.StationC;

/**
 * This class is dedicated for the jouney of the passenger
 * @author kumaj04
 *
 */
public class Journey {

	/**
	 * Mark the start of the journey
	 * @param stationName
	 */
	public void startJourney(String stationName, Integer cardNo) {
		if(stationName.equals("A")) {
			//delegate the call to stationA
			Station st = new StationA();
			st.enterStation(cardNo);
		} else if(stationName.equals("B")) {
			Station st = new StationB();
			st.enterStation(cardNo);
		} else if(stationName.equals("C")) {
			Station st = new StationC();
			st.exitStation(cardNo);
		}
	}
	
	/**
	 * mark the end of the jouney
	 * @param stationName
	 */
	public void endJourney(String stationName, Integer cardNo) {
		if(stationName.equals("A")) {
			//delegate the call to stationA
			Station st = new StationA();
			st.exitStation(cardNo);
		} else if(stationName.equals("B")) {
			Station st = new StationB();
			st.exitStation(cardNo);
		} else if(stationName.equals("C")) {
			Station st = new StationC();
			st.exitStation(cardNo);
		}
	}
}
