package com.ca.slot;
import com.ca.vehicle.ReservationType;
import com.ca.vehicle.VehicleType;

/**
 * There are total 5 floors and each floor has 10 units of avaialble space
 * @author kumaj04
 *
 */
public class ParkingLot {
	private Integer spaceId;
	private Integer floorId;
	private String floorSpaceId;
	private ReservationType reservationType;
	
	public ParkingLot(Integer floorId, Integer spaceId) {
		this.setSpaceId(spaceId);
		this.setFloorId(floorId);
		//Now construct the floor and spaceID together eg. F5_8
		this.setFloorSpaceId("F" + floorId + "_" + spaceId); 
	}
	

	/**
	 * @return the spaceId
	 */
	public Integer getSpaceId() {
		return spaceId;
	}

	/**
	 * @param spaceId the spaceId to set
	 */
	public void setSpaceId(Integer spaceId) {
		this.spaceId = spaceId;
	}

	/**
	 * @return the floorId
	 */
	public Integer getFloorId() {
		return floorId;
	}

	/**
	 * @param floorId the floorId to set
	 */
	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}

	/**
	 * @return the floorSpaceId
	 */
	public String getFloorSpaceId() {
		return floorSpaceId;
	}

	/**
	 * @param floorSpaceId the floorSpaceId to set
	 */
	public void setFloorSpaceId(String floorSpaceId) {
		this.floorSpaceId = floorSpaceId;
	}

	/**
	 * @return the reservationType
	 */
	public ReservationType getReservationType() {
		return reservationType;
	}

	/**
	 * @param reservationType the reservationType to set
	 */
	public void setReservationType(ReservationType reservationType) {
		this.reservationType = reservationType;
	}
}
