package com.ca.parkinglot;

import java.util.Scanner;

/**
 * This class contains the main method 
 * @author kumaj04
 *
 */
public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		// get the vehicle details
		while(true) {
			System.out.println("Enter Name : ");
			String name = in.nextLine();
			
			System.out.println("Enter  Vehicle type {BIKE, CAR, BUS}: ");
			String vehicleType = in.nextLine();
			
			System.out.println("Enter LicenseNo : ");
			String licenseNo = in.nextLine();
			
			BookingInfo bookInfo = new BookingInfo();
			bookInfo.setVehicleOwner(name);
			bookInfo.setVehicleType(vehicleType);
			bookInfo.setLicenseNo(licenseNo);
			
			ParkingLot plot = new ParkingLot();
			// case 1: Park a bike
			// Check if slot is available or not
			if(plot.IsParkingSpaceAvailable(bookInfo)) {
				String seatNo = plot.bookSlot(bookInfo);
				
				if(seatNo != null)
					System.out.println("Successfully alloted seat : " + seatNo);
				else
					System.out.println("Failed to book seat as all slots are full");
			}
			
			//Unpark a car
			
			System.out.println("Want to quit. Press 'q'");
			String text = in.nextLine();
			if(text.equals("q"))
				break;
		}
		
	}
}
