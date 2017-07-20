package com.ca.fare;

import java.sql.Time;

import com.ca.vehicle.ReservationType;
import com.ca.vehicle.VehicleInfo;

/**
 * Interface to charge the fare based upon the vehicle type and its reservation type
 * VIP = Rs.10/- per Hr
 * Normal = Rs.5/- per Hr
 * Handicapped =  Rs. 4/- per Hr 
 * After each 2 hrs, price get double.
 * @author kumaj04
 *
 */
public interface FareCalculator {
	public Double chargeFare(VehicleInfo vehicleInfo, Time parkingTime, ReservationType reservationType);
}
