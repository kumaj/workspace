import java.util.HashMap;

/**
*Weekend - Rs 5.5 * (Number of station traveled if it is Saturday or Sunday )
(* there could be more such fare strategies in future).
 * @author kumaj04
 *
 */
public class MetroWeekendFare implements MetroFareCalculator {

	@Override
	public Integer calculateFare(JourneyDetail journeyDetail, HashMap<String, Integer> stNameIdMap) {
		//get the start and end station and find the distance between them
		// find whether the journey is on weekdays or weekend
		String startSt = journeyDetail.getStartStation();
		Integer startStId = stNameIdMap.get(startSt);
		String endSt = journeyDetail.getEndStation();
		Integer endStId = stNameIdMap.get(endSt);
		Integer distBetweenSt = Math.abs(endStId - startStId);
	   return distBetweenSt*5;
	}

}
