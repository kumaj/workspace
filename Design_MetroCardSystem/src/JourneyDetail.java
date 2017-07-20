
/**
 * This class store the information about the journey  information of a user
 * @author kumaj04
 *
 */
public class JourneyDetail {
	private String startStation;
	private String endStation;
	private MetroCard metroCard;
	private JourneyTime journeyTime;
	
	public JourneyDetail() {
		
	}
	
	public JourneyDetail(String startStation, String endStation, MetroCard metroCard, JourneyTime journeyTime) {
		this.setStartStation(startStation);
		this.setEndStation(endStation);
		this.setMetroCard(metroCard);
		this.setJourneyTime(journeyTime);
	}

	/**
	 * @return the startStation
	 */
	public String getStartStation() {
		return startStation;
	}

	/**
	 * @param startStation the startStation to set
	 */
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	/**
	 * @return the endStation
	 */
	public String getEndStation() {
		return endStation;
	}

	/**
	 * @param endStation the endStation to set
	 */
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	/**
	 * @return the metroCard
	 */
	public MetroCard getMetroCard() {
		return metroCard;
	}

	/**
	 * @param metroCard the metroCard to set
	 */
	public void setMetroCard(MetroCard metroCard) {
		this.metroCard = metroCard;
	}

	/**
	 * @return the journeyTime
	 */
	public JourneyTime getJourneyTime() {
		return journeyTime;
	}

	/**
	 * @param weekdays the journeyTime to set
	 */
	public void setJourneyTime(JourneyTime weekdays) {
		this.journeyTime = weekdays;
	}
}
