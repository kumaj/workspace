/**
 * Car which runs on battery
 * @author kumaj04
 *
 */
public class BatteryCar extends Car {
	private int batteryCapacity;
	
	/**
	 * @return the batteryCapacity
	 */
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	/**
	 * @param batteryCapacity the batteryCapacity to set
	 */
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
    @Override
    public String toString() {
        return "Car [wheels = " + getWheels() + ", color = " + getColour() +  ", batteryCapacity =" + batteryCapacity + "]";
    }
}
