
public class ElectricCar extends Car {

	private int watt;
	private int volt;
	
	/**
	 * @return the watt
	 */
	public int getWatt() {
		return watt;
	}
	/**
	 * @param watt the watt to set
	 */
	public void setWatt(int watt) {
		this.watt = watt;
	}
	/**
	 * @return the volt
	 */
	public int getVolt() {
		return volt;
	}
	/**
	 * @param volt the volt to set
	 */
	public void setVolt(int volt) {
		this.volt = volt;
	}
	
    @Override
    public String toString() {
        return "Car [wheels = " + getWheels() + ", color = " + getColour() +  ", watt =" + watt + ", volt = " + volt + "]";
    }
}
