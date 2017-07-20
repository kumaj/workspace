/**
 * Diesel car builder implementation
 * @author kumaj04
 *
 */
public class DieselCarBuilderImpl implements CarBuilder {

	private Car dieselCar;
	public DieselCarBuilderImpl() {
		dieselCar = new DieselCar();
	}
	@Override
	public CarBuilder setWheels(int wheels) {
		dieselCar.setWheels(wheels);
		return this;
	}

	@Override
	public CarBuilder setColour(String colour) {
		dieselCar.setColour(colour);
		return this;
	}
	
	public CarBuilder setDieselCapacity(int dieselCapacity) {
		
		return this;
	}
	
	@Override
	public Car build() {
		return dieselCar;
	}

}
