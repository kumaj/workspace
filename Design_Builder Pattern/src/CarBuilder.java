/**
 * Builder interface whcih will be called by driver class to set
 * the no of wheels and colour. This job can also be called using the 
 * call of several constructor
 * @author kumaj04
 *
 */
public interface CarBuilder {
	CarBuilder setWheels(int wheels);
	CarBuilder setColour(String colour);
	Car build();
}
