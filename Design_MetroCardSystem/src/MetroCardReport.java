/**
 * This class is used to display the report
 * Card<number> used to travel from <source_station> to station <destination_station>. Fare is Rs<x> and balance on card is Rs<x>.
 * @author kumaj04
 *
 */
public class MetroCardReport {
	private JourneyDetail journeyDetail;
	private Integer fareCharged;
	private Integer existingBalance;
	
	public MetroCardReport(JourneyDetail journeyDetail, Integer fareCharged, Integer existingBalance) {
		this.journeyDetail = journeyDetail;
		this.fareCharged = fareCharged;
		this.existingBalance = existingBalance;
	}
}
