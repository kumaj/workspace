package com.ca.park;

import java.sql.Time;
import java.util.Date;

/**
 * class contains the response entity once parking has been alloted.
 * @author kumaj04
 *
 */
public class ParkingResponse {
	private String vehicleNo;
	private String reservationId; // This is a combination of Floor and list of slots ids
	private Date parkingTime;
	
	public ParkingResponse(String vehicleNo, String reservationId, Date date) {
		this.vehicleNo = vehicleNo;
		this.reservationId = reservationId;
		this.parkingTime = date;
	}
	
	/**
	 * @return the parkingTime
	 */
	public Time getParkingTime() {
		return parkingTime;
	}
	/**
	 * @param parkingTime the parkingTime to set
	 */
	public void setParkingTime(Time parkingTime) {
		this.parkingTime = parkingTime;
	}
	/**
	 * @return the vehicleNo
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}
	/**
	 * @param vehicleNo the vehicleNo to set
	 */
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	/**
	 * @return the reservationId
	 */
	public String getReservationId() {
		return reservationId;
	}
	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
}
