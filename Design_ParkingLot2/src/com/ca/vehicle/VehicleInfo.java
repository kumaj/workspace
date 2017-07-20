package com.ca.vehicle;
import java.util.Date;

/**
 * Class to store the information about the vehicle
 * @author kumaj04
 *
 */
public class VehicleInfo {
	private VehicleType vehicleType; // which type of vehicle
	private ReservationType reservationType; // for which kind of reservation
	private String VehicleNo; // vehicle no
	private String mobileNo; // mobile no
	private Date parkingTime; // parking time
	
	public VehicleInfo() {	}
	
	public VehicleInfo(VehicleType vehicleType, ReservationType reservationType, String vehicleNo, String mobileNo, Date parkingTime) {
		this.vehicleType = vehicleType;
		this.reservationType = reservationType;
		this.VehicleNo = vehicleNo;
		this.mobileNo = mobileNo;
		this.parkingTime = parkingTime;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public ReservationType getReservationType() {
		return reservationType;
	}

	public void setReservationType(ReservationType reservationType) {
		this.reservationType = reservationType;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(Date parkingTime) {
		this.parkingTime = parkingTime;
	}
}
