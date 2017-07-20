/**
 * Actual implementation of car builder which builds the actual car.
 * So first of all get the new car
 * @author kumaj04
 *
 */
public class CarBuilderImpl implements CarBuilder {

	private Car car;
	public CarBuilderImpl() {
		car = new Car();
	}
	
	@Override
	public CarBuilder setWheels(int wheels) {
		car.setWheels(wheels);
		System.out.println(this);
		return this;
	}

	@Override
	public CarBuilder setColour(String colour) {
		car.setColour(colour);
		System.out.println(this);
		return this;
	}

	@Override
	public Car build() {
		System.out.println(car);
		return car;
	}

}
