/**
 * This is the implementation of the factory design pattern
 * @author kumaj04
 *
 */
public class MetroFareCalculatorFactory {

	public MetroFareCalculatorFactory() {
	}
	
	public MetroFareCalculator getFareCalculator(JourneyDetail journeyDetail) {
		// Get the journey time
		JourneyTime jt = journeyDetail.getJourneyTime();
		switch(jt) {
			case Weekdays: 
				return new MetroWeekdaysFare();
		case Weekend:
				return new MetroWeekendFare();
		default:
			break;
		}
		return null;
	}
}
