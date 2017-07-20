import java.util.HashMap;

/**
 * This is the base interface to calculate the fare.
 * As of now fare can be calculated based on weekdays and weekend.
 * In future it can also be calculated based upon monthly, quaterly and yearly basis.
 * @author kumaj04
 *
 */
public interface MetroFareCalculator {
	
	public Integer calculateFare(JourneyDetail journeyDetail, HashMap<String, Integer> stNameIdMap);
}
