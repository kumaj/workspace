import java.util.HashMap;

/**
 * Calculate the weekend fare.
 * Weekday - Rs 7 * (Number of stations travelled)
 * @author kumaj04
 *
 */
public class MetroWeekdaysFare implements MetroFareCalculator {
	
	private int basefarePerStation;
	private int discount; // discount if any
	private int upSurgeAmount; // charge could be upsurge during holidays and festival time
	private HashMap<String, Integer> stNameIdMap;

	@Override
	public Integer calculateFare(JourneyDetail journeyDetail, HashMap<String, Integer> stNameIdMap) {
		//get the start and end station and find the distance between them
		// find whether the journey is on weekdays or weekend
		String startSt = journeyDetail.getStartStation();
		Integer startStId = stNameIdMap.get(startSt);
		String endSt = journeyDetail.getEndStation();
		Integer endStId = stNameIdMap.get(endSt);
		Integer distBetweenSt = Math.abs(endStId - startStId);
	   return distBetweenSt*7;
	}

}
