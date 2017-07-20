/**
 * Car class which has some properties
 * @author kumaj04
 *
 */
public class Car {
	private int wheels;
	private String colour;
	
	/**
	 * @return the wheels
	 */
	public int getWheels() {
		return wheels;
	}
	/**
	 * @param wheels the wheels to set
	 */
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
    @Override
    public String toString() {
        return "Car [wheels = " + wheels + ", color = " + colour + "]";
    }
}
