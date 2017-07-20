import java.util.HashMap;

/**
 * This class represent the station attribute and its respective APIs
 * @author kumaj04
 *
 */
public class MetroStation {
	private String stationName;
	private Integer stationId; // stationId is used to calculate the no of station betwwen 2 station.
	private HashMap<String, Integer> stNameIdMap;
	private HashMap<String, Integer> footFallMap;
	
	public MetroStation() { }
	public MetroStation(String stationName, Integer stationId, HashMap<String, Integer> stNameIdMap, HashMap<String, Integer> footFallMap) {
		this.stationName = stationName;
		this.stationId = stationId;
		stNameIdMap.put(stationName, stationId); // store the staionName and station ID 
		footFallMap.put(stationName, 0); // initially there is no footfall for a station
	}
	

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	/**
	 * @return the stationId
	 */
	public int getStationId() {
		return stationId;
	}

	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	
	/**
	 * Method to get the stationId from its name
	 * Here the id is getting generated dynamically
	 * Another way is to store the stationName and its Id in key value map.
	 * @param stName
	 * @return
	 */
	public Integer getStationId(java.lang.String stName) {
		Integer stationId = 0;
		java.lang.String code = stName.substring(1);
		stationId = Integer.valueOf(code);
		return stationId;
	}
	/**
	 * @return the stNameIdMap
	 */
	public HashMap<String, Integer> getStNameIdMap() {
		return stNameIdMap;
	}
	/**
	 * @param stNameIdMap the stNameIdMap to set
	 */
	public void setStNameIdMap(HashMap<String, Integer> stNameIdMap) {
		this.stNameIdMap = stNameIdMap;
	}
}
