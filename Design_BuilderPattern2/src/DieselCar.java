/**
 * 
 * @author kumaj04
 *
 */
public class DieselCar extends Car {
	
	private int dieselCapacity;
	

	/**
	 * @return the dieselCapacity
	 */
	public int getDieselCapacity() {
		return dieselCapacity;
	}
	/**
	 * @param dieselCapacity the dieselCapacity to set
	 */
	public void setDieselCapacity(int dieselCapacity) {
		this.dieselCapacity = dieselCapacity;
	}
	
    @Override
    public String toString() {
        return "Car [wheels = " + getWheels() + ", color = " + getColour() +  ", dieselCapacity =" + dieselCapacity + "]";
    }
}
