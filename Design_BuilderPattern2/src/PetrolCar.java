/**
 * 
 * @author kumaj04
 *
 */
public class PetrolCar extends Car {
	private int petrolCapacity;

	/**
	 * @return the petrolCapacity
	 */
	public int getPetrolCapacity() {
		return petrolCapacity;
	}
	/**
	 * @param petrolCapacity the petrolCapacity to set
	 */
	public void setPetrolCapacity(int petrolCapacity) {
		this.petrolCapacity = petrolCapacity;
	}
	
    @Override
    public String toString() {
        return "Car [wheels = " + getWheels() + ", color = " + getColour() +  ", petrolCapacity =" + petrolCapacity + "]";
    }
}
