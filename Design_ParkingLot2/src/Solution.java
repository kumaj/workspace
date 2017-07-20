import java.util.ArrayList;
import java.util.List;

import com.ca.slot.ParkingLot;
import com.ca.slot.ParkingSlot;
import com.ca.slot.ReservedSlot;

/**
 * Driver class to park, unpark and shift the vehicles
 * Charge the 
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		//initialise the parking lot
		//parking slot consist of parking lot
		List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
		
		//1st Floor
		ParkingLot lot1 = new ParkingLot(1, 1); ParkingLot lot2 = new ParkingLot(1, 2);		ParkingLot lot3 = new ParkingLot(1, 3);		ParkingLot lot4 = new ParkingLot(1, 4);		ParkingLot lot5 = new ParkingLot(1, 5);
		ParkingLot lot6 = new ParkingLot(1, 6);		ParkingLot lot7 = new ParkingLot(1, 7);		ParkingLot lot8 = new ParkingLot(1, 8);		ParkingLot lot9 = new ParkingLot(1, 9);		ParkingLot lot10 = new ParkingLot(1, 10);
		
		// 2nd Floor
		ParkingLot lot11 = new ParkingLot(2, 1);	ParkingLot lot12 = new ParkingLot(2, 2);    ParkingLot lot13 = new ParkingLot(2, 3);	ParkingLot lot14 = new ParkingLot(2, 4);	ParkingLot lot15 = new ParkingLot(2, 5);
		ParkingLot lot16 = new ParkingLot(2, 6);	ParkingLot lot17 = new ParkingLot(2, 7);	ParkingLot lot18 = new ParkingLot(2, 8);	ParkingLot lot19 = new ParkingLot(2, 9);	ParkingLot lot20 = new ParkingLot(2, 10);
		
		// 3rd Floor
		ParkingLot lot21 = new ParkingLot(3, 1);	ParkingLot lot22 = new ParkingLot(3, 2);	ParkingLot lot23 = new ParkingLot(3, 3);	ParkingLot lot24 = new ParkingLot(3, 4);	ParkingLot lot25 = new ParkingLot(3, 5);
		ParkingLot lot26 = new ParkingLot(3, 1);	ParkingLot lot27 = new ParkingLot(3, 7);	ParkingLot lot28 = new ParkingLot(3, 8);	ParkingLot lot29 = new ParkingLot(3, 9);	ParkingLot lot30 = new ParkingLot(3, 10);
		
		// 4th Floor
		ParkingLot lot31 = new ParkingLot(4, 1);	ParkingLot lot32 = new ParkingLot(4, 2);	ParkingLot lot33 = new ParkingLot(4, 3);	ParkingLot lot34 = new ParkingLot(4, 4);	ParkingLot lot35 = new ParkingLot(4, 5);
		ParkingLot lot36 = new ParkingLot(1, 1);	ParkingLot lot37 = new ParkingLot(1, 7);	ParkingLot lot38 = new ParkingLot(1, 8);	ParkingLot lot39 = new ParkingLot(1, 9);	ParkingLot lot40 = new ParkingLot(1, 10);
		
		// 5th Floor
		ParkingLot lot41 = new ParkingLot(5, 1);	ParkingLot lot42 = new ParkingLot(5, 2);	ParkingLot lot43 = new ParkingLot(5, 3);	ParkingLot lot44 = new ParkingLot(5, 4);	ParkingLot lot45 = new ParkingLot(5, 5);
		ParkingLot lot46 = new ParkingLot(5, 1);	ParkingLot lot47 = new ParkingLot(5, 7);	ParkingLot lot48 = new ParkingLot(5, 8);	ParkingLot lot49 = new ParkingLot(5, 9);	ParkingLot lot50 = new ParkingLot(5, 10);
		
		parkingLotList.add(lot1);parkingLotList.add(lot2);parkingLotList.add(lot3);parkingLotList.add(lot4);parkingLotList.add(lot5);parkingLotList.add(lot6);parkingLotList.add(lot7);parkingLotList.add(lot8);parkingLotList.add(lot9);parkingLotList.add(lot10);
		parkingLotList.add(lot11);parkingLotList.add(lot12);parkingLotList.add(lot13);parkingLotList.add(lot14);parkingLotList.add(lot15);parkingLotList.add(lot16);parkingLotList.add(lot17);parkingLotList.add(lot18);parkingLotList.add(lot19);parkingLotList.add(lot20);
		parkingLotList.add(lot21);parkingLotList.add(lot22);parkingLotList.add(lot23);parkingLotList.add(lot24);parkingLotList.add(lot25);parkingLotList.add(lot26);parkingLotList.add(lot27);parkingLotList.add(lot28);parkingLotList.add(lot29);parkingLotList.add(lot30);
		parkingLotList.add(lot31);parkingLotList.add(lot32);parkingLotList.add(lot33);parkingLotList.add(lot34);parkingLotList.add(lot35);parkingLotList.add(lot36);parkingLotList.add(lot37);parkingLotList.add(lot38);parkingLotList.add(lot39);parkingLotList.add(lot40);
		parkingLotList.add(lot41);parkingLotList.add(lot42);parkingLotList.add(lot43);parkingLotList.add(lot44);parkingLotList.add(lot45);parkingLotList.add(lot46);parkingLotList.add(lot47);parkingLotList.add(lot48);parkingLotList.add(lot49);parkingLotList.add(lot50);
		
		// Initially there is no reserved slot
		List<ReservedSlot> reservedParkingSlotList = new ArrayList<ReservedSlot>();
	    ParkingSlot slots = new ParkingSlot(parkingLotList, reservedParkingSlotList);
	    
	}
}
