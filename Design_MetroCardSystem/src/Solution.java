import java.util.HashMap;

import Exception.CardRechargeException;
import Exception.MetroTravelException;

/**
 * https://getinterviewinfo.wordpress.com/2014/11/05/sapient-interview-nov-2014/
 * http://interviewquestionsatsapientforjava.blogspot.in/
 * https://javainterviews.scribbleit.in/question-bank/design-metro-smart-card-system-for-delhi-using-java/p/AnPDBA
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		// To initiate the travel, commuter needs to have a proper metrocard.
		// Initially card has been created with zero balance
		MetroCard card1 = new MetroCard("100", 0); 
		//Now recharge the card
		MetroCardRecharge recharge = new MetroCardRecharge();
		recharge.rechargeMetroCard(card1, 100);
		
		//Initialise the station
		HashMap<String, Integer> stNameIdMap = new HashMap<String, Integer>();
		HashMap<String, Integer> footFallMap = new HashMap<String, Integer>();
		HashMap<String, MetroCardReport> MetroCardReportMap = new HashMap<String, MetroCardReport>();
		
		MetroStation st1 = new MetroStation("A1", 1, stNameIdMap, footFallMap);
		MetroStation st2 = new MetroStation("A2", 2, stNameIdMap, footFallMap);
		MetroStation st3 = new MetroStation("A3", 3, stNameIdMap, footFallMap);
		MetroStation st4 = new MetroStation("A4", 4, stNameIdMap, footFallMap);
		MetroStation st5 = new MetroStation("A5", 5, stNameIdMap, footFallMap);
		MetroStation st6 = new MetroStation("A6", 6, stNameIdMap, footFallMap);
		MetroStation st7 = new MetroStation("A7", 7, stNameIdMap, footFallMap);
		MetroStation st8 = new MetroStation("A8", 8, stNameIdMap, footFallMap);
		MetroStation st9 = new MetroStation("A9", 9, stNameIdMap, footFallMap);
		MetroStation st10 = new MetroStation("A10", 10, stNameIdMap, footFallMap);
		
		
		//Now let's start the first journey
		JourneyDetail journeyDetail = new JourneyDetail("A1", "A2", card1, JourneyTime.Weekdays);		
		MetroJourney j1 = new MetroJourney(journeyDetail, stNameIdMap, footFallMap);
		Thread t1 = new Thread(j1, "Journey1");

		
		
		//Now let's start the 2nd journey
		JourneyDetail journeyDetail2 = new JourneyDetail("A1", "A4", card1, JourneyTime.Weekdays);		
		MetroJourney j2 = new MetroJourney(journeyDetail2, stNameIdMap, footFallMap);
		Thread t2 = new Thread(j2, "Journey2");

		
		//Now let's start the 3rd journey
		JourneyDetail journeyDetail3 = new JourneyDetail("A2", "A4", card1, JourneyTime.Weekdays);		
		MetroJourney j3 = new MetroJourney(journeyDetail3, stNameIdMap, footFallMap);
		Thread t3 = new Thread(j3, "Journey3");
		
		//Now let's start the 4th journey
		JourneyDetail journeyDetail4 = new JourneyDetail("A3", "A4", card1, JourneyTime.Weekend);		
		MetroJourney j4 = new MetroJourney(journeyDetail4, stNameIdMap, footFallMap);
		Thread t4 = new Thread(j4, "Journey4");

		
		//Now let's start the 5th journey
		JourneyDetail journeyDetail5 = new JourneyDetail("A6", "A4", card1, JourneyTime.Weekend);		
		MetroJourney j5 = new MetroJourney(journeyDetail5, stNameIdMap, footFallMap);
		Thread t5 = new Thread(j5, "Journey5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t4.join();
		
		// 1st
		System.out.println("Initiating journey.." + "Start Station : " + journeyDetail.getStartStation() + " End Station : " + journeyDetail.getEndStation());
		System.out.println("Initial Balance : " + card1.getBalance());
		//System.out.println("Travel Status : " + j1.travel());
		System.out.println("Balance After Journey : " + card1.getBalance());
		System.out.println("Footfall at start station : " + footFallMap.get(journeyDetail.getStartStation()));
		System.out.println("Footfall at end   station : " + footFallMap.get(journeyDetail.getEndStation()));
		
		//2nd
		System.out.println("Initiating journey.." + "Start Station : " + journeyDetail2.getStartStation() + " End Station : " + journeyDetail2.getEndStation());
		System.out.println("Initial Balance : " + card1.getBalance());
		//System.out.println("Travel Status : " + j2.travel());
		System.out.println("Balance After Journey : " + card1.getBalance());
		System.out.println("Footfall at start station : " + footFallMap.get(journeyDetail2.getStartStation()));
		System.out.println("Footfall at end   station : " + footFallMap.get(journeyDetail2.getEndStation()));
		
		// 3rd
		System.out.println("Initiating journey.." + "Start Station : " + journeyDetail3.getStartStation() + " End Station : " + journeyDetail3.getEndStation());
		System.out.println("Initial Balance : " + card1.getBalance());
		//System.out.println("Travel Status : " + j3.travel());
		System.out.println("Balance After Journey : " + card1.getBalance());
		System.out.println("Footfall at start station : " + footFallMap.get(journeyDetail3.getStartStation()));
		System.out.println("Footfall at end   station : " + footFallMap.get(journeyDetail3.getEndStation()));
		
		//4th
		System.out.println("Initiating journey.." + "Start Station : " + journeyDetail4.getStartStation() + " End Station : " + journeyDetail4.getEndStation());
		System.out.println("Initial Balance : " + card1.getBalance());
		//System.out.println("Travel Status : " + j4.travel());
		System.out.println("Balance After Journey : " + card1.getBalance());
		System.out.println("Footfall at start station : " + footFallMap.get(journeyDetail4.getStartStation()));
		System.out.println("Footfall at end   station : " + footFallMap.get(journeyDetail4.getEndStation()));
		
		// 5th
		System.out.println("Initiating journey.." + "Start Station : " + journeyDetail5.getStartStation() + " End Station : " + journeyDetail5.getEndStation());
		System.out.println("Initial Balance : " + card1.getBalance());
		//System.out.println("Travel Status : " + j5.travel());
		System.out.println("Balance After Journey : " + card1.getBalance());
		System.out.println("Footfall at start station : " + footFallMap.get(journeyDetail5.getStartStation()));
		System.out.println("Footfall at end   station : " + footFallMap.get(journeyDetail5.getEndStation()));
		
		
	}
}
