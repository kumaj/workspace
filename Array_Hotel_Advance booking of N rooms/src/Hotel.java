import java.util.ArrayList;

/*
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
Input:
First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.

Example :

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room. 
 */
public class Hotel {
	 public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		 boolean res = true;
		 
		 int day = 1;
		 int arr_lastday = arrive.get(arrive.size() - 1);
		 int dep_lastday = depart.get(depart.size() - 1);
		 int lastday = Math.max(arr_lastday, dep_lastday);
		 
		 int i = 0;
		 int j = 0;
		 int room_req = 0;
		 while(day <= lastday) {
			 if(arrive.get(i) == day) {
				 room_req++;
				 i++;
			 }
			 if(depart.get(j) == day) {
				 room_req--; 
				 j++;
			 }
			 
			 if(K < room_req) {
				 res = false;
				 break;
			 }
			 day++;
		 }
		 return res;
	 }
}

class Solution {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(3); a.add(5);
		
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(2); d.add(6);d.add(8);
		
		int K = 1;
		
		Hotel h = new Hotel();
		System.out.println(h.hotel(a, d, K));
		
	}
}
