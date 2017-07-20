import java.util.HashMap;

import Exception.MetroTravelException;

/**
 * This class handles the journey of a customer
 * @author kumaj04
 *
 */
public class MetroJourney implements Runnable{
	
	private JourneyDetail journeyDetail;
	private HashMap<String, Integer> stNameIdMap;
	private HashMap<String, Integer> footFallMap;
	
	public MetroJourney() { }
	public MetroJourney(JourneyDetail journeyDetail, HashMap<String, Integer> stNameIdMap, HashMap<String, Integer> footFallMap) {
		this.setJourneyDetail(journeyDetail);
		this.stNameIdMap = stNameIdMap;
		this.footFallMap = footFallMap;
	}

	@Override
	public void run() {
		try {
			travel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the journeyDetail
	 */
	public JourneyDetail getJourneyDetail() {
		return journeyDetail;
	}
	/**
	 * @param journeyDetail the journeyDetail to set
	 */
	public void setJourneyDetail(JourneyDetail journeyDetail) {
		this.journeyDetail = journeyDetail;
	}
	
	/**
	 * 
	 * @param journeyDetail
	 * @return
	 * @throws Exception 
	 */
	public synchronized boolean travel() throws Exception {
		System.out.println("Inside travel : " + Thread.currentThread().getName());
		Boolean travelStatus = false;
		try {
			Integer fareAmount = getJourneyFare(journeyDetail);
			deductFareFromCard(journeyDetail, fareAmount);
			updateFootFall(journeyDetail);
			travelStatus = true;
		} catch(MetroTravelException ex) {
			throw new Exception("Exception in travel " + ex);
		}
		return travelStatus;
	}
	
	/**
	 * @param journeyDetail
	 */
	private void updateFootFall(JourneyDetail journeyDetail) throws MetroTravelException {
		//add the footfall --> swipeIn = Entry station and swipeOut = Exit station
		String startSt = journeyDetail.getStartStation();
		String endSt = journeyDetail.getEndStation();
		
		Integer swipeInCount = footFallMap.get(startSt);
		footFallMap.put(journeyDetail.getStartStation(), ++swipeInCount);
		
		Integer swipeOutCount = footFallMap.get(endSt);
		footFallMap.put(endSt, ++swipeOutCount);
	}
	
	/**
	 * @param journeyDetail
	 * @param fareAmount
	 * @throws MetroTravelException
	 */
	private void deductFareFromCard(JourneyDetail journeyDetail,
			Integer fareAmount) throws MetroTravelException {
		//once you get the fare deduct the amount from the metro card
		//So get the metro card and deduct the amount from it
		MetroCard metroCard = journeyDetail.getMetroCard();
		Integer currentBalance = metroCard.getBalance();
		if(currentBalance < fareAmount) {
			throw new MetroTravelException("Insufficient balance in card");
		} else {
			//deduct the amount
			System.out.println("Amount deducted : " + fareAmount);
			metroCard.setBalance(currentBalance-fareAmount);
		}
	}
	
	/**
	 * @param journeyDetail
	 * @return
	 */
	private Integer getJourneyFare(JourneyDetail journeyDetail) throws MetroTravelException {
		// Get the fare calculator factory
		MetroFareCalculatorFactory calculatorFactory = new MetroFareCalculatorFactory();
		MetroFareCalculator fareCalculator = calculatorFactory.getFareCalculator(journeyDetail);
		Integer fareAmount = fareCalculator.calculateFare(journeyDetail, stNameIdMap);
		System.out.println("Journey Fare from " + journeyDetail.getStartStation() + " to " + journeyDetail.getEndStation() + " : " + fareAmount);
		return fareAmount;
	}

}
